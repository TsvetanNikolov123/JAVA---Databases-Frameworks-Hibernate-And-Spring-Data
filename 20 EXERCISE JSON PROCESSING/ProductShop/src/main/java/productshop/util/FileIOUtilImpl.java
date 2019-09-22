package productshop.util;

import org.springframework.util.ResourceUtils;
import org.springframework.util.StreamUtils;
import productshop.web.controller.ProductShopController;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class FileIOUtilImpl implements FileIOUtil {

    @Override
    public String readFile(String filePath) throws IOException {
        File file = new File(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    @Override
    public String readFileFromResources(String filePath) throws IOException {
        InputStream stream = ProductShopController.class.getResourceAsStream(filePath);
        String source = StreamUtils.copyToString(stream, Charset.defaultCharset());
        return source;
    }

    @Override
    public void write(String text, String path) {
        try {
            Files.writeString(
                    ResourceUtils.getFile(path).toPath(),
                    text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
