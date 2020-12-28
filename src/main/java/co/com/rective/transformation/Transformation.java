package co.com.rective.transformation;

import co.com.rective.Person;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class Transformation {


  public void map() {
    List<Person> listPerson = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    Flux<Person> flux = Flux.fromIterable(listPerson);

    flux.map(person -> {
      person.setId(person.getId() + 10);
      person.setLastName(person.getLastName() + " modified from map");
      return person;
    }).subscribe(person -> log.info("Transformation::map {}", person.toString()));
  }

  public void flatMap() {
    List<Person> listPerson = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    Flux<Person> flux = Flux.fromIterable(listPerson);

    flux.flatMap(person -> {
      person.setId(person.getId() + 10);
      person.setLastName(person.getLastName() + " modified from flatMap");
      return Mono.just(person);
    }).subscribe(person -> log.info("Transformation::flatMap {}", person.toString()));
  }


  public void groupBy() {
    List<Person> listPerson = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(1, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    Flux<Person> flux = Flux.fromIterable(listPerson);

    flux.groupBy(Person::getId).
        flatMap(idFlux -> idFlux.collectList())

    .subscribe(people -> log.info("Transformation::groupBy {}", people.toString()));
  }
}
