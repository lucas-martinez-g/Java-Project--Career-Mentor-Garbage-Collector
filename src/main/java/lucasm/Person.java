package lucasm;

import java.time.LocalDate;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Person implements AutoCloseable {

  public static Long id;
  private String name;
  private LocalDate birthdate;

  Person(String name, LocalDate birthdate) {
    id++;
    this.name = name;
    this.birthdate = birthdate;
  }

  @Override
  public void close() throws Exception {
    --id;
  }
}
