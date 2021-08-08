/*
 * Author: David Green <DGreen@uab.edu>
 * Assignment:  kanbansys - EE333
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.dgreen.kanbansys;

import java.util.ArrayList;

/** */
public class TestStream {

  /** @param args the command line arguments */
  public static void main(String[] args) {
    ArrayList<KanbanCard> ks = new ArrayList<>();

    ks.add(new KanbanCard("9"));
    ks.add(new KanbanCard("8"));
    ks.add(new KanbanCard("7"));
    ks.add(new KanbanCard("6"));
    ks.add(new KanbanCard("5"));
    ks.add(new KanbanCard("4"));
    ks.add(new KanbanCard("3"));
    ks.add(new KanbanCard("2"));
    ks.add(new KanbanCard("1"));
    ks.add(new KanbanCard("0"));

    for (var k : ks) {
      System.out.println(k);
    }

    System.out.println(
        "min: " + ks.stream().min((a, b) -> a.getName().compareTo(b.getName())).get().getName());
    System.out.println(
        "max: " + ks.stream().max((a, b) -> a.getName().compareTo(b.getName())).get().getName());

    ks.get(0).start("starting 9");
    ks.get(1).start("starting 8");
    ks.get(1).build("building 8");

    System.out.println(ks.stream().filter(k -> k.getState().equals("DESIGN")).count());
    System.out.println(ks.stream().filter(k -> k.getState().equals("BACKLOG")).count());

    ks.stream()
        .filter(k -> k.getState().equals("BACKLOG"))
        .map(
            k -> {
              k.start("in map");
              return k;
            })
        .forEach(k -> System.out.println(k));

    ks.stream()
        .sorted((a, b) -> a.getName().compareTo(b.getName()))
        .forEach(k -> System.out.println(k.getName() + "@" + k.getState()));
  }
}
