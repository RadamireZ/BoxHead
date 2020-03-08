package gui;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;



public class ClipInfo implements LineListener
{
  private final static String SOUND_DIR = "Sounds/";

  private String filename;
  private Clip clip = null;


  public ClipInfo(String fnm)
  { 
    filename = SOUND_DIR + fnm;

    loadClip(filename);
  }


  private void loadClip(String fnm)
  {
    try {
        URL url = this.getClass().getClassLoader().getResource(fnm);

      AudioInputStream stream = AudioSystem.getAudioInputStream(url);

      clip = (Clip) AudioSystem.getClip();

      clip.addLineListener(this);

      clip.open(stream);
      stream.close();
     
    }
    catch (IOException ioException) {
    }
    catch (Exception e) {
    }
  }





  public void update(LineEvent lineEvent)
  {
    if (lineEvent.getType() == LineEvent.Type.STOP) {
      clip.stop();
      clip.setFramePosition(0);
    }
  }
  
 

  public void play()
  { if (clip != null) {
      clip.start();
    }
  }

  public void stop()
  { if (clip != null) {
      clip.stop();
      clip.setFramePosition(0);
    }
  }


};