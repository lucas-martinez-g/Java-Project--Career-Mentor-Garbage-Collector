package lucasm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

  static final String kb = " KB = ";
  static final String mb = " MB";
  static final long PERSONS_SIZE = 10000000L;

  public static void main(String[] args) throws Exception {

    Person.id = 0L;
    Random random = new Random();
    List<Person> persons = new ArrayList<>();

    System.out.println("-----------------------------------");
    printMemoryUse("Before create objects");

    for (int i = 0; i < PERSONS_SIZE; i++) {
      persons.add(new Person("John" + i,
          LocalDate.of(1980 + random.nextInt(20), 1 + random.nextInt(11),
              1 + random.nextInt(27))));
    }

    printMemoryUse("After create objects");

    for (Person person : persons) {
      person.close();
    }
    persons.clear();
    System.gc();

    printMemoryUse("After call gc");
  }

  private static void printMemoryUse(String msg) {
    Runtime runtime = Runtime.getRuntime();
    long usedMemory = runtime.totalMemory() - runtime.freeMemory();
    long totalMemory = runtime.totalMemory();
    long freeMemory = runtime.freeMemory();

    System.out.println(msg);
    System.out.println("Objects alive: " + Person.id);
    System.out.println(
        "Total memory: " + totalMemory / 1024 + kb + totalMemory / 1048576 + mb);
    System.out.println(
        "Used memory: " + usedMemory / 1024 + kb + usedMemory / 1048576 + mb);
    System.out.println(
        "Free memory: " + freeMemory / 1024 + kb + freeMemory / 1048576 + mb);
    System.out.println("-----------------------------------");
  }

}