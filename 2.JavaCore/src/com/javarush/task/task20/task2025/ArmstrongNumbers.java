package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArmstrongNumbers {

    private static byte count = 0;
    private static final long MAX_VALUE = Long.parseLong(new String("8999999999999999999"));
    //    degree[степень][число]
    static long[][] degrees = new long[20][10];
    public static ArrayList<Long> armstrong = new ArrayList<>();

    static {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                degrees[i][j] = Degree.degree(j, i);
            }
        }
        getSequence();
        Collections.sort(armstrong);
    }



    //  Метод возвращает массив цифр числа number
    private static List<Byte> numbers(long number) {
        List<Byte> result = new ArrayList<>();
        while (number>=10) {
            result.add((byte) (number%10));
            number= number/10;
        }
        result.add((byte)number);
        return result;
    }

    //  Метод возвращает сумму цифр массива numbers
    private static int sum(List<Byte> numbers){
        int sum = 0;
        for (Byte b : numbers) {
            sum+=b;
        }
        return sum;
    }

    //    Метод возврачает True, если слово содержит в себе все цифры массива
    private static boolean equals(List<Byte> numbers1, List<Byte> numbers2) {
        if (numbers1.size() != numbers2.size()) {
            return false;
        } else {
            if (numbers2.containsAll(numbers1)) {
                for (Byte number: numbers1) {
                    numbers2.remove(number);
                }
            }
            return (numbers2.size()==0);
        }
    }

    //  Метод поиска и записи числа Армстронга
    private static void writeResult(List<Byte> numbers, List<Long> purpose) {
        long result = 0;
        int degree = numbers.size();
        for (Byte number : numbers) {
            result+= degrees[degree][number];
        }
        if (equals(numbers, numbers(result)) && result > 0) {
            count++;
            purpose.add(result);
        }
    }

    public static void getSequence() {
        String line;
        long lineNumber = 0;

        for (int i19 = 0; i19 < 10; i19++) {
            for (int i18 = i19; i18 < 10; i18++) {
                for (int i17 = i18; i17 < 10; i17++) {
                    for (int i16 = i17; i16 < 10; i16++) {
                        for (int i15 = i16; i15 < 10; i15++) {
                            for (int i14 = i15; i14 < 10; i14++) {
                                for (int i13 = i14; i13 < 10; i13++) {
                                    for (int i12 = i13; i12 < 10; i12++) {
                                        for (int i11 = i12; i11 < 10; i11++) {
                                            for (int i10 = i11; i10 < 10; i10++) {
                                                for (int i9 = i10; i9 < 10; i9++) {
                                                    for (int i8 = i9; i8 < 10; i8++) {
                                                        for (int i7 = i8; i7 < 10; i7++) {
                                                            for (int i6 = i7; i6 < 10; i6++) {
                                                                for (int i5 = i6; i5 < 10; i5++) {
                                                                    for (int i4 = i5; i4 < 10; i4++) {
                                                                        for (int i3 = i4; i3 < 11; i3++) {
                                                                            for (int i2 = i3; i2 < 11; i2++) {
                                                                                for (int i1 = i2; i1 < 11; i1++) {

                                                                                    line = "" + i19 + i18 + i17 + i16 + i15 + i14 + i13 + i12 + i11 + i10 + i9 + i8 + i7 + i6 + i5 + i4 + i3%10 + i2%10 + i1%10;
//
                                                                                    if (i1 != 0 || i2 != 0) {
                                                                                        lineNumber = Long.parseLong(line);
                                                                                    }

//                                                                                  New method
                                                                                    writeResult(numbers(lineNumber), armstrong);
                                                                                    if (lineNumber == MAX_VALUE) {
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


}
