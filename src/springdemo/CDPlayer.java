package springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * JavaDemo
 * springdemo
 * Created by timothy on 16/7/24.
 */

@Component
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd) {

        this.cd = cd;
    }

    @Override
    public void play() {

        cd.play();
    }

    public CompactDisc getCd() {

        return this.cd;
    }
}
