package ap.project.civilization.view.util.game;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class MusicPlayer {
    private Clip clip;

    private String MUSIC_PATH = "/audio/aspose_bensound-prism.wav";

    /*
    Music: Bensound
    License code: D8H768WHRRBQ1PS6
    Artist: : Theatre Of Delays
     */

    public void play() {
        try {
            URL url = getClass().getResource(MUSIC_PATH);
            if (url == null) {
                throw new IllegalArgumentException("Music file not found: " + MUSIC_PATH);
            }

            AudioInputStream audio = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audio);

            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }
}
