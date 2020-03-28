package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
//      Получаем из консоли названия файлов
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

//      Открываем потоки чтения и записи
        FileInputStream input = new FileInputStream(file1);
        FileOutputStream out = new FileOutputStream(file2);

//      Считываем значения из первого файла и помещаем их в массив строк
        byte[] array = new byte[input.available()];
        input.read(array, 0, array.length);
        String string = new String(array);
        String[] buffer = string.split(" ");

//      Полученные значения округляем и парсим в инт
//      после чего добавляем через пробел в одну строку
        StringBuilder result = new StringBuilder();
        for (String number : buffer) {
            int i = Math.round(Float.parseFloat(number));
            result.append(i).append(" ");
        }

//      Полученную строку конвертируем в массив байт и записываем в файл
        array = result.toString().getBytes();
        out.write(array);

//      Закрываем потоки ввода/вывода
        input.close();
        out.close();
    }
}
