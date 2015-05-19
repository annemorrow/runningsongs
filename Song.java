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
    //  TODO: check whether the file is a song type using regular expressions
    this.path = path;
    this.bpm = findBPM(path);
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
    MP3 song = new MP3(path);
    song.play();
  }
  
  public int compareTo(Song that) {
    if (this.bpm < that.bpm) return -1;
    if (this.bpm > that.bpm) return 1;
    return (this.path.compareTo(that.path));
  }
  
  public static void main (String[] args) {
    play("/Users/anne/Music/iTunes/iTunes Music/Firefly/Firefly/01 Hero of Canton.mp3");
    
    play("/Users/anne/Music/iTunes/iTunes Music/George Papavgeris/For My Next Trick/02 Glory Gone.mp3");
  }
  
}