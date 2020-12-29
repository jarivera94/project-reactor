package co.com.rective.conditional;

import co.com.rective.Person;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class Conditional {

  public void defaultEmpty() {
    Mono.empty()
        .defaultIfEmpty(new Person(0, "empty", "empty"))
        .subscribe(result -> log.info("Conditional::defaultEmpty {}", result.toString()));
  }

  public void takeUntil() {
    List<Person> listPerson = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    Flux.fromIterable(listPerson)
        .takeUntil(person -> person.getId() < 2)
        .subscribe(result -> log.info("Conditional::takeUntil {}", result.toString()));
  }
}
