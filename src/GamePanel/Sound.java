package GamePanel;

import javax.sound.sampled.*;
import java.io.InputStream;

public class Sound {
    private Clip clip;

    public void playMusic(String filePath) {
        try {
            // Load the file as a stream from resources
            InputStream audioStream = getClass().getResourceAsStream(filePath);
            if (audioStream == null) {
                throw new IllegalArgumentException("File not found: " + filePath);
            }

            // Convert InputStream to AudioInputStream
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(audioStream);

            // Get and open the clip
            clip = AudioSystem.getClip();
            clip.open(audioInput);

            // Play and loop the clip
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public boolean isPlaying() {
        return clip != null && clip.isRunning();
    }
}
