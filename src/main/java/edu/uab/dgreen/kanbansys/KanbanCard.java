/*
 * Author: David Green <DGreen@uab.edu>  // replace
 * Assignment:  ee333fallp1 - EE333 Fall 2021
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.dgreen.kanbansys;

/** Model a Kanban Card */
public class KanbanCard {

  // Private State of Card
  private String name; // name of the card
  private final String createDate; // date card was created
  private String beginDate; // first time in system beyond BACKLOG
  private String endDate; // date card (null if not in done, abandoned)
  //                         otherwise most recently done or abandoned

  private String notes; // possibly multi-line string of notes reflecting changes to card
  private String state; // present card state
  private final String uid; // unique ID of kanban card
  private static long count = 1000000000; // start with 10 digits

  /**
   * Create a Kanban card with a unique uid, and Initialize other fields appropriately
   *
   * @param name the name of the card
   */
  public KanbanCard(String name) {
    this.name = name;
    uid = "" + ++count;
    createDate = Calendar.getDate();
    beginDate = "TBD";
    endDate = "TBD";
    notes = "";
    state = "BACKLOG";
  }

  /**
   * get the UID of the card
   *
   * @return long number corresponding to uid of card
   */
  public String getUid() {
    return uid;
  }

  /**
   * get the name of the task
   *
   * @return String representing name of task
   */
  public String getName() {
    return name;
  }

  /**
   * Is this task done?
   *
   * @return true if task has been completed
   */
  public boolean isDone() {
    return state.equals("DONE");
  }

  /**
   * Is this task active?
   *
   * @return true if not in backlog, not done or not abandoned
   */
  public boolean isActive() {
    return state.equals("DESIGN")
        || state.equals("BUILD")
        || state.equals("TEST")
        || state.equals("RELEASE");
  }

  /**
   * Is this task abandoned?
   *
   * @return true if task has been abandoned
   */
  public boolean isAbandoned() {
    return state.equals("ABANDONED");
  }

  /**
   * Create a string representation of the Kanban card
   *
   * <p>Format:
   *
   * <p><code>
   * uid: Name of task Task State
   * state - Create: date (or tbd) Begin: date (or tbd) Completed: date (or TBD)
   * (notes would go here if any)
   * </code>
   *
   * <p>Example:
   *
   * <p><code>
   * 100000000: Demo task Backlog
   * BACKLOG - Create: 20210815 Begin: TBD Completed: TBD
   * </code>
   *
   * @return formatted string
   */
  @Override
  public String toString() {
    return ""
        + uid
        + ": "
        + name
        + System.lineSeparator()
        + state
        + " - Create: "
        + createDate
        + " Begin: "
        + beginDate
        + " Completed: "
        + endDate
        + (notes.equals("") ? "" : ((System.lineSeparator() + notes)));
  }

  /** @param newName the new task name */
  public void updateName(String newName) {
    name = newName;
  }

  /**
   * Mark the task as in design if it is in the backlog (no action otherwise) and capture note if
   * non-null
   *
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void start(String note) {
    nextStateIfValid("BACKLOG", "DESIGN", note);
    if (beginDate.equals("TBD")) {
      beginDate = Calendar.getDate();
    }
  }

  /**
   * Mark and timestamp (if beginDate null) the task as in build if it was in design (no action
   * otherwise) and capture note if non-null
   *
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void build(String note) {
    nextStateIfValid("DESIGN", "BUILD", note);
  }

  /**
   * Mark the task as in test if it was in build (no action otherwise) and capture note
   *
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void test(String note) {
    nextStateIfValid("BUILD", "TEST", note);
  }

  /**
   * Mark the task as ready to release if it was in test (no action otherwise) and capture note
   *
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void release(String note) {
    nextStateIfValid("TEST", "RELEASE", note);
  }

  /**
   * Mark and timestamp the task as complete if it was in release (no action otherwise) and capture
   * note
   *
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void complete(String note) {
    nextStateIfValid("RELEASE", "DONE", note);
    if (state.equals("DONE")) {
      endDate = Calendar.getDate();
    }
  }

  /**
   * Mark the task as abandoned unless it was completed (no action otherwise) and capture note
   *
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void abandon(String note) {
    if (!state.equals("DONE") && !state.equals("ABANDONED")) {
      state = "ABANDONED";
      append(note);
      if (endDate.equals("TBD")) {
        endDate = Calendar.getDate();
      }
    }
  }

  /**
   * Modify the state of the task and capture the note, update the date fields based on present new
   * state
   *
   * @param state the new String for the task
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void move(String state, String note) {
    this.state = state;
    append(note);
    if (!state.equals("BACKLOG") && beginDate.equals("TBD")) {
      beginDate = Calendar.getDate();
    }
    if (state.equals("ABANDONED") || state.equals("DONE")) {
      endDate = Calendar.getDate();
    } else {
      endDate = "TBD";
    }
  }

  // Helper method:
  // if present state meets requirement of being before state,
  //    then change to after state and update note
  private void nextStateIfValid(String before, String after, String note) {
    if (state.equals(before)) {
      state = after;
      append(note);
    }
  }

  // Append note to notes after a line separator if there is a note.
  private void append(String note) {
    if (!note.equals("")) {
      if ((notes == null) || notes.equals("")) {
        notes = note;
      } else {
        notes += System.lineSeparator() + note;
      }
    }
  }
}
