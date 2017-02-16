package springdemo;

import org.springframework.stereotype.Component;

/**
 * JavaDemo
 * springdemo
 * Created by timothy on 16/7/24.
 */
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {

        System.out.println("Playing " + title + " by " + artist);
    }
}
