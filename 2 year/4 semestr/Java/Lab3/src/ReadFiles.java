import java.io.File;
import java.util.Arrays;

public class ReadFiles implements IRead {
    @Override
    public void Read(String path) {
        File directory = new File(path);
        File[] files = directory.listFiles(File::isFile);

        if (files != null) {
            Arrays.stream(files).forEach(System.out::println);
        }
    }
}
