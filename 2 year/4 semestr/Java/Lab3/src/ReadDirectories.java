import java.io.File;
import java.util.Arrays;

public class ReadDirectories implements IRead {
    @Override
    public void Read(String path) {
        File direcototy = new File(path);
        File[] files = direcototy.listFiles(File::isDirectory);

        if (files != null) {
            Arrays.stream(files).forEach(System.out::println);
        }
    }
}
