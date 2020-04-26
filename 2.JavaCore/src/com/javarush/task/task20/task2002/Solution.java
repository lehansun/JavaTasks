package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream
        // according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream
        // в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = new File("D:\\Алексей\\test1.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            for (int i = 0; i < 10; i++) {
                User user = new User();
                user.setFirstName("User_" + i);
                user.setLastName("Test");
                user.setBirthDate(new Date());
                javaRush.users.add(user);
            }//initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(javaRush.equals(loadedObject));//here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream)); //implement this method - реализуйте этот метод
            writer.write(users.size() + "\n");
            if (users.size()>0) {
                for (User user : users) {
                    String result = (user.getFirstName() == null ? "null" : user.getFirstName()) + " " +
                            (user.getLastName() == null ? "null" : user.getLastName()) + " " +
                            (user.getBirthDate() == null ? "null" : user.getBirthDate().getTime()) + " " +
                            user.isMale() + " " +
                            (user.getCountry() == null ? "null" : user.getCountry().getDisplayName());
                    writer.write(result + "\n");
                }
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));//implement this method - реализуйте этот метод
            String line = reader.readLine();
            int size = Integer.parseInt(line);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    line = reader.readLine();
                    if (line.equals("null")) {
                        users.add(new User());
                    } else {
                        String[] data = line.split(" ");
                        User user = new User();
                        user.setFirstName(data[0].equals("null") ? null : data[0]);
                        user.setLastName(data[1].equals("null") ? null : data[1]);
                        user.setBirthDate(data[2].equals("null") ? null : new Date(Long.parseLong(data[2])));
                        user.setMale(data[3].equals("true"));
                        switch (data[4]) {
                            case "Ukraine":
                                user.setCountry(User.Country.UKRAINE);
                                break;
                            case "Russia":
                                user.setCountry(User.Country.RUSSIA);
                                break;
                            case "Other":
                                user.setCountry(User.Country.OTHER);
                            case "null" :
                                user.setCountry(null);
                                break;
                        }
                        users.add(user);
                    }
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
