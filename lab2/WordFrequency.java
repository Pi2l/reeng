public class WordFrequency {
  
  private String word;
  private int frequency;

  public WordFrequency(String word) {
    this.word = word;
    this.frequency = 0;
  }

  public void incrementFrequency( String otherWord ) {
    if ( word.equals(otherWord) ) {
      this.frequency++;
    }
  }

  public String getWord() {
    return word;
  }
  
  public int getFrequency() {
    return frequency;
  }

}
