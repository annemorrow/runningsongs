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
  
  public static void play(String path) throws IOException  {
      File file = new File(path);
      //first check if Desktop is supported by Platform or not
      if(!Desktop.isDesktopSupported()){
          System.out.println("Desktop is not supported");
          return;
      }
      Desktop desktop = Desktop.getDesktop();
      if(file.exists()) desktop.open(file);
  }
  
  public int compareTo(Song that) {
    if (this.bpm < that.bpm) return -1;
    if (this.bpm > that.bpm) return 1;
    return (this.path.compareTo(that.path));
  }
  
  public static void main (String[] args) throws IOException {
    play("/Users/anne/Music/iTunes/iTunes Music/Young Dubliners/Nine/05 Seeds of Sorrow.m4a");
  }
  
}