package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;
    private int score = 0;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        gameField = new int[SIDE][SIDE];
        createNewNumber();
        createNewNumber();
        score = 0;
        setScore(score);
    }

    private void drawScene() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                setCellColoredNumber(x, y, gameField[y][x]);
            }
        }
    }

    private void createNewNumber() {
        if (getMaxTileValue() == 2048) {
            win();
        } else {
            int x, y;
            do {
                x = getRandomNumber(SIDE);
                y = getRandomNumber(SIDE);
            } while (gameField[y][x] != 0);
            int randomNumber = getRandomNumber(10);
            if (randomNumber == 9) {
                gameField[y][x] = 4;
            } else {
                gameField[y][x] = 2;
            }
        }
    }

    private void setCellColoredNumber(int x, int y, int value) {
        Color newColor = getColorByValue(value);
        if (value == 0) {
            setCellValueEx(x, y, newColor, "");
        } else {
            setCellValueEx(x, y, newColor, "" + value);
        }
    }

    private Color getColorByValue(int value) {
        switch (value) {
            case 2: return Color.BLUE;
            case 4: return Color.AZURE;
            case 8: return Color.AQUA;
            case 16: return Color.BEIGE;
            case 32: return Color.ANTIQUEWHITE;
            case 64: return Color.BISQUE;
            case 128: return Color.BLANCHEDALMOND;
            case 256: return Color.CHOCOLATE;
            case 512: return Color.CRIMSON;
            case 1024: return Color.DARKKHAKI;
            case 2048: return Color.GOLD;
            default: return Color.ALICEBLUE;
        }
    }

    private boolean compressRow(int[] row) {
        boolean isCompressed = false;
        for (int i = 0; i < SIDE - 1; i++) {
            if (row[i] == 0) {
                for (int j = i+1; j < SIDE; j++) {
                    if (row[j] != 0) {
                        isCompressed = true;
                        row[i] = row[j];
                        row[j] = 0;
                        break;
                    }
                }
            }
        }
        return isCompressed;
    }

    private boolean mergeRow(int[] row) {
        boolean isMerged = false;
        for (int i = 0; i < SIDE - 1; i++) {
            if (row[i] != 0 && row[i] == row[i+1]) {
                row[i]+=row[i];
                row[i+1] = 0;
                isMerged = true;

                score+=row[i];
                setScore(score);
            }
        }
        return isMerged;
    }

    @Override
    public void onKeyPress(Key key) {
        if (!canUserMove()) {
            gameOver();
        } else {
            if (isGameStopped) {
                if (key == Key.SPACE) {
                    isGameStopped = false;
                    createGame();
                    drawScene();
                }
            } else {
                switch (key) {
                    case LEFT:
                        moveLeft();
                        drawScene();
                        break;
                    case RIGHT:
                        moveRight();
                        drawScene();
                        break;
                    case UP:
                        moveUp();
                        drawScene();
                        break;
                    case DOWN:
                        moveDown();
                        drawScene();
                        break;
                }
            }
        }
    }

    private void moveLeft() {
        boolean isMoveDode = false;

        for (int[] row : gameField) {
            boolean wasCompressed = compressRow(row);
            boolean wasMerged = mergeRow(row);
            if (wasMerged) {
                compressRow(row);
            }
            if (wasCompressed || wasMerged) {
                isMoveDode = true;
            }
        }

        if (isMoveDode) {
            createNewNumber();
        }
    }


    private void moveRight() {
        for (int i = 0; i < 2; i++) {
            rotateClockwise();
        }
        moveLeft();
        for (int i = 0; i < 2; i++) {
            rotateClockwise();
        }
    }
    private void moveUp() {
        for (int i = 0; i < 3; i++) {
            rotateClockwise();
        }
        moveLeft();
        rotateClockwise();
    }
    private void moveDown() {
        rotateClockwise();
        moveLeft();
        for (int i = 0; i < 3; i++) {
            rotateClockwise();
        }
    }

    private void rotateClockwise() {
        int[][] result = new int[SIDE][SIDE];
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x <SIDE; x++) {
                result[y][x] = gameField[SIDE-1-x][y];
            }
        }
        gameField = result;
    }

    private int getMaxTileValue() {
        int maxTile = 0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[i][j] > maxTile) {
                    maxTile = gameField[i][j];
                }
            }
        }
        return maxTile;
    }

    private boolean canUserMove() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (gameField[y][x] == 0) return true;
                if (x < SIDE-1 && gameField[y][x] == gameField[y][x+1]) {
                    return true;
                }
                if (y < SIDE-1 &&  gameField[y][x] == gameField[y+1][x]) {
                    return true;
                }
            }
        }
        return false;
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.LIGHTSLATEGRAY, "WIN!", Color.DARKGREEN, 64);
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.LIGHTSLATEGRAY, "GAME OVER!", Color.DARKRED, 64);
    }
}


