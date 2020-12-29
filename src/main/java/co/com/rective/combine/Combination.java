package co.com.rective.combine;

import co.com.rective.Person;
import co.com.rective.Sale;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class Combination {

  public void merge(){
    List<Person> listPerson = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    List<Person> listPerson2 = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    List<Sale> listSales = new ArrayList<>();
    listSales.add(new Sale("c2", new Timestamp(new Date().getTime())));
    listSales.add(new Sale("c3", new Timestamp(new Date().getTime())));
    listSales.add(new Sale("c4", new Timestamp(new Date().getTime())));
    listSales.add(new Sale("52", new Timestamp(new Date().getTime())));
    Flux flux1 =Flux.fromIterable(listPerson);
    Flux flux2 = Flux.fromIterable(listPerson2);
    Flux flux3 = Flux.fromIterable(listSales);


    Flux.merge(flux1, flux2,  flux3)
        .subscribe(object -> log.info("Combination::merge {}", object.toString()));
  }


  public void zip(){
    List<Person> listPerson = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    List<Person> listPerson2 = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    List<Sale> listSales = new ArrayList<>();
    listSales.add(new Sale("c2", new Timestamp(new Date().getTime())));
    listSales.add(new Sale("c3", new Timestamp(new Date().getTime())));
    listSales.add(new Sale("c4", new Timestamp(new Date().getTime())));
    listSales.add(new Sale("52", new Timestamp(new Date().getTime())));
    Flux flux1 =Flux.fromIterable(listPerson);
    Flux flux2 = Flux.fromIterable(listPerson2);
    Flux flux3 = Flux.fromIterable(listSales);


    Flux.zip(flux1, flux2,  flux3)
        .subscribe(object -> log.info("Combination::zip {}", object.toString()));
  }


  public void zipWith(){
    List<Person> listPerson = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    List<Person> listPerson2 = new ArrayList<>();
    listPerson.add(new Person(1, "project1", "reactor1"));
    listPerson.add(new Person(2, "project2", "reactor2"));
    listPerson.add(new Person(3, "project3", "reactor3"));

    List<Sale> listSales = new ArrayList<>();
    listSales.add(new Sale("c2", new Timestamp(new Date().getTime())));
    listSales.add(new Sale("c3", new Timestamp(new Date().getTime())));
    listSales.add(new Sale("c4", new Timestamp(new Date().getTime())));
    listSales.add(new Sale("52", new Timestamp(new Date().getTime())));
    Flux flux1 =Flux.fromIterable(listPerson);
    Flux flux2 = Flux.fromIterable(listPerson2);
    Flux flux3 = Flux.fromIterable(listSales);


    flux1.zipWith(flux1, (p1,p2) -> String.format("Flux 1 %s, flux 2 %s", p1, p2))
        .subscribe(object -> log.info("Combination::zipWith {}", object.toString()));
  }
}
