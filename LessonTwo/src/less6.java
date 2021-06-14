import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class less6 {
    public static void main(String[] args) throws IOException {
        byte[] input = {1, 2, 4, 10, -4};
        InputStream inputStream = new ByteArrayInputStream(input);
        int result = sumOfStream(inputStream);
        System.out.println(result);

    }
    public static int sumOfStream(InputStream inputStream) throws IOException {
        int b;
        while ((b=inputStream.read())>0) {
            b += b;//твой код здесь
        }
        return b;
    }
}
