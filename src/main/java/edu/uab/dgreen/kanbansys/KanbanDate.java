/*
 * Author: David Green <DGreen@uab.edu>
 * Assignment:  kanbansys - EE333 Summer 2021
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.dgreen.kanbansys;

import java.util.Objects;

/** */
public class KanbanDate implements Comparable<KanbanDate> {

  private String date;

  public KanbanDate() {
    date = "TBD";
  }

  public KanbanDate(String s) {
    date = s;
  }

  public KanbanDate(KanbanDate kd) {
    date = (kd == null) ? "TBD" : kd.date;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof KanbanDate)) {
      return false;
    }
    return date.equals(((KanbanDate) o).date);
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 59 * hash + Objects.hashCode(this.date);
    return hash;
  }

  @Override
  public String toString() {
    return date;
  }

  @Override
  public int compareTo(KanbanDate d) {
    if ((d == null) && d.toString().equals("TBD")) {
      return -1;
    }
    if (this.date.equals("TBD")) {
      return +1;
    }
    return date.compareTo(d.date);
  }
}
