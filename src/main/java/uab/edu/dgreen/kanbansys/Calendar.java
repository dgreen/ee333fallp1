/*
 * Author: David Green <DGreen@uab.edu>
 * Assignment:  ee333fallp1 - EE333 Fall 2021
 *
 * Credits:  (if any for sections of code)
 */
package uab.edu.dgreen.kanbansys;

/** Fake calendar (Static data, methods only */
public class Calendar {

  private static String theDate = "20210815";

  Calendar() {}

  /**
   * Set the calendar to specified date
   *
   * @param date representation of data as String
   */
  public static void setDate(String date) {
    if (date != null) {
      theDate = date;
    }
  }

  /**
   * Provide the fake calendar date
   *
   * @return String representation of date from calendar
   */
  public static String getDate() {
    return theDate;
  }
}
