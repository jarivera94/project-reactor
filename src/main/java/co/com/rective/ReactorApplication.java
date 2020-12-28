package co.com.rective;

import co.com.rective.creation.Creation;
import co.com.rective.transformation.Transformation;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@SpringBootApplication
public class ReactorApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(ReactorApplication.class, args);
  }

  public void reactor() {
    Mono.just(new Person(1, "project", "reactor"))
        .doOnNext(person -> log.info("ReactorApplication::reactor doOnNext {}", person.toString()))
        .subscribe(person -> log.info("ReactorApplication::reactor {}", person.toString()));
  }

  public void rxJava() {
    Observable.just(new Person(1, "project", "reactor"))
        .doOnNext(person -> log.info("ReactorApplication::rxJava doOnNext {}", person.toString()))
        .subscribe(person -> log.info("ReactorApplication::rxJava {}", person.toString()));
  }

  public void mono() {
    Mono.just(new Person(1, "reactor", "mono"))
        .subscribe(person -> log.info("ReactorApplication::mono {}", person.toString()));
  }

  public void flux() {
    List<Person> listPerson = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    Flux.fromIterable(listPerson)
        .subscribe(person -> log.info("ReactorApplication::flux {}", person.toString()));
  }

  public void fluxToMono() {
    List<Person> listPerson = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    Flux<Person> flux = Flux.fromIterable(listPerson);
    flux.collectList()
        .subscribe(people -> log.info("ReactorApplication::fluxToMono list {}", people.toString()));
  }

  @Override
  public void run(String... args) {
    //reactor();
    //rxJava();
    //mono();
    //flux();
    //fluxToMono();

    Creation creation = new Creation();
    creation.range();
    creation.repeat();

    Transformation transformation = new Transformation();
    transformation.map();
    transformation.flatMap();
    transformation.groupBy();
  }
}
