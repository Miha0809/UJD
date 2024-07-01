import java.io.File;
import java.util.Arrays;

public class ReadAll implements IRead {
    @Override
    public void Read(String path) {
        File[] files = new File(path).listFiles();

        if (files != null) {
            Arrays.sort(files, (file1, file2) -> {
                if (file1.isDirectory() && !file2.isDirectory()) {
                    return -1;
                }
                else if (!file1.isDirectory() && file2.isDirectory()) {
                    return 0;
                }
                else {
                    return file1.getName().compareToIgnoreCase(file2.getName());
                }
            });

            Arrays.stream(files).forEach(System.out::println);
        }
    }
}
