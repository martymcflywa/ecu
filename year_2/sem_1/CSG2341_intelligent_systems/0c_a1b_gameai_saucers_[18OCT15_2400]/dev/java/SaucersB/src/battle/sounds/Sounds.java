package battle.sounds;
import java.applet.*;
import java.net.*;

public class Sounds
{
    private static final int N_SOUNDS = 4;
    private static final int SHOT = 0;
    private static final int HIT = 1;
    private static final int EXPLODE = 2;
    private static final int POWERUP = 3;
    private static AudioClip[] audioClips = new AudioClip[N_SOUNDS];
    private static String[] audioFilenames = {"woosh.wav", "hit.au", "bomb.wav", "poweringUp.wav"};
    
    private static boolean loaded = false;
    
    /**
     * Load audio clips for sound effects
     */
    public static void loadSounds()
    {
        for(int i = 0; i < N_SOUNDS; i++)
        {
            try
            {
                audioClips[i] = Applet.newAudioClip(new URL("file:"+audioFilenames[i]));
            }
            catch (Exception e)
            {
                e.printStackTrace(System.err);
                audioClips[i] = null;
            }
        }
        
        loaded = true;
    }
    
    private static void play(int aCode)
    {
        if(!loaded) return;
        
        AudioClip clip = null;
        if(aCode >= 0 && aCode < N_SOUNDS)
        {
            clip = audioClips[aCode];
        }
        
        if(clip != null)
        {
            clip.play();
        }
    }

    public static void playShot()
    {
        play(SHOT);
    }

    public static void playHit()
    {
        play(HIT);
    }
    
    public static void playExplode()
    {
        play(EXPLODE);
    }

    public static void playPowerUp()
    {
        play(POWERUP);
    }
}
