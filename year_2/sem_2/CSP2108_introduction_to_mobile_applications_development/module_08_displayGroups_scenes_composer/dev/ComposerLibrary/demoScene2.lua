local composer = require("composer");
local widget = require("widget");

local scene = composer.newScene();

-- -----------------------------------------------------------------------------------
-- Code outside of the scene event functions below will only be executed ONCE unless
-- the scene is removed entirely (not recycled) via "composer.removeScene()"
-- -----------------------------------------------------------------------------------

local function initBg(sceneGroup)
	local bg = _d.newRect(_cx, _cy, _cw, _ch);
	bg:setFillColor(unpack(_colors["red"]));
	sceneGroup:insert(bg);
end

local function handle(self, event)
	if(event.phase == "ended") then
		composer.gotoScene("demoScene1", self.options);
	end
end

local function initButtons(sceneGroup)
	for row = 1, _bRows, 1 do
		for col = 1, _bCols, 1 do
			local button = widget.newButton({
				id = _buttons[row][col]["effect"],
				label = _buttons[row][col]["effect"],
				labelColor = {
					default = {0, 0, 0}
				},
				shape = "rect",
				width = _buttonW,
				height = _buttonH,
				x = _buttons[row][col]["x"],
				y = _buttons[row][col]["y"]
			});
			button.options = {
				time = effectTime,
				effect = _buttons[row][col]["effect"]
			};
			button.touch = handle;
			button:addEventListener("touch", event);
			sceneGroup:insert(button);
		end
	end
end

-- -----------------------------------------------------------------------------------
-- Scene event functions
-- -----------------------------------------------------------------------------------

-- create()
function scene:create(event)

	local sceneGroup = self.view
	-- Code here runs when the scene is first created but has not yet appeared on screen
	initBg(sceneGroup);
	initButtons(sceneGroup);
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