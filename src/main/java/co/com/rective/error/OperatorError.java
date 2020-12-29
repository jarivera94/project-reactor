package co.com.rective.error;

import co.com.rective.Person;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class OperatorError {

  public void retry(){

    List<Person> listPerson = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    Flux.fromIterable(listPerson)
        .concatWith(Flux.error(new RuntimeException("UNKNOWN ERROR ")))
        .retry(2)
        .doOnNext(person -> log.info("OperatorError::retry {}", person.toString()))
        .subscribe();
  }

  public void onErrorReturn(){
    List<Person> listPerson = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    Flux.fromIterable(listPerson)
        .concatWith(Flux.error(new RuntimeException("UNKNOWN ERROR ")))
        .onErrorReturn(new Person(0, "onErrorReturn",""))
        .doOnNext(person -> log.info("OperatorError::retry {}", person.toString()))
        .subscribe();
  }

  public void onErrorResume(){
    List<Person> listPerson = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    Flux.fromIterable(listPerson)
        .concatWith(Flux.error(new RuntimeException("UNKNOWN ERROR ")))
        .onErrorResume(e -> Mono.just(new Person(0, "onErrorResume","")))
        .doOnNext(person -> log.info("OperatorError::retry {}", person.toString()))
        .subscribe();
  }

  public void onErrorResumeMap(){
    List<Person> listPerson = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    Flux.fromIterable(listPerson)
        .concatWith(Flux.error(new RuntimeException("UNKNOWN ERROR ")))
        .onErrorMap(e -> new InterruptedException("Transformation"))
        .subscribe();
  }
}
