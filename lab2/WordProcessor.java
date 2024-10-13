import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordProcessor {

  private String content;
  private String[] words;

  public WordProcessor(String content) {
    this.content = content;
  }

  public String[] getWords() {
    if ( words != null ) {
      return words;
    }
    words = content.split(" +");
    return words;
  }

  public void sortWords() {
    getWords();
    Arrays.sort(words);
  }

  private List<String> getDistinctWords() {
    String distinctString = " ";
    String[] words = getWords();
    for (int i = 0; i < words.length; i++) {
      if (!distinctString.contains(words[i])) {
        distinctString += words[i] + " ";
      }
    }
    return new ArrayList<>(Arrays.asList( distinctString.split(" ") ) );
  }

  public List<WordFrequency> getWordFrequencies() {
    List<String> distinctWords = getDistinctWords();
    List<WordFrequency> wordFrequencies = distinctWords.stream().map( word -> new WordFrequency(word) ).toList();
    return wordFrequencies.stream().map( this::countDistinctWord ).toList();
  }

  private WordFrequency countDistinctWord(WordFrequency wordFrequency) {
    for (int i = 0; i < words.length; i++) {
      wordFrequency.incrementFrequency( words[i] );
    }
    return wordFrequency;
  }
}
