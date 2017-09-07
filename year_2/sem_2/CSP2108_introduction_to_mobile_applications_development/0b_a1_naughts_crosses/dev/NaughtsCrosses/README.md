# CSP2108: Assignment 1

### Martin Ponce, 10371381

![mainmenu](https://snag.gy/Ci1DSd.jpg)

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

This is the output of unit tests passing:

```
$ ./runUnitTests.sh
ok 1 - BoardTests. Detect win for x. Expects win for top horizontal.
ok 2 - BoardTests. Detect win for x. Expects win for mid horizontal.
ok 3 - BoardTests. Detect win for x. Expects win for bottom horizontal.
ok 4 - BoardTests. Detect win for x. Expects win for left vertical.
ok 5 - BoardTests. Detect win for x. Expects win for mid vertical.
ok 6 - BoardTests. Detect win for x. Expects win for right vertical.
ok 7 - BoardTests. Detect win for x. Expects win for left-right-down diagonal.
ok 8 - BoardTests. Detect win for x. Expects win for left-right-up diagonal.
ok 9 - BoardTests. Detect win for o. Expects win for top horizontal.
ok 10 - BoardTests. Detect win for o. Expects win for mid horizontal.
ok 11 - BoardTests. Detect win for o. Expects win for bottom horizontal.
ok 12 - BoardTests. Detect win for o. Expects win for left vertical.
ok 13 - BoardTests. Detect win for o. Expects win for mid vertical.
ok 14 - BoardTests. Detect win for o. Expects win for right vertical.
ok 15 - BoardTests. Detect win for o. Expects win for left-right-down diagonal.
ok 16 - BoardTests. Detect win for o. Expects win for left-right-up diagonal.
ok 17 - BoardTests. Detect tie game. Expects tie game.
ok 18 - BoardTests. Convert touch coords to Board row,col. Expects touch at row=1, col=1.
ok 19 - BoardTests. Convert touch coords to Board row,col. Expects touch at row=1, col=2.
ok 20 - BoardTests. Convert touch coords to Board row,col. Expects touch at row=1, col=3.
ok 21 - BoardTests. Convert touch coords to Board row,col. Expects touch at row=2, col=1.
ok 22 - BoardTests. Convert touch coords to Board row,col. Expects touch at row=2, col=2.
ok 23 - BoardTests. Convert touch coords to Board row,col. Expects touch at row=2, col=3.
ok 24 - BoardTests. Convert touch coords to Board row,col. Expects touch at row=3, col=1.
ok 25 - BoardTests. Convert touch coords to Board row,col. Expects touch at row=3, col=2.
ok 26 - BoardTests. Convert touch coords to Board row,col. Expects touch at row=3, col=3.
1..26
ok 1 - AiTests. When Ai is x. Ai goes for win. Expects Ai puts x where it can win.
ok 2 - AiTests. When Ai is x. Ai goes for block. Expects Ai puts x where it needs to block.
ok 3 - AiTests. When Ai is x. Ai goes for center. Expects Ai puts x in center first when can't win or block.
ok 4 - AiTests. When Ai is x. Ai goes for corner. Expects Ai puts x in corner when can't win, block or put in center.
ok 5 - AiTests. When Ai is o. Ai goes for win. Expects Ai puts o where it can win.
ok 6 - AiTests. When Ai is o. Ai goes for block. Expects Ai puts o where it needs to block.
ok 7 - AiTests. When Ai is o. Ai goes for center. Expects Ai puts o in center first when can't win or block.
ok 8 - AiTests. When Ai is o. Ai goes for corner. Expects Ai puts o in corner when can't win, block or put in center.
1..8
ok 1 - GameTests. When Player is x. Expects Game will select Player as x.
ok 2 - GameTests. When Player is o. Expects Game will select Player as o.
1..2
```

### Unit test notes

Because the game is tightly coupled with Corona SDK's libraries, and these unit tests run independently of Corona SDK, I decided to use [Cluain's Corona mocking library](https://github.com/Cluain/corona-busted) which provides stubs for `display` and other Corona SDK objects. These files are included in `./mocks` and licences remain intact.

## Black box tests

### Player is x and wins

```
"[DEBUG] Player#turn(): put 'x' at row=2, col=2"
"[DEBUG] Ai#lastResort(): put 'o' at row=1, col=1"
"[DEBUG] Player#turn(): put 'x' at row=3, col=3"
"[DEBUG] Board#putMark(): row=1, col=1, x=096, y=144 already occupied."
"[DEBUG] Ai#lastResort(): put 'o' at row=1, col=2"
"[DEBUG] Player#turn(): put 'x' at row=1, col=3"
"[DEBUG] Ai#goForBlock(): put 'o' at row=2, col=3"
"[DEBUG] Player#turn(): put 'x' at row=3, col=1"
"[LOG] PlayScreen#isGameOver(): game over, winner is 1!"
```

![playerxwin](https://snag.gy/NBqJHe.jpg)
![gameoverplayerxwin](https://snag.gy/2JYbs8.jpg)

### Player is x and loses

```
"[DEBUG] Player#turn(): put 'x' at row=2, col=1"
"[DEBUG] Ai#goForCenter(): put 'o' at row=2, col=2"
"[DEBUG] Player#turn(): put 'x' at row=3, col=1"
"[DEBUG] Ai#goForBlock(): put 'o' at row=1, col=1"
"[DEBUG] Player#turn(): put 'x' at row=3, col=2"
"[DEBUG] Ai#goForWin(): put 'o' at row=3, col=3"
"[LOG] PlayScreen#isGameOver(): game over, winner is -1!"
```

![playerxlose](https://snag.gy/PFaUDR.jpg)
![gameoverplayerxlose](https://snag.gy/q4PosY.jpg)

### Player is o and wins

```
"[DEBUG] Ai#goForCenter(): put 'x' at row=2, col=2"
"[DEBUG] Player#turn(): put 'o' at row=1, col=1"
"[DEBUG] Board#putMark(): row=1, col=1, x=096, y=144 already occupied."
"[DEBUG] Ai#lastResort(): put 'x' at row=1, col=2"
"[DEBUG] Player#turn(): put 'o' at row=3, col=2"
"[DEBUG] Board#putMark(): row=1, col=1, x=096, y=144 already occupied."
"[DEBUG] Board#putMark(): row=1, col=2, x=160, y=144 already occupied."
"[DEBUG] Ai#lastResort(): put 'x' at row=1, col=3"
"[DEBUG] Player#turn(): put 'o' at row=3, col=1"
"[DEBUG] Ai#goForBlock(): put 'x' at row=3, col=3"
"[DEBUG] Player#turn(): put 'o' at row=2, col=1"
"[LOG] PlayScreen#isGameOver(): game over, winner is -1!"
```

![playerowin](https://snag.gy/JYEDXs.jpg)
![gameoverplayerowin](https://snag.gy/dE4Shy.jpg)

### Player is o and loses

```
"[DEBUG] Ai#goForCenter(): put 'x' at row=2, col=2"
"[DEBUG] Player#turn(): put 'o' at row=2, col=3"
"[DEBUG] Ai#goForCorner(): put 'x' at row=1, col=1"
"[DEBUG] Player#turn(): put 'o' at row=3, col=1"
"[DEBUG] Ai#goForWin(): put 'x' at row=3, col=3"
"[LOG] PlayScreen#isGameOver(): game over, winner is 1!"
```

![playerolose](https://snag.gy/8Nfur2.jpg)
![gameoverplayerolose](https://snag.gy/0Tj92J.jpg)

### Player is x and game tied

```
"[DEBUG] Player#turn(): put 'x' at row=2, col=2"
"[DEBUG] Ai#goForCorner(): put 'o' at row=1, col=1"
"[DEBUG] Player#turn(): put 'x' at row=3, col=3"
"[DEBUG] Ai#goForCorner(): put 'o' at row=1, col=3"
"[DEBUG] Player#turn(): put 'x' at row=2, col=1"
"[DEBUG] Ai#goForBlock(): put 'o' at row=2, col=3"
"[DEBUG] Player#turn(): put 'x' at row=1, col=2"
"[DEBUG] Ai#goForBlock(): put 'o' at row=3, col=2"
"[DEBUG] Player#turn(): put 'x' at row=1, col=3"
"[LOG] PlayScreen#isGameOver(): game over, tie game!"
```

![playerxtie](https://snag.gy/KsBXGh.jpg)
![gameoverplayerxtie](https://snag.gy/tqE7Pb.jpg)

### Player is o and game tied

```
"[DEBUG] Ai#goForCenter(): put 'x' at row=2, col=2"
"[DEBUG] Player#turn(): put 'o' at row=3, col=3"
"[DEBUG] Ai#goForCorner(): put 'x' at row=1, col=1"
"[DEBUG] Player#turn(): put 'o' at row=3, col=1"
"[DEBUG] Ai#goForBlock(): put 'x' at row=3, col=2"
"[DEBUG] Player#turn(): put 'o' at row=1, col=2"
"[DEBUG] Ai#goForCorner(): put 'x' at row=3, col=1"
"[DEBUG] Player#turn(): put 'o' at row=2, col=1"
"[DEBUG] Board#putMark(): row=1, col=1, x=096, y=144 already occupied."
"[DEBUG] Board#putMark(): row=1, col=2, x=160, y=144 already occupied."
"[DEBUG] Board#putMark(): row=1, col=3, x=224, y=144 already occupied."
"[DEBUG] Board#putMark(): row=2, col=1, x=096, y=240 already occupied."
"[DEBUG] Board#putMark(): row=2, col=2, x=160, y=240 already occupied."
"[DEBUG] Ai#lastResort(): put 'x' at row=2, col=3"
"[LOG] PlayScreen#isGameOver(): game over, tie game!"
```

![playerotie](https://snag.gy/Fr7Qa6.jpg)
![gameoverplayerotie](https://snag.gy/tqE7Pb.jpg)

## Assignment notes

According to the assignment brief, the success criteria for this assignment are:

- Modify existing code to improve event handling of noughts and crosses game
- Allow human player to play against the *computer*
- Allow player to choose who goes first
- Keep track of moves made and show the winner
- Use consistent coding standard
    - Open source or self defined
- Provide documentation of black box and unit tests to verify application functionality
- Provide zip containing assignment
    - Includes code and other ancillary files required to execute code in Corona Simulator
- Provide MD5 hash of zip

Out of scope:

- Win strategy for ai opponent
    - I did however include a basic ai strategy, see notes below

## Approach

### Classes

The existing code used a procedural style to create the game. I decided to use an object oriented approach, using [`30log`](https://github.com/Yonaba/30log), an open source, object oriented framework for lua.

The game is represented by the following classes:

- `Marker`
    - Super class of `Player` and `Ai`
    - Defines logic to mark the game board
    - Avoids code duplication between `Player` and `Ai`
- `Player`
    - Represents the human player of the game
    - Defines logic to start detecting `touch` events when the player taps the screen to place either `x` or `o` on the game board
- `Ai`
    - Represents the *computer* opponent
    - Defines logic to place either `x` or `o` on the game board using different strategies
        - Go for a win
        - Go for a block
        - Place mark in the center cell
        - Place mark on a corner cell
        - Last resort strategy which places mark on first empty cell
- `Board`
    - Represents the play area and contains most of the logic
    - The board is represented as a 2d array each cell is represented by its row and column number
        - Row 1, Column 1 is the top left corner
        - Row 3, Column 3 is the bottom right corner
    - Knows what the winning combinations are
        - ie. Horizontal three in a row, vertical three in a row, diagonal three in a row
    - Keeps track of the score and markers placed on the board
        - `x` is represented by `1`
        - `o` is represented by `-1`
        - empty cells are represented by `0`
    - The winner is detected by iterating over the winning combinations and summing the values
        - If the sum is equal to `3`, `x` has won
        - If the sum is equal to `-3`, `o` has won
        - If all cells have values other than `0` but does not sum to either `3` or `-3` then it is a tie game
    - Has logic to convert touch event x,y coordinates to column,row cell positions
    - Knows about the pixel coordinates for the center of each cell
- `Logger`
    - An auxillary class used to print debugging type messages to Corona Simulator's console
    - Used for black box testing

### User interface

Using Corona SDK's [Composer](https://docs.coronalabs.com/api/library/composer/index.html) scene management library. All scenes reside in the `./scenes` directory, and starts with `MainMenu` which allows the player to select their character, either `x` or `o`.

Once the marker is selected, the game moves to the `PlayScreen` which displays the naughts and crosses board. The player and ai opponent take turns at placing markers until either, the game ends in a tie, or either `x` or `o` wins.

The game then moves to the `GameOver` scene, which indicates who won, with what marker, or if the game ended in a tie. There is a restart and exit button. If the player taps the `AGAIN` button, the game returns to `MainMenu`.
