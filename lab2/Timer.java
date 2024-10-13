import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Timer {

  private LocalDateTime start = LocalDateTime.now();
  private LocalDateTime end = LocalDateTime.now();
  
  public void start() {
    start = LocalDateTime.now();
  }

  public void stop() {
    end = LocalDateTime.now();
  }
  
  public long getElapsedTime() {
    return ChronoUnit.MILLIS.between(start, end);
  }
}
