package ap.project.civilization.view.util.game;

import ap.project.civilization.view.util.ui.ViewConstants;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class MusicPlayer {
    private Clip clip;
    private int volume = ViewConstants.INIT_MUSIC_VOLUME;

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

            applyVolume();

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

    public void setVolume(int percent) {
        volume = percent;
        if (clip == null) return;
        applyVolume();
    }

    public void applyVolume() {
        if (!clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) return;

        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

        float min = gainControl.getMinimum();
        float max = gainControl.getMaximum();

        float gain;
        if (volume == 0) {
            gain = min;
        } else {
            gain = (float) (20.0 * Math.log10(volume / 100.0));
            gain = Math.max(min, Math.min(max, gain));
        }

        gainControl.setValue(gain);
    }
}
