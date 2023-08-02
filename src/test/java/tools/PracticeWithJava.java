package tools;

import org.junit.Test;

public class PracticeWithJava {

    @Test
    public void name() {
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        System.out.println(cars[0]);
    }

    @Test
    public void twoDimArray() {
        String[][] cars = {
                {"Volvo", "1983"},
                {"BMW", "1945"},
                {"Ford", "2342"},
                {"Mazda", "43324"}
        };

        for (String[] eachRow : cars) {
            System.out.println(eachRow[0] + " " + eachRow[1]);
        }
    }
}
