package co.com.rective;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Person {

  private int id;
  private String name;
  private String lastName;
}
