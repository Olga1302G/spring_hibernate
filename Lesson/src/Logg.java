import java.util.logging.Logger;
//package com.javamentor.logging.Test;

public class Logg {
    public static void logging() {
        Logger logger = Logger.getLogger("com.javamentor.logging.Test");
        logger.info("Some message");
        logger.warning("Произошла ошибка");//Твой код здесь
    }
}
