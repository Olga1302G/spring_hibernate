import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Less9_2 {
    public static void main(String[] args) throws IOException {
        byte[] bb = new byte[] {48, 49, 50, 51}; //0, 1, 2, 3
        ByteArrayInputStream bis = new ByteArrayInputStream(bb);
        System.out.println(readAsString(bis, Charset.forName("ASCII")));
        //Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII);
        //writer.write("?");
        //writer.close();
        //String s = "Ы";
        // byte[] b = s.getBytes();
        //for (int i = 0; i < b.length; i++) {
        //  System.out.print(((int) b[i] ^ -1 << 8)+" ");
        // }
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        int b;
        StringBuilder resultStr = new StringBuilder();
        InputStreamReader streamReader = new InputStreamReader(inputStream, charset);
        while (streamReader.ready()) {
            b = streamReader.read();
            resultStr.append((char)b);
        }
        streamReader.close();
        return resultStr.toString();
    }
}
