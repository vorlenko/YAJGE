/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yajge.framework.utils.audio;

import java.net.URL;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author bob
 */
public class AudioPlayer {

    private Clip clip;

    public AudioPlayer(String s) {
        URL url = this.getClass().getClassLoader().getResource(s);
        try {
            //"/Resources/Music/level1-1.mp3"
            AudioInputStream ais
                    = AudioSystem.getAudioInputStream(
                            getClass().getResourceAsStream(
                                    s
                            )
                    );

            AudioFormat baseFormat = ais.getFormat();
            AudioFormat decodeFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(),
                    baseFormat.getChannels() * 2,
                    baseFormat.getSampleRate(),
                    false
            );
            AudioInputStream dais
                    = AudioSystem.getAudioInputStream(
                            decodeFormat, ais);
            clip = AudioSystem.getClip();
            clip.open(dais);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void play() {
        if (clip == null) {
            return;
        }
        stop();
        clip.setFramePosition(0);
        clip.start();
    }

    public void stop() {
        if (clip.isRunning()) {
            clip.stop();
        }
    }

    public void close() {
        stop();
        clip.close();
    }
}
