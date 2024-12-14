    package GamePanel;

    import javax.sound.sampled.*;

    public class Sound {
        private Clip backgroundClip; // Clip for background music
        private Clip effectClip;     // Clip for one-time sound effects

        public void playBackgroundMusic(String filePath) {
            try {
                if (backgroundClip == null) {
                    // Load and initialize the background music clip
                    AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource(filePath));
                    backgroundClip = AudioSystem.getClip();
                    backgroundClip.open(audio);
                    backgroundClip.loop(Clip.LOOP_CONTINUOUSLY); // Loop background music
                }

                // Start background music only if it's not already playing
                if (!backgroundClip.isRunning()) {
                    backgroundClip.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void stopBackgroundMusic() {
            if (backgroundClip != null && backgroundClip.isRunning()) {
                backgroundClip.stop();
            }
        }

        public void playEffectSound(String filePath) {
            try {
                // Stop and release the previous effect clip (if any) to avoid overlap
                if (effectClip != null && effectClip.isRunning()) {
                    effectClip.stop();
                }

                // Load a new sound effect
                AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource(filePath));
                effectClip = AudioSystem.getClip();
                effectClip.open(audio);

                // Play the sound effect once
                effectClip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
