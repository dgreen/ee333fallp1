/*
 * Author: David Green <DGreen@uab.edu>
 * Assignment:  kanbansys - EE333 Fall 2021
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.dgreen.kanbansys;

import java.util.ArrayList;

/** Demo the Kanban Board */
public class TestP3 {

  /**
   * Program starts here
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    // make a board
    KanbanBoard board = new KanbanBoard();

    Calendar.setDate("" + "20210901");

    // make, move to desired state, and add cards
    KanbanCard c1 = new KanbanCard("c1");
    board.add(c1);
    KanbanCard c2 = new KanbanCard("c2");
    board.add(c2);
    KanbanCard c3 = new KanbanCard("c3");
    c3.start(null);
    board.add(c3);
    KanbanCard c4 = new KanbanCard("c4");
    c4.start(null);
    board.add(c4);
    KanbanCard c5 = new KanbanCard("c5");
    c5.start(null);
    c5.build(null);
    board.add(c5);
    KanbanCard c6 = new KanbanCard("c6");
    c6.start(null);
    c6.build(null);
    c6.test(null);
    board.add(c6);
    KanbanCard c7 = new KanbanCard("c7");
    c7.start(null);
    c7.build(null);
    c7.test(null);
    c7.release(null);
    board.add(c7);
    KanbanCard c8 = new KanbanCard("c8");
    c8.abandon(null);
    board.add(c8);
    KanbanCard c9 = new KanbanCard("c9");
    c9.abandon(null);
    board.add(c9);

    // get the various columns

    String[] theStates = {"BACKLOG", "DESIGN", "BUILD", "TEST", "RELEASE", "DONE", "ABANDONED"};
    ArrayList<KanbanCard> column;

    for (String state : theStates) {
      System.out.println("Cards with state: " + state);
      column = board.getAllWithState(state);
      for (KanbanCard c : column) {
        System.out.println(c);
      }
    }
  }
}
