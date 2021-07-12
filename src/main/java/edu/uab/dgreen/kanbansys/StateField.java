/*
 * Author: David Green <DGreen@uab.edu>
 * Assignment:  kanbansys - EE333 Summer 2021
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.dgreen.kanbansys;

/** */
public class StateField extends Field {

  String state;
  String[] states;

  public StateField(String name, String[] values, String value) {
    super(name, "state");
    states = values;
    state = value;
  }

  @Override
  public String toString() {
    return state;
  }

  @Override
  int valueCompareTo(Field f) {
    return orderOf(state) - orderOf(f.toString());
  }

  @Override
  public Field newField(Object newValue) {
    return new StateField(this.getName(), states, (String) newValue);
  }

  private int orderOf(String aState) {
    for (int i = 0; i < states.length; i++) {
      if (state.equals(aState)) {
        return i;
      }
    }
    return -1;
  }
}
