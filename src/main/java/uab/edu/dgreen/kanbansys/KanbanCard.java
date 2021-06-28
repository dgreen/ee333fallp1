/*
 * Author: David Green <DGreen@uab.edu>  // replace
 * Assignment:  ee333fallp1 - EE333 Fall 2021
 *
 * Credits:  (if any for sections of code)
 */
package uab.edu.dgreen.kanbansys;

/** Model a Kanban Card */
public class KanbanCard {

  /**
   * Create a Kanban card with a unique uid, and Initialize other fields appropriately
   *
   * @param name the name of the card
   */
  public KanbanCard(String name) {}

  /**
   * get the UID of the card
   *
   * @return long number corresponding to uid of card
   */
  public long getUID() {
    return 0;
  }

  /**
   * get the name of the task
   *
   * @return String representing name of task
   */
  public String getName() {
    return "";
  }

  /**
   * Is this task done?
   *
   * @return true if task has been completed
   */
  public boolean isDone() {
    return false;
  }

  /**
   * Is this task active?
   *
   * @return true if not in backlog, not done or not abandoned
   */
  public boolean isActive() {
    return false;
  }

  /**
   * Is this task abandoned?
   *
   * @return true if task has been abandoned
   */
  public boolean isAbandoned() {
    return false;
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
    return "";
  }

  /** @param newName the new task name */
  public void updateName(String newName) {}

  /**
   * Mark the task as in design if it is in the backlog (no action otherwise) and capture note if
   * non-null
   *
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void start(String note) {}

  /**
   * Mark and timestamp (if beginDate null) the task as in build if it was in design (no action
   * otherwise) and capture note if non-null
   *
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void build(String note) {}

  /**
   * Mark the task as in test if it was in build (no action otherwise) and capture note
   *
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void test(String note) {}

  /**
   * Mark the task as ready to release if it was in test (no action otherwise) and capture note
   *
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void release(String note) {}

  /**
   * Mark and timestamp the task as complete if it was in release (no action otherwise) and capture
   * note
   *
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void complete(String note) {}

  /**
   * Mark the task as abandoned unless it was completed (no action otherwise) and capture note
   *
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void abandon(String note) {}

  /**
   * Modify the state of the task and capture the note, update the date fields based on present new
   * state
   *
   * @param state the new KCardState for the task
   * @param note a String note or null, if non-null, a newline will be prepended to the added note
   */
  public void move(KCardState state, String note) {}
}
