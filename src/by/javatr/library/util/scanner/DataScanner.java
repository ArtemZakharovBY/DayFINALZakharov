package by.javatr.library.util.scanner;

import java.io.InputStream;
import java.util.Scanner;

public class DataScanner {
    private static final InputStream INPUT_STREAM = System.in;
    private static final Scanner SCANNER = new Scanner(INPUT_STREAM);//ну и зачем козе такой баян? с объявление константы для и так уже константы

    public static int integerFromConsole(){

        int number = 0;
        while (!SCANNER.hasNextInt()){

            SCANNER.next();
        }
        number = SCANNER.nextInt();

        return number;
    }

    public static String textFromConsole(){

        String text = null;
        while (!SCANNER.hasNextLine()){

            SCANNER.next();
        }
        text = SCANNER.nextLine();

        return text;
    }
}
