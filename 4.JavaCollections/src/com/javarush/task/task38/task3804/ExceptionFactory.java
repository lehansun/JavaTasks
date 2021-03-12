package com.javarush.task.task38.task3804;

public class ExceptionFactory {

    public static Throwable getException(Enum e) throws Exception {
        if (e != null) {

            String m = e.toString();
            m = m.charAt(0) + m.substring(1).toLowerCase().replaceAll("_", " ");

            if (e.getClass().equals(ApplicationExceptionMessage.class)) {
                return new Exception(m);
            }

            if (e.getClass().equals(DatabaseExceptionMessage.class)) {
                return new RuntimeException(m);

            }

            if (e.getClass().equals(UserExceptionMessage.class)) {
                return new Error(m);
            }
        }

        return new IllegalArgumentException();
    }

}
