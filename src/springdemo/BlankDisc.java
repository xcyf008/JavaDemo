package springdemo;

import java.util.List;

/**
 * JavaDemo
 * springdemo
 * Created by timothy on 16/7/24.
 */
public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> tracks;

    public BlankDisc(String title, String artist, List<String> tracks) {

        this.title = title;
        this.artist = artist;
        this.tracks = tracks;
    }

    @Override
    public void play() {

        System.out.println("Playing " + title + " by " + artist);

        for (String s: tracks) {

            System.out.println("--Track: " + s);
        }
    }
}
