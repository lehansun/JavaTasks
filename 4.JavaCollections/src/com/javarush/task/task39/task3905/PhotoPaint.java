package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if (x<0 || y<0 || y>=image.length || x>=image[0].length || image[y][x] == desiredColor) {
            return false;
        }
        paintNeighbors(image, x, y, desiredColor, image[y][x]);
        return true;
    }

    private void paintNeighbors(Color[][] image, int x, int y, Color desiredColor, Color neededColor) {
        for (int i = y-1; i <= y+1; i++) {
            for (int j = x-1; j <= x + 1; j++) {
                if (i<0 || i>= image.length) continue;
                if (j<0 || j>= image[0].length) continue;
                if (image[i][j] == neededColor) {
                    image[i][j] = desiredColor;
                    paintNeighbors(image, j, i, desiredColor, neededColor);
                }
            }
        }
    }
}
