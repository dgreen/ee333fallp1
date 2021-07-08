/*
 * Author: David Green <DGreen@uab.edu>
 * Assignment:  ee333fallp1 - EE333 Fall 2021
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.dgreen.kanbansys;

/** Test P1 Driver */
public class TestP1 {

  private static int date = 20210801; // Note: it will be changed on every print

  /**
   * Program to test the KanbanCard implementation
   *
   * @param args the command line arguments (unused)
   */
  public static void main(String[] args) {

    Calendar.setDate("" + date);

    System.out.println("Test Program for P1 by David Green"); // TODO: change name
    System.out.println("EE333 Fall 2021");
    System.out.println("");

    // Happy path

    System.out.println("*** Test Happy Path ***");
    System.out.println("");

    KanbanCard kc = new KanbanCard("Task with a description");
    p("new card:", kc);
    kc.start("Start working on this task");
    p("in design", kc);
    kc.build("start implementing this task");
    p("in build", kc);
    kc.test("start testing task");
    p("in testing", kc);
    kc.release("ready to release to production");
    p("in release phase", kc);
    kc.complete("task finished");
    p("task completed", kc);
    kc.abandon("should not abandon since complete");
    p("attempted abandon should have failed", kc);

    // silently failing state changes
    // for each starting state
    //   try changing to all states but 1) next, abandoned

    System.out.println("");
    System.out.println("*** Test for failure to silently fail invalid change requests ***");
    System.out.println("");

    kc = new KanbanCard("another card");

    for (var ksStart : KCardState.values()) {
      kc.move(ksStart, null);
      for (var ksCheck : KCardState.values()) {
        if (!nextOrAbandon(ksStart, ksCheck)) {
          changeTo(kc, ksCheck);
        }
      }
    }
    p("There should be no notes on this item", kc);

    // ability to abandon
    // for each state except DONE see if you can abandon
    //    final state should be abandoned

    System.out.println("");
    System.out.println("*** Test for failure to abandon task ***");
    System.out.println("");

    kc = new KanbanCard("yet another card");
    for (var ksStart : KCardState.values()) {
      if (ksStart == KCardState.DONE) continue;
      System.out.println(".Trying to abandon " + ksStart);
      kc.move(ksStart, null);
      kc.abandon(null);
      if (!kc.isAbandoned()) {
        System.out.println("...Failed to abandon from state: " + ksStart);
      } else {
        System.out.println("...Success");
      }
    }
    System.out.println("Test Complete.");
  }

  // Returns true if change is the normal next state from state now or if abandoning
  private static boolean nextOrAbandon(KCardState now, KCardState change) {
    if (change == KCardState.ABANDONED) return true;

    boolean result;
    switch (now) {
      case BACKLOG:
        result = change == KCardState.DESIGN;
        break;
      case DESIGN:
        result = change == KCardState.BUILD;
        break;
      case BUILD:
        result = change == KCardState.TEST;
        break;
      case TEST:
        result = change == KCardState.RELEASE;
        break;
      case RELEASE:
        result = change == KCardState.DONE;
        break;
      default:
        result = false;
        break;
    }
    ;
    return result;
  }

  // Uses a non-Move method to change the state if one exists
  private static void changeTo(KanbanCard kc, KCardState newState) {

    // No method to check to move to backlog
    if (newState == KCardState.BACKLOG) return;

    switch (newState) {
      case DESIGN:
        kc.start("started");
        break;
      case BUILD:
        kc.build("building");
        break;
      case TEST:
        kc.test("testing");
        break;
      case RELEASE:
        kc.release("releasing");
        break;
      case DONE:
        kc.complete("completed");
        break;
      default:
        break;
    }
  }

  // Prints supplied info and KanbanCard details
  private static void p(String info, KanbanCard kcp) {
    System.out.println("");
    System.out.println("vvv " + info + " vvv");
    System.out.println(kcp);
    System.out.println(
        ">>>Is done? "
            + kcp.isDone()
            + ", Is active? "
            + kcp.isActive()
            + ", Is abandoned? "
            + kcp.isAbandoned());
    Calendar.setDate("" + (++date)); // Note: fails if over 29 prints
  }
}
