package redroverHW.lesson2;


public class Homework2 {
    public static void main(String[] args) {
    int a = 785;
    int b = 654;

    int sumResult = a + b;
    int mulResult = a * b;
    int subResult = a - b;
    int divResult = a / b;
    int divResultReminder = a % b;

        // parity check
        int [] evenNumbers = {sumResult, mulResult, subResult, divResult};
        for (int x : evenNumbers) {
            if (x % 2 == 0)
                System.out.println(x + " is even number");
            else
                System.out.println(x + " is odd number");
        }
        System.out.println(divResultReminder + " is reminder from division");
    }
}