/*
 * Author: David Green <DGreen@uab.edu>
 * Assignment:  kanbansys - EE333
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.dgreen.kanbansys;

/** */
public class TestLambda {

  /** @param args the command line arguments */
  public static void main(String[] args) {
    var kc1 = new KanbanCard("Test card");

    System.out.println(KanbanCard.matches(kc1, k -> k.getName().equals("Test card")));
    System.out.println(KanbanCard.matches(kc1, k -> k.getState().equals("BACKLOG")));
    System.out.println(KanbanCard.matches(kc1, k -> Integer.parseInt(k.getUid()) < 1000000000));
    System.out.println(KanbanCard.matches(kc1, k -> k.getNotes().equals("")));
  }
}
