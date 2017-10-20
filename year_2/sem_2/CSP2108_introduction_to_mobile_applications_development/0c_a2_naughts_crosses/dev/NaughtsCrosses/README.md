# CSP2108: Assignment 2

### Martin Ponce, 10371381

- Submission number: `4a16fbf4-a095-4a88-8492-9df698d42c57`
- `CSP2108_172_A2_MartinPonce_10371381.zip = 6e23e563a565e958fdf9421f115023f8`
- This README, source code and full history of commits can be found on [github.com](https://github.com/martymcflywa/ecu/tree/master/year_2/sem_2/CSP2108_introduction_to_mobile_applications_development/0c_a2_naughts_crosses/dev/NaughtsCrosses)

![mainmenu](https://snag.gy/Ci1DSd.jpg)

## New features in assignment 2

- `Ai` winning strategy
    - Already implemented in assignment 1
    - Minor tweaks to match requirements in brief
- Score persistence
    - App keeps track of wins, losses and draws, persistent across separate invocations
    - Score serialized to `.json` and written to file in `system.DocumentsDirectory`
    - Score deserialized from `.json` and read from file in `system.DocumentsDirectory`
    - `Player` able to reset persistent score
- Turn undo
    - `Player` able to undo last turn within 5 seconds
    - Can only undo once per turn
    - Also removes `Ai`s last turn if made after `Player` turn
- Turn replay
    - `Player` able to replay turns at end of current game
- Difficulty select
    - `Player` selects one of three difficulty settings before starting game
        - Easy
            - `Ai` uses random strategy
        - Medium
            - `Ai` uses hard strategy on even turns
            - `Ai` uses random strategy on odd turns
        - Hard
            - Play block or win, else
            - Play two x two in a row, else
                - **Not yet implemented**
            - Play middle, else
            - Play opposite corner, else
            - Play empty corner, else
            - Play empty square

## Unit tests

### Prerequisite

In order to invoke unit tests defined in `./tests`, [`busted`](https://olivinelabs.com/busted/), an open source lua unit testing framework is required.

The easiest way to install `busted` is to use [`luarocks`](https://luarocks.org/) package manager.

```
$ sudo luarocks install busted
```

### Running unit tests

Unit tests must be invoked from the root directory. A handy shell script is included, which runs all unit tests in the `./tests` directory.

``` sh
$ ./runUnitTests.sh
```

Alternatively, each unit test can be run individually with `lua`:

```
$ lua tests/BoardTests.lua -v -o TAP
```

Or with `busted`:

```
$ busted tests/BoardTests.lua -v -o TAP
```

### Test suite

Along with unit tests from assignment 1, additional unit tests have been added to the test suite:

```
$ ./runUnitTests.sh
...
ok 27 - BoardTests. Turn log. Expects turn to be pushed to TurnLog.
ok 28 - BoardTests. Turn log. Expects last player turn to be popped from TurnLog.
ok 29 - BoardTests. Turn log. Expects last ai and player turn to be popped from TurnLog.
1..29
...
ok 4 - AiTests. When Ai is x. Ai goes for corner. Expects Ai puts x in opposite corner.
...
ok 9 - AiTests. When Ai is o. Ai goes for corner. Expects Ai puts o in opposite corner.
1..10
...
ok 1 - PersistTests. Loading scores. Expects Persist.scores to be deserialized with expected score values scores.json exists.
ok 2 - PersistTests. Loading scores. Expects Persist.scores to be initialized with zeros when scores.json doesn't exist.
ok 3 - PersistTests. Saving scores. Expects scores.json to contain expected score values when scores.json is saved.
ok 4 - PersistTests. Saving scores. Expects scores.json to be initialized with zeros when scores.json is not saved.
ok 5 - PersistTests. Resetting scores. When scores are reset, scores.json exists and contains zero for all values.
1..5
```

### Unit test notes

Because the game is tightly coupled with Corona SDK's libraries, and these unit tests run independently of Corona SDK, new features that are largely driven by `composer` were not unit tested. These features include:

- Difficulty select
- Turn undo
- Turn replay

These features are tested via black box below.

# Black box tests

## Difficulty select

![difficultyselect](https://snag.gy/dq1TMx.jpg)

### `Player` is x and selects easy

```
"[DEBUG] scenes.PlayerSelect#playerX(): player is x"
"[DEBUG] scenes.DifficultySelect#easy(): difficulty is easy"
```

### `Player` is x and selects medium

```
"[DEBUG] scenes.PlayerSelect#playerX(): player is x"
"[DEBUG] scenes.DifficultySelect#medium(): difficulty is medium"
```

### `Player` is x and selects hard

```
"[DEBUG] scenes.PlayerSelect#playerX(): player is x"
"[DEBUG] scenes.DifficultySelect#hard(): difficulty is hard"
```

### `Player` is o and selects easy

```
"[DEBUG] scenes.PlayerSelect#playerO(): player is o"
"[DEBUG] scenes.DifficultySelect#easy(): difficulty is easy"
```

### `Player` is o and selects medium

```
"[DEBUG] scenes.PlayerSelect#playerO(): player is o"
"[DEBUG] scenes.DifficultySelect#medium(): difficulty is medium"
```

### `Player` is o and selects hard

```
"[DEBUG] scenes.PlayerSelect#playerO(): player is o"
"[DEBUG] scenes.DifficultySelect#hard(): difficulty is hard"
```

### `Ai` strategy while `Player` is x and difficulty is easy

- Expect `Ai` to only use `random()`

```
"[DEBUG] scenes.PlayerSelect#playerX(): player is x"
"[DEBUG] scenes.DifficultySelect#easy(): difficulty is easy"
"[DEBUG] Player#turn(): char=x row=2 col=2"
"[DEBUG] Ai#turn(): char=o row=1 col=1 strategy=random()"
"[DEBUG] Player#turn(): char=x row=3 col=1"
"[DEBUG] Ai#turn(): char=o row=2 col=1 strategy=random()"
"[DEBUG] Player#turn(): char=x row=1 col=2"
"[DEBUG] Ai#turn(): char=o row=1 col=3 strategy=random()"
"[DEBUG] Player#turn(): char=x row=3 col=2"
```

### `Ai` strategy while `Player` is x and difficulty is medium

- Expect `Ai` to use hard difficulty algorithm for even turns
- Expect `Ai` to use `random()` for odd turns

```
"[DEBUG] scenes.PlayerSelect#playerX(): player is x"
"[DEBUG] scenes.DifficultySelect#medium(): difficulty is medium"
"[DEBUG] Player#turn(): char=x row=2 col=2"
"[DEBUG] Ai#turn(): char=o row=1 col=1 strategy=emptyCorner()"
"[DEBUG] Player#turn(): char=x row=2 col=3"
"[DEBUG] Ai#turn(): char=o row=2 col=1 strategy=random()"
"[DEBUG] Player#turn(): char=x row=3 col=1"
"[DEBUG] Ai#turn(): char=o row=1 col=3 strategy=block()"
"[DEBUG] Player#turn(): char=x row=1 col=2"
"[DEBUG] Ai#turn(): char=o row=3 col=2 strategy=random()"
"[DEBUG] Player#turn(): char=x row=3 col=3"
```

### `Ai` strategy while `Player` is x and difficulty is hard

- Expect `Ai` to only use hard difficulty algorithm
- Expect `random()` is never used

```
"[DEBUG] scenes.PlayerSelect#playerX(): player is x"
"[DEBUG] scenes.DifficultySelect#hard(): difficulty is hard"
"[DEBUG] Player#turn(): char=x row=2 col=2"
"[DEBUG] Ai#turn(): char=o row=1 col=1 strategy=emptyCorner()"
"[DEBUG] Player#turn(): char=x row=3 col=1"
"[DEBUG] Ai#turn(): char=o row=1 col=3 strategy=block()"
"[DEBUG] Player#turn(): char=x row=1 col=2"
"[DEBUG] Ai#turn(): char=o row=3 col=2 strategy=block()"
"[DEBUG] Player#turn(): char=x row=2 col=3"
"[DEBUG] Ai#turn(): char=o row=2 col=1 strategy=block()"
"[DEBUG] Player#turn(): char=x row=3 col=3"
```

### `Ai` strategy while `Player` is o and difficulty is easy

- Expect `Ai` to only use `random()`

```
"[DEBUG] scenes.PlayerSelect#playerO(): player is o"
"[DEBUG] scenes.DifficultySelect#easy(): difficulty is easy"
"[DEBUG] Ai#turn(): char=x row=2 col=1 strategy=random()"
"[DEBUG] Player#turn(): char=o row=1 col=3"
"[DEBUG] Ai#turn(): char=x row=1 col=1 strategy=random()"
"[DEBUG] Player#turn(): char=o row=3 col=1"
"[DEBUG] Ai#turn(): char=x row=3 col=3 strategy=random()"
"[DEBUG] Player#turn(): char=o row=2 col=2"
```

### `Ai` strategy while `Player` is o and difficulty is medium

- Expect `Ai` to use hard difficulty algorithm for even turns
- Expect `Ai` to use `random()` for odd turns

```
"[DEBUG] scenes.PlayerSelect#playerO(): player is o"
"[DEBUG] scenes.DifficultySelect#medium(): difficulty is medium"
"[DEBUG] Ai#turn(): char=x row=2 col=2 strategy=center()"
"[DEBUG] Player#turn(): char=o row=3 col=1"
"[DEBUG] Ai#turn(): char=x row=1 col=3 strategy=random()"
"[DEBUG] Player#turn(): char=o row=1 col=1"
"[DEBUG] Ai#turn(): char=x row=2 col=1 strategy=block()"
"[DEBUG] Player#turn(): char=o row=2 col=3"
"[DEBUG] Ai#turn(): char=x row=3 col=2 strategy=random()"
"[DEBUG] Player#turn(): char=o row=1 col=2"
"[DEBUG] Ai#turn(): char=x row=3 col=3 strategy=oppositeCorner()"
```

### `Ai` strategy while `Player` is o and difficulty is hard

- Expect `Ai` to only use hard difficulty algorithm
- Expect `random()` is never used

```
"[DEBUG] scenes.PlayerSelect#playerO(): player is o"
"[DEBUG] scenes.DifficultySelect#hard(): difficulty is hard"
"[DEBUG] Ai#turn(): char=x row=2 col=2 strategy=center()"
"[DEBUG] Player#turn(): char=o row=3 col=1"
"[DEBUG] Ai#turn(): char=x row=1 col=3 strategy=oppositeCorner()"
"[DEBUG] Player#turn(): char=o row=1 col=1"
"[DEBUG] Ai#turn(): char=x row=2 col=1 strategy=block()"
"[DEBUG] Player#turn(): char=o row=1 col=2"
"[DEBUG] Ai#turn(): char=x row=2 col=3 strategy=win()"
```

## Turn undo

![turnundo](https://snag.gy/XuqfPZ.jpg)

### Undo turn while `Player` is x

- `Player` turn then `Ai` turn
- Expect `Ai` turn to be removed, then `Player` turn to be removed

![currentturn](https://snag.gy/B76ZGI.jpg)

```
"[DEBUG] Player#turn(): char=x row=2 col=2"
"[DEBUG] Ai#turn(): char=o row=1 col=1 strategy=emptyCorner()"
"[DEBUG] Board#popMark(): row=1 col=1"
"[DEBUG] Board#popMark(): row=2 col=2"
```

### Undo turn while `Player` is o

- `Ai` turn then `Player` turn then `Ai` turn
- Expect `Ai`s last turn to be removed, then `Player` turn to be removed

![currentturn](https://snag.gy/Nmqu6K.jpg)

```
"[DEBUG] Ai#turn(): char=x row=2 col=2 strategy=center()"
"[DEBUG] Player#turn(): char=o row=1 col=3"
"[DEBUG] Ai#turn(): char=x row=3 col=1 strategy=oppositeCorner()"
"[DEBUG] scenes.PlayerSelect#playerO(): player is o"
"[DEBUG] scenes.DifficultySelect#hard(): difficulty is hard"
"[DEBUG] Ai#turn(): char=x row=2 col=2 strategy=center()"
"[DEBUG] Player#turn(): char=o row=1 col=3"
"[DEBUG] Ai#turn(): char=x row=3 col=1 strategy=oppositeCorner()"
"[DEBUG] Board#popMark(): row=3 col=1"
"[DEBUG] Board#popMark(): row=1 col=3"
```

![afterundo](https://snag.gy/0XZrzf.jpg)

### Undo attempt after 5 seconds

- Expect undo unavailable for current turn

```
"[DEBUG] Player#turn(): char=x row=2 col=2"
"[DEBUG] Ai#turn(): char=o row=1 col=1 strategy=emptyCorner()"
"[DEBUG] scenes.PlayScreen#undo(): Undo timer expired (5s) or already called undo"
```

### Undo attempt after already undoing current turn

- `Player` undoes current turn, then attempts undo again
- Expect undo unavailable for previous turn

```
"[DEBUG] Player#turn(): char=x row=2 col=2"
"[DEBUG] Ai#turn(): char=o row=1 col=1 strategy=emptyCorner()"
"[DEBUG] Player#turn(): char=x row=3 col=1"
"[DEBUG] Ai#turn(): char=o row=1 col=3 strategy=block()"
"[DEBUG] Board#popMark(): row=1 col=3"
"[DEBUG] Board#popMark(): row=3 col=1"
"[DEBUG] scenes.PlayScreen#undo(): Undo timer expired (5s) or already called undo"
```

## Turn replay

- Expect replay to play back turns in correct order

```
// Real-time turns:
"[DEBUG] Player#turn(): char=x row=2 col=2"
"[DEBUG] Ai#turn(): char=o row=1 col=1 strategy=emptyCorner()"
"[DEBUG] Player#turn(): char=x row=3 col=1"
"[DEBUG] Ai#turn(): char=o row=1 col=3 strategy=block()"
"[DEBUG] Player#turn(): char=x row=1 col=2"
"[DEBUG] Ai#turn(): char=o row=3 col=2 strategy=block()"
"[DEBUG] Player#turn(): char=x row=2 col=3"
"[DEBUG] Ai#turn(): char=o row=2 col=1 strategy=block()"
"[DEBUG] Player#turn(): char=x row=3 col=3"
```

```
// Replay turns:
"[DEBUG] scenes.ReplayScreen#pushTurn(): turn=1 row=2 col=2 char=x isPlayer=true"
"[DEBUG] scenes.ReplayScreen#pushTurn(): turn=2 row=1 col=1 char=o isPlayer=false"
"[DEBUG] scenes.ReplayScreen#pushTurn(): turn=3 row=3 col=1 char=x isPlayer=true"
"[DEBUG] scenes.ReplayScreen#pushTurn(): turn=4 row=1 col=3 char=o isPlayer=false"
"[DEBUG] scenes.ReplayScreen#pushTurn(): turn=5 row=1 col=2 char=x isPlayer=true"
"[DEBUG] scenes.ReplayScreen#pushTurn(): turn=6 row=3 col=2 char=o isPlayer=false"
"[DEBUG] scenes.ReplayScreen#pushTurn(): turn=7 row=2 col=3 char=x isPlayer=true"
"[DEBUG] scenes.ReplayScreen#pushTurn(): turn=8 row=2 col=1 char=o isPlayer=false"
"[DEBUG] scenes.ReplayScreen#pushTurn(): turn=9 row=3 col=3 char=x isPlayer=true"
```

## Persistence

### `scores.json` does not exist

- Expect `scores.json` file is created
- Expect score values to all be zero

```
"[DEBUG] Persist#newFile(): create /path/to/Documents/score.json"
"[DEBUG] Persist#read(): read /path/to/Documents/score.json"
"[DEBUG] Persist#read(): deserialize json ''"
"[DEBUG] Persist#write(): serialize json '{\"draw\":0,\"win\":0,\"loss\":0}'"
"[DEBUG] Persist#write(): write /path/to/Documents/score.json"
```

### `scores.json` exists and contains values

- Expect `scores.json` to be read and deserialized
- Expect correct values to be shown on `ScoreScreen`

``` json
// Contents of scores.json:
{"draw":8,"win":4,"loss":6}
```

```
"[DEBUG] Persist#read(): read /path/to/Documents/score.json"
"[DEBUG] Persist#read(): deserialize json '{\"draw\":8,\"win\":4,\"loss\":6}'"
```

![scorescreen](https://snag.gy/XOvQJG.jpg)

## `scores.json` cleared while containing values

- Expect `scores.json` values to be reset to zero
- Expect `scores.json` to be serialized and written with zero values
- Expect `scores.json` to be read and deserialized with zero values
- Expect `ScoreScreen` to display zero values

``` json
// Contents of scores.json before clearing
{"draw":8,"win":4,"loss":6}
```

```
// After CLEAR button is pressed
"[DEBUG] Persist#write(): serialize json '{\"draw\":0,\"win\":0,\"loss\":0}'"
"[DEBUG] Persist#write(): write /path/to/Documents/score.json"
"[DEBUG] Persist#read(): read /path/to/Documents/score.json"
"[DEBUG] Persist#read(): deserialize json '{\"draw\":0,\"win\":0,\"loss\":0}'"
```

- Values shown on `ScoreScreen` after score is cleared

![scorecleared](https://snag.gy/3QBA17.jpg)