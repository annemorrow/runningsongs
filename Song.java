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
  
  // there is an example on Sedgewick's website
  public void play(String path) {
    
  }
  
  public int compareTo(Song that) {
    if (this.bpm < that.bpm) return -1;
    if (this.bpm > that.bpm) return 1;
    return 0;
  }
  
}