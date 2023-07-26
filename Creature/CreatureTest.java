import java.util.*;

interface Reproduction {
  String modeOfReproduction();
}

abstract class Creature {
  abstract String eatFood();
}

class Plant extends Creature implements Reproduction {
  private String name;

  public Plant(String name) {
    this.name = name;
  }

  public String eatFood() {
    return "sunlight (aka photosynthesis)";
  }

  public String modeOfReproduction() {
    return "Seeds";
  }

  public String toString() {
    return "Plant " + name + " reproduce using " + modeOfReproduction() + " and consume food as " + eatFood();
  }
}

class Animal extends Creature implements Reproduction {
  private String name;

  public Animal(String name) {
    this.name = name;
  }

  public String eatFood() {
    return "ingestion";
  }

  public String modeOfReproduction() {
    return "Sexual Reproduction";
  }

  public String toString() {
    return "Animal " + name + " reproduce by " + modeOfReproduction() + " and consume food by "
        + eatFood();
  }
}

class Fungi extends Creature implements Reproduction {
  private String name;

  public Fungi(String name) {
    this.name = name;
  }

  public String eatFood() {
    return "external digestion with hyphae";
  }

  public String modeOfReproduction() {
    return "Spores";
  }

  public String toString() {
    return "Fungi " + name + " reproduce using " + modeOfReproduction() + " and consume food by " + eatFood();
  }
}

public class CreatureTest {

  public static void main(String[] args) {
    Set<Plant> plants = new HashSet<Plant>();
    plants.add(new Plant("Amaryllis"));
    plants.add(new Plant("Calla Lily"));

    Set<Animal> animals = new HashSet<Animal>();
    animals.add(new Animal("Tiger"));
    animals.add(new Animal("Lion"));

    Set<Fungi> fungi = new HashSet<Fungi>();
    fungi.add(new Fungi("Agaricus bernardii"));
    fungi.add(new Fungi("Bisporella citrina"));

    System.out.println("Plants details:");
    for(Plant P:plants)
    System.out.println(P);
    System.out.println();
    System.out.println("Animals details:");
    for(Animal A:animals)
    System.out.println(A);
    System.out.println();
    System.out.println("Fungi details:");
    for(Fungi F:fungi)
    System.out.println(F);
  }
}