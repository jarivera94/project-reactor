package co.com.rective.creation;

import co.com.rective.Person;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class Creation {

  public void just() {
    Mono.just("data");
    Observable.just("data");
    List<String> list = new ArrayList<>();
    list.add("data1");
    list.add("data2");
    Flux.fromIterable(list);
  }

  public void empty() {
    Mono.empty();
    Observable.empty();
    Flux.empty();
  }

  public void range() {
    Flux.range(0, 3)
        .subscribe(item -> log.info("Creation::range {}", item));
  }

  public void repeat() {

    List<Person> listPerson = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    Flux<Person> flux = Flux.fromIterable(listPerson);
    flux.repeat(3)
        .subscribe(person -> log.info("Creation::repeat {}", person.toString()));


    Mono.just(new Person(1, "reactor", "mono"))
        .repeat(3)
        .subscribe(person -> log.info("Creation::repeat {}", person.toString()));
  }
}
