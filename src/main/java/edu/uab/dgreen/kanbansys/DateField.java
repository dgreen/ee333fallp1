/*
 * Author: David Green <DGreen@uab.edu>
 * Assignment:  kanbansys - EE333 Summer 2021
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.dgreen.kanbansys;

/** */
public class DateField extends Field {

  private KanbanDate kd;

  public DateField(String name, KanbanDate kd) {
    super(name, "date");
    this.kd = new KanbanDate(kd); // clone it
  }

  @Override
  public String toString() {
    return kd.toString();
  }

  @Override
  int valueCompareTo(Field f) {
    return kd.toString().compareTo(f.toString());
  }

  @Override
  public Field newField(Object newValue) {
    return new DateField(this.getName(), ((KanbanDate) newValue));
  }
}
