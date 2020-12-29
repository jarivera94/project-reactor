package co.com.rective;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Sale {

  private String code;
  private Timestamp timestamp;
}
