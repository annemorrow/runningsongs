import java.io.IOException;
import java.awt.Desktop;
import java.io.File;

public class Song implements Comparable<Song> {
  
  private String path;
  private String name; // haven't done anything with this yet
  private int bpm;
  
  /**
  * Create a Song object from the absolute path when the beats per minute is known
  */
  public Song (String path, int bpm) {
    this.path = path;
    this.bpm = bpm;
  }
  
  /**
  * Create a Song object from the absolute path when the beats per minute must be calculated.
  */
  public Song (String path) {
    if (path.endsWith(".mp3")) {
    this.path = path;
    this.bpm = findBPM(path);
    }
  }
  
  /**
  * Returns the stored absolute path of a Song object.
  */
  public String path() {
    return this.path;
  }
  
  /**
  * Returns the stored beats per minute of a Song object.
  */
  public int bpm() {
    return this.bpm;
  }
  
  /**
  * Calculates the beats per minute of a song.
  */
  private int findBPM(String path) {
    return 0;
  }
  
  /**
  * Plays the song (must be mp3 or wav format).
  */
  public static void play(String path) {
    if (path.endsWith(".mp3")) {
      MP3 song = new MP3(path);
      song.play();
    } else if (path.endsWith(".wav")) {
      StdAudio.play(path);
    }
  }
  
  public int compareTo(Song that) {
    if (this.bpm < that.bpm) return -1;
    if (this.bpm > that.bpm) return 1;
    return (this.path.compareTo(that.path));
  }
  
  public static void main (String[] args) {
    double[] array = StdAudio.read("wavsongs/The Hero of Canton.wav");
    StdAudio.play(array);
  }
  
}