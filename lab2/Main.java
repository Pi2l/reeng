import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class Main {

  public static void main(String[] args) throws IOException {
    Timer timer = new Timer();

    String content = getCleanContent("lab2/harrry-potter/src/edu/pro/txt/harry.txt");
    WordProcessor wordProcessor = new WordProcessor(content);
    wordProcessor.sortWords();
    List<WordFrequency> wordFrequencies = wordProcessor.getWordFrequencies();
    List<WordFrequency> sortedWordFrequencies = sortWordFrequencies(wordFrequencies);
    
    printTopWords(sortedWordFrequencies, 30);
    
    timer.stop();
    System.out.println("------");
    System.out.println( timer.getElapsedTime() );

  }

  private static void printTopWords(List<WordFrequency> sortedWordFrequencies, int count) {
    for (int i = 0; i < count; i++) {
      WordFrequency wordFrequency = sortedWordFrequencies.get(i);
      System.out.println( wordFrequency.getWord() + ": " + wordFrequency.getFrequency() );
    }
  }

  private static String getCleanContent( String url ) throws IOException {
    String content = new String(Files.readAllBytes( Paths.get( url ) ));
    return content.replaceAll("[^A-Za-z ]", " ").toLowerCase(Locale.ROOT);
  }

  private static List<WordFrequency> sortWordFrequencies(List<WordFrequency> wordFrequencies) {
    return wordFrequencies.stream()
                          .sorted(Comparator.comparing(WordFrequency::getFrequency).reversed())
                          .toList();
  }

  
}
