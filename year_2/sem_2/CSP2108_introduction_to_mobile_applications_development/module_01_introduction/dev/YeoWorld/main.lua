-- hide the status bar
display.setStatusBar( display.HiddenStatusBar )

-- Fix music
audio.setSessionProperty(audio.MixMode, audio.AmbientMixMode)

-- Require
local cacharro = require("bower_components.cacharro.cacharro")
local middleclass = require("bower_components.middleclass.middleclass")
local ads = require("ads")
local composer = require( "composer" )
local gameNetwork = require("gameNetwork")
local analytics = require("analytics")

--dbconfig.init()
timesPlayed = 0

--Random numbers now more random
math.randomseed( os.time() )

-- local fps = require("helpers.fps")
-- local performance = fps.PerformanceOutput.new();
-- performance.group.x, performance.group.y = (display.contentWidth/2) + (display.viewableContentWidth/2) - 115,  (display.contentHeight / 2) + (display.viewableContentHeight / 2) - 45;
-- performance.group.alpha = 0.5;

local centerX = display.contentWidth / 2
local centerY = display.contentHeight / 2
local halfViewX = display.viewableContentWidth / 2
local halfViewY = display.viewableContentHeight / 2

if cacharro.isSimulator then
	audio.setVolume(0)
	composer.gotoScene("src.scenes.home")
else
	-- ADDS
	local function adListener( event )
		local msg = event.response
		if event.isError then
			-- Failed to receive an ad, we print the error message returned from the library.
			--log(msg)
		end
	end

	if cacharro.isAndroid then
		ads.init( "admob", "ca-app-pub-***", adListener )
		local function initCallback( event )
			if not event.isError then
				-- Tries to automatically log in the user without displaying the login screen if the user doesn't want to login
				gameNetwork.request("login",{ userInitiated = true })
			end
		end

		local function onKeyEvent( event )
			if (event.keyName == "back" and event.phase == 'up') then
				
				local function onComplete( event )
					if "clicked" == event.action then
						local i = event.index
						if 1 == i then
							native.requestExit( )
						end
					end
				end

				local alert = native.showAlert( "Hey Listen!", "Don't go!", {"OK", "Cancel"}, onComplete)
				return true
			end

			return false
		end

		Runtime:addEventListener( "key", onKeyEvent )
		gameNetwork.init( "google", initCallback )
		analytics.init( "***" )
		native.setProperty( "androidSystemUiVisibility", "lowProfile" )
	elseif cacharro.isApple then
		ads.init( "admob", "ca-app-pub-***", adListener )
		gameNetwork.init( "gamecenter")
		analytics.init( "***" )
	end
	analytics.logEvent( "AppStarted" )

	local splash = display.newImage("img/splash.png")
	splash.x = centerX
	splash.y = centerY

	timer.performWithDelay( 5000, function()
		display.remove( splash )
		splash = nil
		back = nil
		composer.gotoScene("src.scenes.home")
	end)
end

local function onSystemEvent( event )
	if event.type == "applicationExit" or event.type == "applicationSuspend" then
		system.cancelNotification( )
		local futureTime = 3600 * 24
		local futureTime2 = futureTime * 7

		local text1 = "Title1"
		local text2 = "Title2"
		local options, options2
		if cacharro.isAndroid then
			options = {
				alert = text1,
			}
			options2 = {
				alert = text2,
			}
		elseif cacharro.isApple then
			options = {
				alert = text1,
				badge =  native.getProperty( "applicationIconBadgeNumber" ) + 1,
			}
			options2 = {
				alert = text2,
				badge =  native.getProperty( "applicationIconBadgeNumber" ) + 1,
			}
		end
		local notificationID = system.scheduleNotification( futureTime, options )
		local notificationID2 = system.scheduleNotification( futureTime2, options2 )
	elseif event.type == "applicationStart" or event.type == "applicationResume" then
		system.cancelNotification( )
	end
end

Runtime:addEventListener( "system", onSystemEvent )

local function notificationListener( event )
	if ( event.type == "local" ) then
		analytics.logEvent("Notification")
		-- log("NOTIFICATION")
	end
end

Runtime:addEventListener( "notification", notificationListener )

local launchArgs = ...

if ( launchArgs and launchArgs.notification ) then
		-- log( "event via launchArgs" )
		notificationListener( launchArgs.notification )
end

--handle the local notification
native.setProperty( "applicationIconBadgeNumber", 0 )