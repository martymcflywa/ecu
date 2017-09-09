-----------------------------------------------------------------------------------------
--
-- questionScene.lua
--
-- This is the scene in which questions are asked and answers checked
--
-----------------------------------------------------------------------------------------

local composer = require( "composer" )

local scene = composer.newScene()

-- -----------------------------------------------------------------------------------
-- Code outside of the scene event functions below will only be executed ONCE unless
-- the scene is removed entirely (not recycled) via "composer.removeScene()"
-- -----------------------------------------------------------------------------------

-- -----------------------------------------------------------------------------------
-- load in questions and answers
-- -----------------------------------------------------------------------------------

local questions = require( "questions" )

-- -----------------------------------------------------------------------------------
-- user interface stuff
-- -----------------------------------------------------------------------------------

local widget = require( "widget" )

-- TextObject to show the current question
local question

-- array of Widgets to show the choices for the answer
local answers
local answerFillColor = { default={1,0,0,1}, over={1,0.1,0.7,0.4} }
local answerStrokeFillColor = { default={1,0.4,0,1}, over={0.8,0.8,1,1} }
local answerWidth = 2*display.contentWidth/5
local answerHeight = display.contentHeight/6

-- sounds initialised in scene:create()
local soundTable = {}
	
-- go on to next question
local function nextQuestion( event )
		questions:setNextQuestion()
		question.text = questions:getQuestionText()
		question:setFillColor(1, 1, 1)
		for i = 1,4 do
			answers[i]:setLabel(questions:getAnswer(i))
		end
end

-- if the user has selected their answer, check it and give feedback, then go to the next question
local function handleAnswer( event )
	if questions:checkAnswer(event.target:getLabel()) then
		question.text = "Correct!"
		question:setFillColor(0, 1, 0)
		audio.play(soundTable["yesSound"])
	else
		question.text = "No! " .. questions:getCorrectAnswer()
		question:setFillColor(1, 0, 0)
		audio.play(soundTable["noSound"])
	end
	-- Wait a couple of seconds before the next question
	timer.performWithDelay(2000, nextQuestion)	
end

-- utility to make a Widget for one of the possible answers
local function makeAnswer( ID, x, y )
	answer = widget.newButton(
			{
				label = questions:getAnswer(ID),
				onRelease = handleAnswer,
				emboss = false,
				-- Properties for a rounded rectangle button
				shape = "roundedRect",
				x = x,
				y = y,
				width = answerWidth,
				height = answerHeight,
				cornerRadius = 2,
				fillColor = answerFillColor,
				strokeColor = answerStrokeFillColor,
				strokeWidth = 4
			}
			)
	return answer
end

-- -----------------------------------------------------------------------------------
-- Scene event functions
-- -----------------------------------------------------------------------------------

-- create()
function scene:create( event )

    local sceneGroup = self.view
    -- Code here runs when the scene is first created but has not yet appeared on screen
	
	-- load in sounds
	soundTable = {
		yesSound = audio.loadSound( "chime.wav" ),
		noSound = audio.loadSound( "buzzer.wav" ),
	}

	-- create the TextObject for the question
	local questionOptions = {
		parent = sceneGroup,
		text = questions:getQuestionText(),
		x = display.contentWidth/2, y = display.contentHeight/4,
		width = 9*display.contentWidth/10,
		font = native.systemFont,
		fontSize = 20,
		align = "center"
	}
	-- this is another way to make a TextObject
	question = display.newText( questionOptions )
	
	-- make an array of Widgets to present possible answers
	answers = {
		makeAnswer( 1, display.contentWidth/4, 5*display.contentHeight/8 ),
		makeAnswer( 2, 3*display.contentWidth/4, 5*display.contentHeight/8), 
		makeAnswer( 3, display.contentWidth/4, 7*display.contentHeight/8), 
		makeAnswer( 4, 3*display.contentWidth/4, 7*display.contentHeight/8), 
    }
    
    -- insert them into the scene group
    for _, button in pairs(answers) do
    	sceneGroup:insert(button)
    end

end


-- show()
function scene:show( event )

    local sceneGroup = self.view
    local phase = event.phase

    if ( phase == "will" ) then
        -- Code here runs when the scene is still off screen (but is about to come on screen)

    elseif ( phase == "did" ) then
        -- Code here runs when the scene is entirely on screen

    end
end


-- hide()
function scene:hide( event )

    local sceneGroup = self.view
    local phase = event.phase

    if ( phase == "will" ) then
        -- Code here runs when the scene is on screen (but is about to go off screen)

    elseif ( phase == "did" ) then
        -- Code here runs immediately after the scene goes entirely off screen

    end
end


-- destroy()
function scene:destroy( event )

    local sceneGroup = self.view
    -- Code here runs prior to the removal of scene's view

	-- clean up audio stuff
	audio.stop()

	for s,v in pairs( soundTable ) do
		audio.dispose( soundTable[s] )
		soundTable[s] = nil
	end
end


-- -----------------------------------------------------------------------------------
-- Scene event function listeners
-- -----------------------------------------------------------------------------------
scene:addEventListener( "create", scene )
scene:addEventListener( "show", scene )
scene:addEventListener( "hide", scene )
scene:addEventListener( "destroy", scene )
-- -----------------------------------------------------------------------------------

return scene