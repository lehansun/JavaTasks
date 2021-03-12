package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags;
    private int countClosedTiles = SIDE * SIDE;
    private int score = 0;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private boolean isGameStopped = false;


    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
                setCellValue(x, y, "");
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private void restart(){
        isGameStopped = false;
        countMinesOnField = 0;
        countClosedTiles = SIDE * SIDE;
        score = 0;
        setScore(score);
        createGame();
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void countMineNeighbors() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (!gameField[y][x].isMine) {
                    for (GameObject o : getNeighbors(gameField[y][x])) {
                        if (o.isMine) {
                            gameField[y][x].countMineNeighbors++;
                        }
                    }
                }
            }
        }
    }

    private void openTile(int x, int y) {
        GameObject field = gameField[y][x];
        if (field.isOpen || field.isFlag || isGameStopped) return;

        field.isOpen = true;
        countClosedTiles--;
        if (field.isMine) {
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
        } else {
            score+=5;
            setScore(score);
            if (countClosedTiles == countMinesOnField) {
                win();
            }
            setCellColor(x, y, Color.GREEN);
            if (field.countMineNeighbors == 0) {
                setCellValue(x, y, "");
                getNeighbors(field).forEach(e -> {
                    if (!e.isOpen) {
                        openTile(e.x, e.y);
                    }
                });
            } else {
                setCellNumber(x, y, field.countMineNeighbors);
            }
        }
    }


    private void markTile(int x, int y) {
        GameObject field = gameField[y][x];
        if (!field.isOpen && !isGameStopped) {
            if (field.isFlag) {
                field.isFlag = false;
                countFlags++;
                setCellValue(x, y, "");
                setCellColor(x, y, Color.ORANGE);
            } else if (countFlags > 0) {
                field.isFlag = true;
                countFlags--;
                setCellValue(x, y, FLAG);
                setCellColor(x, y, Color.AQUAMARINE);
            }
        }
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.ALICEBLUE, "Игра окончена!", Color.BLACK, 30);
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.ALICEBLUE, "Победа!", Color.BLACK, 30);
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped) {
            restart();
        } else {
            openTile(x, y);
        }
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }
}