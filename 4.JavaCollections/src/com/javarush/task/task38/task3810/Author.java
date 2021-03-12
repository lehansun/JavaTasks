package com.javarush.task.task38.task3810;

public @interface Author {
    //напиши свой код
//    authors = {@Author(value = "Серега", position = Position.MIDDLE)},
    String value();
    Position position() default Position.OTHER;
}
