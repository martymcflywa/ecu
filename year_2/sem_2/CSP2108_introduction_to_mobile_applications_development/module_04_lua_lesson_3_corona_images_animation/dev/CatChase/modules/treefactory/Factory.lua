local Tree = require "modules.treefactory.Tree";

local Factory = {};

function Factory.get(bottomRef, baseline)
    local trees = {};
	trees[1] = Tree:__init(
		"Palm-arecaceae.png",
		0.7,
		bottomRef,
		20,
		baseline,
		0.1
	);
	trees[2] = Tree:__init(
		"Greenhouse-Palm-jubaea01.png",
		0.6,
		bottomRef,
		120,
		baseline,
		0.2
	);
	trees[3] = Tree:__init(
		"Greenhouse-Palm-cycas01.png",
		0.8,
		bottomRef,
		200,
		baseline,
		0.3
	);
	trees[4] = Tree:__init(
		"Ginger.png",
		0.7,
		bottomRef,
		baseline,
		baseline,
		0.4
	);
	trees[5] = Tree:__init(
		"Greenhouse-Palm-acai01.png",
		0.8,
		bottomRef,
		300,
		baseline,
		0.5
	);
	trees[6] = Tree:__init(
		"Dracena.png",
		0.4,
		bottomRef,
		320,
		baseline,
		0.6
	);
	trees[7] = Tree:__init(
		"Banana.png",
		0.4,
		bottomRef,
		380,
		baseline,
		0.7
	);
	trees[8] = Tree:__init(
		"Bamboo-rgba.png",
		0.8,
		bottomRef,
		420,
		baseline,
		0.8
	);
    return trees;
end

return Factory;
