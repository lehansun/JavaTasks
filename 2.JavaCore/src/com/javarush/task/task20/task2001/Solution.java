package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("D:\\Алексей\\test1.txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human(null, null);
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            System.out.println(ivanov.equals(somePerson));
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            if (name == null) {
                outputStream.write("no\n".getBytes());//implement this method - реализуйте этот метод
                outputStream.flush();
            } else {
                outputStream.write((name + "\n").getBytes());
                outputStream.flush();
            }

            if (assets.isEmpty()) {
                outputStream.write("0\n".getBytes());
                outputStream.flush();
            } else {
                outputStream.write(("" + assets.size() + "\n").getBytes());
                outputStream.flush();
                for (Asset asset : assets) {
                    outputStream.write((asset.getName() + " ").getBytes());
                    outputStream.write((asset.getPrice() + "\n").getBytes());
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String data = reader.readLine();

            if (data.equals("no")) {
                name = null;
            } else {
                name = data;
            }

            data = reader.readLine();
            int size = Integer.parseInt(data);
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    data = reader.readLine();
                    String[] part = data.split(" ");
                    assets.add(new Asset(part[0], Double.parseDouble(part[1])));
                }
            }
        //implement this method - реализуйте этот метод
        }
    }
}
