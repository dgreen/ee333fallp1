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

/** test StringField */
public class StringFieldNGTest {

  StringField sf1;
  StringField sf2;

  public StringFieldNGTest() {}

  @BeforeMethod
  public void setUpMethod() throws Exception {
    sf1 = new StringField("first", "fieldValue1");
    sf2 = new StringField("second", "fieldValue2");
  }

  @AfterMethod
  public void tearDownMethod() throws Exception {}

  /** Test of get method, of class StringField. */
  @Test
  public void testGet() {
    assertEquals(sf1.get(), "fieldValue1");
  }

  /** Test of toString method, of class StringField. */
  @Test
  public void testToString() {
    assertEquals(sf1.toString(), "fieldValue1");
  }

  /** Test of valueCompareTo method, of class StringField. */
  @Test
  public void testValueCompareTo() {
    assertTrue(sf1.valueCompareTo(sf2) < 0);
    assertTrue(sf1.valueCompareTo(sf1) == 0);
    assertTrue(sf2.valueCompareTo(sf1) > 0);
  }

  /** Test of newField method, of class StringField. */
  @Test
  public void testNewField() {
    // Make the new Field
    StringField nf = (StringField) sf1.newField("new value");
    assertEquals(nf.getName(), "first");
    assertEquals(nf.getType(), "string");
    assertEquals((String) nf.get(), "new value");
  }
}