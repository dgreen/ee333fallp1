/*
 * Author: David Green <DGreen@uab.edu>
 * Assignment:  kanbansys - EE333 Fall 2021
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.dgreen.kanbansys;

/** Model text field that holds a single line of text */
public class TextField extends Field {

  private final String text; // contents of field

  /**
   * A Field that holds single line of text. If the text is null, an empty string is substituted. If
   * the text is multi-line, only the first line is used.
   *
   * @param name of field
   * @param text value of field
   */
  public TextField(String name, String text) {
    super(name, "text");
    this.text = filter(text);
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
    return text.compareTo(((TextField) f).text);
  }

  /**
   * Create a new Field with the same name but new value
   *
   * <p>Filter it to be compliant with as a single line text
   *
   * @param newValue new value of the StringField
   * @return the new StringField
   */
  @Override
  public Field newField(Object newValue) {
    return new TextField(this.getName(), filter((String) newValue));
  }

  /**
   * Is this text valid? To be valid, it must be non-null & nor any line breaks
   *
   * <p>The method is static in order to be used in the constructor as well as elsewhere
   *
   * @param text
   * @return false if it is non-null or has line breaks, true otherwise
   */
  public static String filter(String text) {
    if (text == null) {
      return "";
    }

    // first look for platform line separator

    int lineSepIndex = text.indexOf(System.lineSeparator());
    if (lineSepIndex != -1) {
      text = text.substring(0, lineSepIndex);
    }

    // next look for \n due to its wide use (even when not compliant)

    int newLineIndex = text.indexOf("\n");
    if (newLineIndex != -1) {
      text = text.substring(0, newLineIndex);
    }
    return text;
  }
}
