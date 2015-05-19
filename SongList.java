import java.util.Arrays;
import java.io.File;

public class SongList {
  private SET<Song> library = new SET();
  
  public SongList() {
    In list = new In("songlist.txt");
    while (!list.isEmpty()) {
      String path = list.readLine();
      String bpms = list.readLine();
      int bpm = Integer.parseInt(bpms);
      Song song = new Song(path, bpm);
      library.add(song);
    }
  }
  
  private void saveSongs() {
    Out list = new Out("songlist.txt");
    for (Song s : library) {
      list.println(s.path());
      list.println(s.bpm());
    }
  }
  
  public void addSong(Song song) {
    library.add(song);
  }
  
  public void addFolder(String folderName) {
    File folder = new File(folderName);
    addFolder(folder);
  }
  
  public void addFolder(File folder) {
    File[] files = folder.listFiles();
    for (File file : files) {
      if (file.isDirectory()) {
        addFolder(file);
      } else {
        Song song = new Song(file.getAbsolutePath());
        addSong(song);
      }
    }
  }
  
  public static void main(String[] args) {
    SongList songlist = new SongList();
    songlist.addFolder("/Users/anne/Music/iTunes/iTunes Music/Young Dubliners/Nine");
    songlist.saveSongs();
    }
}