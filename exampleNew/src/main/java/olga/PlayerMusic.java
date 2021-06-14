import olga.ClassicMusic;
import olga.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerMusic {

    private ClassicMusic classicMusic;
    //private olga.RockMusic rockMusic;

@Autowired
    public  PlayerMusic (ClassicMusic classicMusic) {
        this.classicMusic = classicMusic;
        //this.rockMusic = rockMusic;
    }
    public PlayerMusic (){}

    public void  playMusic() {
        System.out.println("Playing ..." + classicMusic.getMusic());
    }


}
