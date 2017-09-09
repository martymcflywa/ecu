-----------------------------------------------------------------------------------------
--
-- questions.lua
--
-- module that handles questions and answers
--
-----------------------------------------------------------------------------------------

local questions = {}

local function getOlympicData()
	local data = {};
	local path = system.pathForFile("olympicData.txt", system.ResourceDirectory);
	for line in io.lines(path) do
		local year, city, country = line:match("(%d+),%s([%D]+),%s(%a+)");
		table.insert(data, {
			year = year,
			city = city,
			country = country
		})
	end
  return data;
end

local data = getOlympicData(); -- private knowledge base

--[[
-- This part should be commented out (delete one of the - from the line above)
-- and replaced with new code that reads in the question data from "olympicData.txt"
data[1] = { year = 1896, city = "Athens", country = "Greece" }
data[2] = { year = 1900, city = "Paris", country = "France" }
data[3] = { year = 1904, city = "St Louis", country = "USA" }
data[4] = { year = 1908, city = "London", country = "UK" }
data[5] = { year = 1912, city = "Stockholm", country = "Sweden" }
data[6] = { year = 1920, city = "Antwerp", country = "Netherlands" }
--]]


---[[
-- put your new code in here - you can switch between versions by commenting/uncommenting
-- this block and the one above

--]]

local current -- index into data
local answers = {} -- possible answers

-- selects a question and a set of answers
function questions:setNextQuestion()
	current = math.random(#data)
	answers = {}
	local answersUsed = {}
	local index = math.random(4)
	answers[index] = data[current].city
	answersUsed[current] = true
	for i = 1, 4 do
		if not answers[i] then
			local done
			while not done do
				-- find an unused answer
				index = math.random(#data)
				done = not answersUsed[index]
			end
			answers[i] = data[index].city
			answersUsed[index] = true
		end
	end
end

function questions:getQuestionText()
		return "Which was the Olympic city in " .. data[current].year .. "?"
end

function questions:getAnswer(index)
	return answers[index]
end

function questions:getCorrectAnswer()
	return "It was in " .. data[current].city .. "."
end

function questions:checkAnswer(answer)
	return answer == data[current].city
end

questions:setNextQuestion()

return questions