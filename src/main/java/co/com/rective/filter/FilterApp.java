package co.com.rective.filter;

import co.com.rective.Person;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FilterApp {


  public void filter(){
    List<Person> listPerson = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    Flux<Person> flux = Flux.fromIterable(listPerson);
    flux.filter( person -> person.getId() == 1)
        .subscribe(person -> log.info("Filter::filter {}", person.toString()));
  }

  public void take(){
    List<Person> listPerson = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    Flux<Person> flux = Flux.fromIterable(listPerson);
    flux.take(2)
        .subscribe(person -> log.info("Filter::take {}", person.toString()));
  }

  public void takeLast(){
    List<Person> listPerson = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    Flux<Person> flux = Flux.fromIterable(listPerson);
    flux.takeLast(2)
        .subscribe(person -> log.info("Filter::takeLast {}", person.toString()));
  }


  public void skip(){
    List<Person> listPerson = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    Flux<Person> flux = Flux.fromIterable(listPerson);
    flux.skip(1)
        .subscribe(person -> log.info("Filter::skip {}", person.toString()));
  }

  public void skipLast(){
    List<Person> listPerson = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    Flux<Person> flux = Flux.fromIterable(listPerson);
    flux.skip(1)
        .subscribe(person -> log.info("Filter::skipLast {}", person.toString()));
  }
}
