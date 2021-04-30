package com.javarush.task.task31.task3110;

public enum Operation {
    CREATE("упаковать файлы в архив"),
    ADD("добавить файл в архив"),
    REMOVE("удалить файл из архива"),
    EXTRACT("распаковать архив"),
    CONTENT("просмотреть содержимое архива"),
    EXIT("выход");

    Operation(String title) {
        this.title = title;
    }

    private String title;


    public String getTitle() {
        return this.title;
    }
}
