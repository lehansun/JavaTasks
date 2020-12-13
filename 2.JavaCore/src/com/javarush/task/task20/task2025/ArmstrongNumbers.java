package com.javarush.task.task20.task2025;

import java.util.*;

public class ArmstrongNumbers {

    private static byte count = 0;
    static Degree degree = new Degree();
    public static ArrayList<Long> armstrong = new ArrayList<>();


    public static void main(String[] args) {
        Date start = new Date();
        getSequence();
        Date end = new Date();
        System.out.println((end.getTime()-start.getTime())/1000);
        Collections.sort(armstrong);
        armstrong.forEach(System.out::println);
    }


    //  Метод возвращает массив цифр числа number
    private static ArrayList<Byte> numbers(long number) {
        ArrayList<Byte> result = new ArrayList<>();
        while (number>=10) {
            result.add((byte) (number%10));
            number= number/10;
        }
        result.add((byte)number);
        return result;
    }

    //    Метод возврачает True, если слово содержит в себе все цифры массива
    private static boolean equals(byte[] numbers1, ArrayList<Byte> numbers2) {
        if (numbers1.length != numbers2.size()) {
            return false;
        } else {
            List<byte[]> b = Arrays.asList(numbers1);
                for (Byte number: numbers1) {
                    if (!numbers2.contains(number)) {
                        break;
                    }
                    numbers2.remove(number);

                }
            return (numbers2.size()==0);
        }
    }

    //  Метод поиска и записи числа Армстронга
    private static void writeResult(byte[] numbers, List<Long> purpose) {
        long result = 0;
        int degree = numbers.length;
        for (Byte number : numbers) {
            result+= ArmstrongNumbers.degree.getDegree(degree, number);
        }
        if (equals(numbers, numbers(result)) && result > 0) {
            count++;
            System.out.println(count + " " + result);
            purpose.add(result);
        }
    }

    static String line = "";


    public static void getSequence() {
        byte value = 1;

        for (byte i19 = 0; i19 < 10; i19++) {
            for (byte i18 = i19; i18 < 10; i18++) {
                for (byte i17 = i18; i17 < 10; i17++) {
                    for (byte i16 = i17; i16 < 10; i16++) {
                        for (byte i15 = i16; i15 < 10; i15++) {
                            for (byte i14 = i15; i14 < 10; i14++) {
                                for (byte i13 = i14; i13 < 10; i13++) {
                                    for (byte i12 = i13; i12 < 10; i12++) {
                                        for (byte i11 = i12; i11 < 10; i11++) {
                                            for (byte i10 = i11; i10 < 10; i10++) {
                                                for (byte i9 = i10; i9 < 10; i9++) {
                                                    for (byte i8 = i9; i8 < 10; i8++) {
                                                        for (byte i7 = i8; i7 < 10; i7++) {
                                                            for (byte i6 = i7; i6 < 10; i6++) {
                                                                for (byte i5 = i6; i5 < 10; i5++) {
                                                                    for (byte i4 = i5; i4 < 10; i4++) {
                                                                        for (byte i3 = i4; i3 < 11; i3++) {
                                                                            for (byte i2 = i3; i2 < 11; i2++) {
                                                                                for (byte i1 = i2; i1 < 11; i1++) {

//                                                                                  1
                                                                                    if (i1>0 && i2==0) {
                                                                                        writeResult(new byte[]{(byte) (i1 % 10)},armstrong);
                                                                                    }
//                                                                                  2
                                                                                    if (i2>0 && i3==0) {
                                                                                        writeResult(new byte[]{(byte) (i2 % 10), (byte) (i1 % 10)},armstrong);
                                                                                    }
//                                                                                  3
                                                                                    if (i3>0 && i4==0) {
                                                                                        writeResult(new byte[]{(byte) (i3 % 10),(byte) (i2 % 10), (byte) (i1 % 10)},armstrong);
                                                                                    }
//                                                                                  4
                                                                                    if (i4>0 && i5==0) {
                                                                                        writeResult(new byte[]{i4, (byte) (i3 % 10),(byte) (i2 % 10), (byte) (i1 % 10)},armstrong);
                                                                                    }
//                                                                                  5
                                                                                    if (i5>0 && i6==0) {
                                                                                        writeResult(new byte[]{i5, i4, (byte) (i3 % 10),(byte) (i2 % 10), (byte) (i1 % 10)},armstrong);
                                                                                    }
//                                                                                  6
                                                                                    if (i6>0 && i7==0) {
                                                                                        writeResult(new byte[]{i6, i5, i4, (byte) (i3 % 10),(byte) (i2 % 10), (byte) (i1 % 10)},armstrong);
                                                                                    }
//                                                                                  7
                                                                                    if (i7>0 && i8==0) {
                                                                                        writeResult(new byte[]{i7, i6, i5, i4, (byte) (i3 % 10),(byte) (i2 % 10), (byte) (i1 % 10)},armstrong);
                                                                                    }
//                                                                                  8
                                                                                    if (i8>0 && i9==0) {
                                                                                        writeResult(new byte[]{i8, i7, i6, i5, i4, (byte) (i3 % 10),(byte) (i2 % 10), (byte) (i1 % 10)},armstrong);
                                                                                    }
//                                                                                  9
                                                                                    if (i9>0 && i10==0) {
                                                                                        writeResult(new byte[]{i9, i8, i7, i6, i5, i4, (byte) (i3 % 10),(byte) (i2 % 10), (byte) (i1 % 10)},armstrong);
                                                                                    }
//                                                                                  10
                                                                                    if (i10>0 && i11==0) {
                                                                                        writeResult(new byte[]{i10, i9, i8, i7, i6, i5, i4, (byte) (i3 % 10),(byte) (i2 % 10), (byte) (i1 % 10)},armstrong);
                                                                                    }
//                                                                                  11
                                                                                    if (i11>0 && i12==0) {
                                                                                        writeResult(new byte[]{i11, i10, i9, i8, i7, i6, i5, i4, (byte) (i3 % 10),(byte) (i2 % 10), (byte) (i1 % 10)},armstrong);
                                                                                    }
//                                                                                  12
                                                                                    if (i12>0 && i13==0) {
                                                                                        writeResult(new byte[]{i12, i11, i10, i9, i8, i7, i6, i5, i4, (byte) (i3 % 10),(byte) (i2 % 10), (byte) (i1 % 10)},armstrong);
                                                                                    }
//                                                                                  13
                                                                                    if (i13>0 && i14==0) {
                                                                                        writeResult(new byte[]{i13, i12, i11, i10, i9, i8, i7, i6, i5, i4, (byte) (i3 % 10),(byte) (i2 % 10), (byte) (i1 % 10)},armstrong);
                                                                                    }
//                                                                                  14
                                                                                    if (i14>0 && i15==0) {
                                                                                        writeResult(new byte[]{i14, i13, i12, i11, i10, i9, i8, i7, i6, i5, i4, (byte) (i3 % 10),(byte) (i2 % 10), (byte) (i1 % 10)},armstrong);
                                                                                    }
//                                                                                  15
                                                                                    if (i15>0 && i16==0) {
                                                                                        writeResult(new byte[]{i15, i14, i13, i12, i11, i10, i9, i8, i7, i6, i5, i4, (byte) (i3 % 10),(byte) (i2 % 10), (byte) (i1 % 10)},armstrong);
                                                                                    }
//                                                                                  16
                                                                                    if (i16>0 && i17==0) {
                                                                                        writeResult(new byte[]{i16, i15, i14, i13, i12, i11, i10, i9, i8, i7, i6, i5, i4, (byte) (i3 % 10),(byte) (i2 % 10), (byte) (i1 % 10)},armstrong);
                                                                                    }
//                                                                                  17
                                                                                    if (i17>0 && i18==0) {
                                                                                        writeResult(new byte[]{i17, i16, i15, i14, i13, i12, i11, i10, i9, i8, i7, i6, i5, i4, (byte) (i3 % 10),(byte) (i2 % 10), (byte) (i1 % 10)},armstrong);
                                                                                    }
//                                                                                  18
                                                                                    if (i18>0 && i19==0) {
                                                                                        writeResult(new byte[]{i18, i17, i16, i15, i14, i13, i12, i11, i10, i9, i8, i7, i6, i5, i4, (byte) (i3 % 10),(byte) (i2 % 10), (byte) (i1 % 10)},armstrong);
                                                                                    }
                                                                                    if (i19 == 8 && i18 == 9) {
                                                                                        return;
                                                                                    }
//                                                                                  19
                                                                                    if (i19>0 ) {
                                                                                        writeResult(new byte[]{i19, i18, i17, i16, i15, i14, i13, i12, i11, i10, i9, i8, i7, i6, i5, i4, (byte) (i3 % 10),(byte) (i2 % 10), (byte) (i1 % 10)},armstrong);
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