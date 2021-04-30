package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber != null) {

            if (telNumber.matches("^\\+\\d*(\\(\\d{3}\\))?\\d+-?\\d+-?\\d+$")
                    && telNumber.replaceAll("[+()\\-]", "").length() == 12) {
                return true;
            }

            if (telNumber.matches("\\d*(\\(\\d{3}\\))?\\d+-?\\d+-?\\d+$")
                    && telNumber.replaceAll("[()\\-]", "").length() == 10) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+123456901-20-9") + " expected TRUE");
        System.out.println(checkTelNumber("+(123)456789012") + " expected TRUE");
        System.out.println(checkTelNumber("+1(234)5-6789012") + " expected TRUE");
        System.out.println(checkTelNumber("+1(234)5-67890-12") + " expected TRUE");
        System.out.println(checkTelNumber("+12(345)678-9012") + " expected TRUE");
        System.out.println(checkTelNumber("+12(345)67-89012") + " expected TRUE");
        System.out.println(checkTelNumber("+12(345)6-789012") + " expected TRUE");
        System.out.println(checkTelNumber("+12(345)-6789012") + " expected FALSE");
        System.out.println(checkTelNumber("+12(34)56789-012") + " expected FALSE");
        System.out.println(checkTelNumber("+123456789--012") + " expected FALSE");
        System.out.println("//////////////////////////////////////////////////////////");
        System.out.println(checkTelNumber("1234567890") + " expected TRUE");
        System.out.println(checkTelNumber("(123)4567890") + " expected TRUE");
        System.out.println(checkTelNumber("(123)4-567-890") + " expected TRUE");
        System.out.println(checkTelNumber("1(234)5-67890") + " expected TRUE");
        System.out.println(checkTelNumber("1(234)5-67890") + " expected TRUE");
        System.out.println(checkTelNumber("12(345)678-90") + " expected TRUE");
        System.out.println(checkTelNumber("12(345)67-890") + " expected TRUE");
        System.out.println(checkTelNumber("12(345)6-7890") + " expected TRUE");
        System.out.println(checkTelNumber("12(345)-67890") + " expected FALSE");
        System.out.println(checkTelNumber("12(34)56789-0") + " expected FALSE");
        System.out.println(checkTelNumber("123456789--0") + " expected FALSE");
        System.out.println("//////////////////////////////////////////////////////////");
        System.out.println(checkTelNumber("+380501234567") + " expected TRUE");
        System.out.println(checkTelNumber("+38(050)1234567") + " expected TRUE");
        System.out.println(checkTelNumber("+38050123-45-67") + " expected TRUE");
        System.out.println(checkTelNumber("050123-4567") + " expected TRUE");
        System.out.println(checkTelNumber("+38)050(1234567") + " expected FALSE");
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7") + " expected FALSE");
        System.out.println(checkTelNumber("050ххх4567") + " expected FALSE");
        System.out.println(checkTelNumber("050123456") + " expected FALSE");
        System.out.println(checkTelNumber("(0)501234567") + " expected FALSE");
        System.out.println(checkTelNumber("(050)123456") + " expected FALSE");

    }
}
