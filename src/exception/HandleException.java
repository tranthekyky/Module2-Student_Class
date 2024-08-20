package exception;

import java.util.Scanner;

public class HandleException {
    Scanner scanner = new Scanner(System.in);
    public int inputNumberInt() {
        do {
            int number;
            try {
                number = Integer.parseInt(scanner.nextLine());
                return number;
            }catch (NumberFormatException e) {
                System.out.println("Wrong number format !!");
            }
        }while (true);
    }
    public double inputNUmberDouble() {
        double number;
        do {
            try {
                number = Double.parseDouble(scanner.nextLine());
                return number;
            }catch (NumberFormatException e) {
                System.out.println("Wrong number format !!");
            }
        }while (true) ;

    }
    public String inputString() {
        return scanner.nextLine();
    }

}
