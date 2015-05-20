import java.io.File;

public class SongList {
  private SET<Song> library = new SET();
  
  
  /**
  * Creates a SongList, loading previously saved Songs.
  */
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
  
  /**
  * Removes all saved Songs from list.
  */
  public void clearSongs() {
    library = new SET();
  }
  
  /**
  * Saves all Songs, including previously saved Songs and new additions.
  */
  public void saveSongs() {
    Out list = new Out("songlist.txt");
    for (Song s : library) {
      list.println(s.path());
      list.println(s.bpm());
    }
  }
  
  /**
  * Adds an individual Song to the list.
  */
  public void addSong(Song song) {
    library.add(song);
  }
  
  /**
  * Adds all mp3 songs in the folder or in any subfolder.
  */
  public void addFolder(String folderName) {
    File folder = new File(folderName);
    addFolder(folder);
  }
  
  private void addFolder(File folder) {
    File[] files = folder.listFiles();
    for (File file : files) {
      if (file.isDirectory()) {
        addFolder(file);
      } else {
        // will need to check that file is a proper type, once I decide what types I'm supporting
        if (file.getAbsolutePath().endsWith(".mp3")) {
          Song song = new Song(file.getAbsolutePath());
          addSong(song);
        }
      }
    }
  }
  
  public static void main(String[] args) {
    SongList songlist = new SongList();
    songlist.clearSongs();
    songlist.addFolder("/Users/anne/Music/wedding dance music");
    songlist.saveSongs();
  }
}