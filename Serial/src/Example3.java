import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class Example3 {
    public static void main(String[] args) throws FileNotFoundException {
        LinkedHashMap <Integer, String> set = new LinkedHashMap<>(5, 3, true) ;
        set.put(5, "a");
        set.put(4, "b");
        set.put(3, "c");
        set.put(2, "d");
        set.put(1, "e");
        set.get(4);
        set.get(2);
        System.out.println(set);


        //FileReader reader = new FileReader("C:\\Users\\Пользователь\\IdeaProjects\\Serial\\src\\test.txt");
       // for (Map.Entry<String, Long> entry : getSalesMap(reader).entrySet()) {
        //    System.out.println(entry);
        }


    public static Map<String, Long> getSalesMap(Reader reader) {
        Scanner scanner = new Scanner(reader);
        Map <String, Long> map = new HashMap<>();
        while (scanner.hasNext()){
         String key = scanner.next();
         long value = scanner.nextLong();
         map.merge(key, value, (oldValue, newValue) -> oldValue + newValue);
        }
        return map;
        //Твой код здесь
    }
}
