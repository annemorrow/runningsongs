import java.io.File;
import java.util.regex.Pattern;

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
  
  public void clearSongs() {
    library = new SET();
  }
  
  public void saveSongs() {
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
        // will need to check that file is a proper type, once I decide what types I'm supporting
        if (Pattern.matches(".*\\.mp3", file.getAbsolutePath())) {
          Song song = new Song(file.getAbsolutePath());
          addSong(song);
        }
      }
    }
  }
  
  public static void main(String[] args) {
    SongList songlist = new SongList();
    songlist.clearSongs();
    songlist.addFolder("/Users/anne/Music");
    songlist.saveSongs();
  }
}