import java.util.Arrays;

public class SongList {
  private Song[] library;
  private int size;
  private int LIBRARY_BUFFER = 30;
  
  public SongList() {
    In list = new In("songlist.txt");
    String n = list.readLine();
    size = Integer.parseInt(n);
    library = new Song[size + LIBRARY_BUFFER];
    for (int i = 0; i < size; i++) {
      String path = list.readLine();
      String bpms = list.readLine();
      int bpm = Integer.parseInt(bpms);
      Song song = new Song(path, bpm);
      library[i] = song;
    }
  }
  
  private void saveSongs() {
    Out list = new Out("songlist.txt");
    list.println(size);
    for (Song s : library) {
      list.println(s.path());
      list.println(s.bpm());
    }
  }
   
  private void sortLibrary() {
    Arrays.sort(library);
  }
  
  public void addSong(Song song) {
    if (size == library.length) {
      Song[] biggerLibrary = new Song[size + LIBRARY_BUFFER];
      for (int i = 0; i < size; i++) {
        biggerLibrary[i] = library[i];
      }
      library = biggerLibrary;
      biggerLibrary = null;
    }
    library[size] = song;
    size++;
  }
  
  public void addFolder(String folder) {
    // learn how to iterate through files in a folder
  }
  
  public static void main(String[] args) {
    SongList songlist = new SongList();
    songlist.saveSongs();
  }
}