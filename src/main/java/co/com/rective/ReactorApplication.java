package co.com.rective;

import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

  @Override
  public void run(String... args) {
    reactor();
    rxJava();
  }
}
