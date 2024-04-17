package zadanie3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class zadanie5 {
    public static void main(String[] arg){
        if (arg.length == 0) {
            return;
        }
        
        String file = arg[0];
        String minLine = "";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = "";
            int countLine = Integer.MAX_VALUE;

            while ((line = reader.readLine()) !=null ) {
                if (line.length() < countLine){
                    countLine = line.length();
                    minLine = line;
                }
            }
        } catch (IOException e){}

        System.out.println(minLine);
    }   
}