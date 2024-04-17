package zadanie3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class zadanie5 {
    public static void main(String[] args) {
       String file = args[0];

       try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = "";
            int countLine = 0;

            while ((line = reader.readLine()) != null) {
                countLine++;

                if (countLine % 2 == 0) {
                    System.out.println(countLine + ". " + line);
                }
            }
       } catch (IOException e) {

       }
    }
}

