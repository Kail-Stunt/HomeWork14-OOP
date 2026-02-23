package org.skypro.skyshop.exeptions;

import java.io.IOException;

public class BestResultNotFoundException extends IOException {
    private final String mostFound;

    public BestResultNotFoundException(String mostFound) {
        super();
        this.mostFound = mostFound;
    }

//    @Override
//    public String toString() {
//        return "Для поискового запроса '" + mostFound + "' не нашлось подходящего результата.";
//    }
}
