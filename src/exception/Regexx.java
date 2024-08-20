package exception;

import java.util.Scanner;

public class Regexx {
    Scanner scanner = new Scanner(System.in);
    public String formatStringName () {
        String regex = "[A-Za-z]+(?:\\s[A-Za-z]+)*";
        String name;
        while (true) {
            name = scanner.nextLine();
            if (name.matches(regex)) {
                return name;
            }else {
                System.out.println("Sai định dạng tên !!");
            }
        }
    }

}
