import org.springframework.stereotype.Component;


public class RockMusic implements Music {
    @Override
    public String getMusic() {
        return "Rock Music!!!!";
    }
}
