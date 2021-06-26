/*
 * Author: David Green <DGreen@uab.edu>
 * Assignment:  ee333fallp1 - EE333 Fall 2021
 *
 * Credits:  (if any for sections of code)
 */
package uab.edu.dgreen.kanbansys;

/**
 * Test P1 Driver
 */
public class TestP1 {

  /** @param args the command line arguments */
  public static void main(String[] args) {

		System.out.println(    // TODO: change name
				"""
				Test Program for P1 by David Green
        EE333 Fall 2021
    """
		);

    // Happy path

		System.out.println(
				"""
				*** Test Happy Path ***
				"""
		);

		var kc = new KanbanCard("Task with a description");
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

		System.out.println(
		"""

    *** Test for failure to silently fail invalid change requests ***
    """);

		kc = new KanbanCard("another card");

		for (var ksStart : KCardState.values()) {
			kc.move(ksStart, null);
			for (var ksCheck : KCardState.values()) {
				if (! nextOrAbandon(ksStart, ksCheck)) {
					changeTo(kc, ksCheck);
				}
			}
		}
		p("There should be no notes on this item", kc);

		// ability to abandon
	  // for each state except DONE see if you can abandon
	  //    final state should be abandoned

		System.out.println(
		"""

    *** Test for failure to abandon task ***
    """);
		kc = new KanbanCard("yet another card");
		for (var ksStart : KCardState.values()) {
			if (ksStart == KCardState.DONE)
				continue;
			kc.abandon(null);
			if (! kc.isAbandoned()) {
				System.out.println("Failed to abandon from state: " + ksStart);
			}
		}
  }

	// return true if change is the normal next state from state now or if abandoning
	private static boolean nextOrAbandon(KCardState now, KCardState change) {
		if (change == KCardState.ABANDONED) return true;

		boolean result = switch (now) {
			case BACKLOG -> change == KCardState.DESIGN;
			case DESIGN -> change == KCardState.BUILD;
			case BUILD -> change == KCardState.TEST;
			case TEST -> change == KCardState.RELEASE;
			case RELEASE -> change == KCardState.DONE;
			default -> false;
		};
		return result;
	}

	private static void changeTo(KanbanCard kc, KCardState newState) {

		// No method to check to move to backlog
		if (newState == KCardState.BACKLOG) return;

		switch(newState) {
			case DESIGN -> kc.start("started");
			case BUILD -> kc.build("building");
			case TEST -> kc.test("testing");
			case RELEASE -> kc.release("releasing");
			case DONE -> kc.complete("completed");
			default -> {}
		}
	}

  private static void p(String info, KanbanCard kcp) {
		System.out.println("");
    System.out.println("vvv " + info + " vvv");
    System.out.println(kcp);
    System.out.println(
				">>>Is done? " + kcp.isDone() +
				", Is active? " + kcp.isActive() +
				", Is abandoned? " + kcp.isAbandoned()
				);
  }
}
