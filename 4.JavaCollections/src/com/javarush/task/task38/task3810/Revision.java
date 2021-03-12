package com.javarush.task.task38.task3810;

public @interface Revision {
    //напиши свой код
    int revision();
    Date date();
    Author[] authors() default {};
    String comment() default "";

//    revision = 4089,
//    date = @Date(year = 2011, month = 5, day = 30, hour = 18, minute = 35, second = 18),
//    comment = "Новый файл добавлен"),
}
