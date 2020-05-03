package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {

    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'e', 'e', 'e', 'l', 'e'},
                {'u', 's', 'n', 'n', 'n', 'o'},
                {'l', 'e', 'n', 'o', 'n', 'e'},
                {'m', 'l', 'n', 'n', 'n', 'h'},
                {'p', 'e', 'e', 'e', 'j', 'e'}
        };
        System.out.println(detectAllWords(crossword, "one"));

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> result = new ArrayList<>();
        for (String word : words) {
            result.addAll(detectWord(crossword, word));
        }
        return result;
    }

//  Метод возвращает массив найденных слов в заданном массиве символов
    public static ArrayList<Word> detectWord(int[][] crossword, String word) {
        char[] intChars = word.toCharArray();
        boolean wordFound = true;
        ArrayList<Word> result = new ArrayList<>();

        for (int line = 0; line < crossword.length; line++) {
            for (int column = 0; column < crossword[line].length; column++) {
                if (intChars[0] == crossword[line][column]) {

                    boolean RIGHT = crossword[line].length-column >= word.length();
                    boolean LEFT  = column+1 >= word.length();
                    boolean UP    = line+1 >= word.length();
                    boolean DOWN  = crossword.length-line >= word.length();
                    int j = 1;
//////////////////////////////////////////////////////////////////////////////////////////////
//              1.  Проверяем, есть ли слово справа                                         //
                    if (RIGHT) {                                                            //
                        j = 1;                                                              //
//                  Ищем слово                                                              //
                        while (wordFound && j < intChars.length) {                          //
                            wordFound = intChars[j] == crossword[line][column + j];         //
                            if (wordFound) {                                                //
                                j++;                                                        //
                            }                                                               //
                        }                                                                   //
//                  Если слово найдено - добавляем его в массив                             //
                        if (wordFound) {                                                    //
                            Word resultOfSearching = new Word(word);                        //
                            resultOfSearching.setStartPoint(column, line);                  //
                            resultOfSearching.setEndPoint(column+j-1, line);              //
                            result.add(resultOfSearching);                                  //
                        }                                                                   //
                        wordFound = true;                                                   //
                    }                                                                       //
////////////    2.  Проверяем, есть ли  слово снизу и справа    //////////////////////////////
                    if (RIGHT && DOWN) {                                                    //
                        j = 1;                                                              //
                        while (wordFound && j < intChars.length) {                          //
                            wordFound = intChars[j] == crossword[line + j][column + j];     //
                            if (wordFound) {                                                //
                                j++;                                                        //
                            }                                                               //
                        }                                                                   //
                        if (wordFound) {                                                    //
                            Word resultOfSearching = new Word(word);                        //
                            resultOfSearching.setStartPoint(column, line);                  //
                            resultOfSearching.setEndPoint(column+j-1, line+j-1);       //
                            result.add(resultOfSearching);                                  //
                        }                                                                   //
                        wordFound = true;                                                   //
                    }                                                                       //
//              3. Проверяем, есть ли слово снизу    /////////////////////////////////////////
                    if (DOWN) {                                                             //
                        j = 1;                                                              //
                        while (wordFound && j < intChars.length) {                          //
                            wordFound = intChars[j] == crossword[line + j][column];         //
                            if (wordFound) {                                                //
                                j++;                                                        //
                            }                                                               //
                        }                                                                   //
                        if (wordFound) {                                                    //
                            Word resultOfSearching = new Word(word);                        //
                            resultOfSearching.setStartPoint(column, line);                  //
                            resultOfSearching.setEndPoint(column, line + j - 1);          //
                            result.add(resultOfSearching);                                  //
                        }                                                                   //
                        wordFound = true;                                                   //
                    }                                                                       //
//              4. Проверяем, есть ли слово снизу и слева    /////////////////////////////////
                    if (DOWN && LEFT) {                                                     //
                        j = 1;                                                              //
                        while (wordFound && j < intChars.length) {                          //
                            wordFound = intChars[j] == crossword[line + j][column - j];     //
                            if (wordFound) {                                                //
                                j++;                                                        //
                            }                                                               //
                        }                                                                   //
                        if (wordFound) {                                                    //
                            Word resultOfSearching = new Word(word);                        //
                            resultOfSearching.setStartPoint(column, line);                  //
                            resultOfSearching.setEndPoint(column-j+1, line+j-1);       //
                            result.add(resultOfSearching);                                  //
                        }                                                                   //
                        wordFound = true;                                                   //
                    }                                                                       //
//              5. Проверяем, есть ли слово слева    /////////////////////////////////////////
                    if (LEFT) {                                                             //
                        j = 1;                                                              //
                        while (wordFound && j < intChars.length) {                          //
                            wordFound = intChars[j] == crossword[line][column - j];         //
                            if (wordFound) {                                                //
                                j++;                                                        //
                            }                                                               //
                        }                                                                   //
                        if (wordFound) {                                                    //
                            Word resultOfSearching = new Word(word);                        //
                            resultOfSearching.setStartPoint(column, line);                  //
                            resultOfSearching.setEndPoint(column-j+1, line);             //
                            result.add(resultOfSearching);                                  //
                        }                                                                   //
                        wordFound = true;                                                   //
                    }                                                                       //
//              6. Проверяем, есть ли слово слева и сверху    ////////////////////////////////
                    if (LEFT && UP) {                                                       //
                        j = 1;                                                              //
                        while (wordFound && j < intChars.length) {                          //
                            wordFound = intChars[j] == crossword[line - j][column - j];     //
                            if (wordFound) {                                                //
                                j++;                                                        //
                            }                                                               //
                        }                                                                   //
                        if (wordFound) {                                                    //
                            Word resultOfSearching = new Word(word);                        //
                            resultOfSearching.setStartPoint(column, line);                  //
                            resultOfSearching.setEndPoint(column-j+1, line-j+1);       //
                            result.add(resultOfSearching);                                  //
                        }                                                                   //
                        wordFound = true;                                                   //
                    }                                                                       //
//              7. Проверяем, есть ли слово сверху    ////////////////////////////////////////
                    if (UP) {                                                               //
                        j = 1;                                                              //
                        while (wordFound && j < intChars.length) {                          //
                            wordFound = intChars[j] == crossword[line - j][column];         //
                            if (wordFound) {                                                //
                                j++;                                                        //
                            }                                                               //
                        }                                                                   //
                        if (wordFound) {                                                    //
                            Word resultOfSearching = new Word(word);                        //
                            resultOfSearching.setStartPoint(column, line);                  //
                            resultOfSearching.setEndPoint(column, line - j + 1);          //
                            result.add(resultOfSearching);                                  //
                        }                                                                   //
                        wordFound = true;                                                   //
                    }                                                                       //
//              8. Проверяем, есть ли слово сверху    ////////////////////////////////////////
                    if (UP && RIGHT) {                                                      //
                        j = 1;                                                              //
                        while (wordFound && j < intChars.length) {                          //
                            wordFound = intChars[j] == crossword[line - j][column+j];       //
                            if (wordFound) {                                                //
                                j++;                                                        //
                            }                                                               //
                        }                                                                   //
                        if (wordFound) {                                                    //
                            Word resultOfSearching = new Word(word);                        //
                            resultOfSearching.setStartPoint(column, line);                  //
                            resultOfSearching.setEndPoint(column+j-1, line-j+1);       //
                            result.add(resultOfSearching);                                  //
                        }                                                                   //
                        wordFound = true;                                                   //
                    }                                                                       //
//////////////////////////////////////////////////////////////////////////////////////////////
                }
            }
        }
        return result;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
