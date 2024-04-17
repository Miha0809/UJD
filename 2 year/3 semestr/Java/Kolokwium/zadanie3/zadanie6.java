package zadanie3;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class zadanie6 {
    public static void main(String[] args) {
        String file = "file.bin";
        Integer[] numbers = {2, -1, -4, 3};
        String[] strs = {"A", "B"};

        writeToFile(file, numbers, strs);
    }

    public static void writeToFile(String file, Integer[] numbers, String[] strs) {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < numbers.length; i++) {
                dos.writeInt(numbers[i]);
            }

            for (int i = 0; i < strs.length; i++) {
                dos.writeUTF(strs[i]);
            }
            
        } catch (IOException e) {

        }
    }
}
