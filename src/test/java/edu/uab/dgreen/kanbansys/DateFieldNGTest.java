/*
 * Author: David Green <DGreen@uab.edu>
 * Assignment:  kanbansys - EE333 Fall 2021
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.dgreen.kanbansys;

import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/** Test a DateField */
public class DateFieldNGTest {

  DateField df1;
  DateField df2;

  public DateFieldNGTest() {}

  @BeforeMethod
  public void setUpMethod() throws Exception {
    df1 = new DateField("FirstDateField", new KanbanDate("20210816"));
    df2 = new DateField("SecondDateField", new KanbanDate("20210817"));
  }

  @AfterMethod
  public void tearDownMethod() throws Exception {}

  /** Test of get method, of class DateField. */
  @Test
  public void testGet() {
    Object value = df1.get();
    assertTrue(value instanceof KanbanDate);
    KanbanDate date = (KanbanDate) value;
    assertTrue(date.toString().equals("20210816"));
  }

  /** Test of toString method, of class DateField. */
  @Test
  public void testToString() {
    assertTrue(df1.toString().equals("20210816"));
  }

  /** Test of compareTo method, of class DataField */
  @Test
  public void testCompareTo() {
    // special cases
    assertTrue(df1.compareTo(null) < 0);
    assertTrue(df1.compareTo(new StringField("different", "later")) < 0);

    assertTrue(df1.compareTo(df2) < 0);
    assertTrue(df1.compareTo(df1) == 0);
    assertTrue(df2.compareTo(df1) > 0);
  }

  /** Test of valueCompareTo method, of class DateField. */
  @Test
  public void testValueCompareTo() {
    assertTrue(df1.valueCompareTo(df2) < 0);
    assertTrue(df1.valueCompareTo(df1) == 0);
    assertTrue(df2.valueCompareTo(df1) > 0);
  }

  /** Test of newField method, of class DateField. */
  @Test
  public void testNewField() {

    // Make the new Field
    DateField nf = (DateField) df1.newField(new KanbanDate());
    assertEquals(nf.getName(), "FirstDateField");
    assertEquals(nf.getType(), "date");
    assertEquals(nf.get().toString(), "TBD");
  }
}