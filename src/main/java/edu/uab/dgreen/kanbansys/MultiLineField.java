/*
 * Author: David Green <DGreen@uab.edu>
 * Assignment:  kanbansys - EE333 Fall 2021
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.dgreen.kanbansys;

/**
 * Multi-line field
 *
 */
public class MultiLineField extends Field {

  private String text; // contents of field

	public MultiLineField(String name, String text) {
   super(name, "multiline");
    this.text = (text == null) ? "unknown" : text;
  }

  /**
   * Returns a string representation of the field's value (given it is a string, the value is
   * returned. (same as toString())
   *
   * @return the value of the field (text string)
   */
  @Override
  public final String get() {
    return text;
  }

  /**
   * Returns a string representation of the field's value (given it is a string, the value is
   * returned.
   *
   * @return the value of the field (text string)
   */
  @Override
  public String toString() {
    return text;
  }

  /**
   * Do a compareTo on the value, the parameter f is already handled if it is null or not the same
   * type by the superClass.
   *
   * @param f the other stringField being compared to
   * @return negative (before), zero (equal), positive after
   */
  @Override
  public int valueCompareTo(Field f) {
    return text.compareTo(((MultiLineField) f).text);
  }

  /**
   * Create a new Field with the same name but new value
   *
   * @param newValue new value of the MultiLineField
   * @return the new MultiLineField
   */
  @Override
  public Field newField(Object newValue) {
    return new MultiLineField(this.getName(), (String) newValue);
  }

	/**
	 * Add another line (or more if text has embedded separators.  Add a line separator even
	 * even if text is empty string but skip if text is null
	 * @param newText text to be appended to field.
	 */
	public Field newFieldAddLine(String newText) {
		if (text != null) {
			return new MultiLineField(this.getName(), text + System.lineSeparator() + newText );
		} else {
		return this; // no change
		}
	}
}

