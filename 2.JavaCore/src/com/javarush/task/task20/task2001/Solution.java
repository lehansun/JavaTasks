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
            String file = "D:\\Алексей\\test1.txt";
            BufferedWriter outputStream = new BufferedWriter(new FileWriter(file));
            BufferedReader inputStream = new BufferedReader(new FileReader(file));

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
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

        public void save(BufferedWriter writer) throws Exception {
            if (name != null) {
                writer.write(name + "\n");
                writer.flush();
            }

            String isAssetPresent = assets != null ? "" + assets.size() : "no";
            writer.write(isAssetPresent + "\n");
            writer.flush();

            for (Asset asset : assets) {
                asset.save(writer);
            }
            //implement this method - реализуйте этот метод
        }

        public void load(BufferedReader reader) throws Exception {
            name = reader.readLine();
            String isAssetPresent = reader.readLine();
            if (!isAssetPresent.equals("no")) {
                //implement this method - реализуйте этот метод
                for (int i = 0; i < Integer.parseInt(isAssetPresent); i++) {
                    Asset asset = new Asset().load();
                    asset.load(reader);
                    assets.add(asset);
                }
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
    }
}
