/*
 * Author: David Green <DGreen@uab.edu>
 * Assignment:  kanbansys - EE333 Summer 2021
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.dgreen.kanbansys;

/** Model a field as a string name with the assumption that subclasses will implement the value */
public abstract class Field implements Comparable<Field> {

  private final String name;
  private final String type;

  Field(String name, String type) {
    this.name = (name == null) ? "unknown" : name;
    this.type = (type == null) ? "unknown" : type;
  }

  public String getName() {
    return name;
  }

  public abstract Field newField(Object newValue);

  public boolean isName(String name) {
    return name.equals(this.name);
  }

  @Override
  public abstract String toString();

  public String getTaggedString() {
    return name + ": " + toString();
  }

  public String getType() {
    return type;
  }

  @Override
  public int compareTo(Field f) {
    if (f == null) return -1;
    if (f.getType().equals(this.getType())) {
      return this.valueCompareTo(f);
    }
    // if fields are not the same type, compare the tagged string representation
    return this.getTaggedString().compareTo(f.getTaggedString());
  }

  abstract int valueCompareTo(Field f);
}
