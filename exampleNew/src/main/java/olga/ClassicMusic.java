import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("musicBean")
public class ClassicMusic implements Music {
    @Override
    public String getMusic() {
       return  "Classic Music!";
    }
}
