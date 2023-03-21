package util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner userInput = new Scanner(System.in);

    public static String input(String question) {
        System.out.print(question + " : ");
        return userInput.nextLine();
    }
}
