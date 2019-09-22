package productshop.util;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileIOUtil {

    String readFile(String filePath) throws IOException;

    String readFileFromResources(String filePath) throws IOException;

    void write(String text, String path);
}
