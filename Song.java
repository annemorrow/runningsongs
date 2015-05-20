import java.io.IOException;
import java.awt.Desktop;
import java.io.File;

public class Song implements Comparable<Song> {
  
  private String path;
  private String name; // haven't done anything with this yet
  private int bpm;
  
  public Song (String path, int bpm) {
    this.path = path;
    this.bpm = bpm;
  }
  
  public Song (String path) {
    if (path.endsWith(".mp3")) {
    this.path = path;
    this.bpm = findBPM(path);
    }
  }
  
  public String path() {
    return this.path;
  }
  
  public int bpm() {
    return this.bpm;
  }
  
  // this is going to be the real trick
  private int findBPM(String path) {
    return 0;
  }
  
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