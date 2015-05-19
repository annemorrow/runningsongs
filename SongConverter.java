import javazoom.jl.converter.Converter;

public class SongConverter {



  public static void makeWAV(String s) {
    try {
    Converter converter = new Converter();
    converter.convert(s, s.substring(0, s.length() - 4) + ".wav");
    }
    catch (Exception error) {
      StdOut.println("That didn't work");
    }
  }
  
  public static void main(String[] args) {
    makeWAV("/Users/anne/Documents/programming/runningsongs/01 Hero of Canton.mp3");
  }
}