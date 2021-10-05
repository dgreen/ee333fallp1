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

/** Test the multi-line field */
public class MultiLineFieldNGTest {

  MultiLineField ml1;
  MultiLineField ml2;

  public MultiLineFieldNGTest() {}

  @BeforeMethod
  public void setUpMethod() throws Exception {
    ml1 = new MultiLineField("first", "fieldValue1");
    ml2 = new MultiLineField("second", "fieldValue2" + System.lineSeparator() + "line 2");
  }

  @AfterMethod
  public void tearDownMethod() throws Exception {}

  /** Test of get method, of class MultiLineField. */
  @Test
  public void testGet() {
    assertEquals(ml1.get(), "fieldValue1");
    assertEquals(ml2.get(), "fieldValue2" + System.lineSeparator() + "line 2");
  }

  /** Test of toString method, of class MultiLineField. */
  @Test
  public void testToString() {
    assertEquals(ml1.toString(), "fieldValue1");
    assertEquals(ml2.toString(), "fieldValue2" + System.lineSeparator() + "line 2");
  }

  /** Test of valueCompareTo method, of class MultiLineField. */
  @Test
  public void testValueCompareTo() {
    assertTrue(ml1.valueCompareTo(ml2) < 0);
    assertTrue(ml1.valueCompareTo(ml1) == 0);
    assertTrue(ml2.valueCompareTo(ml1) > 0);
  }

  /** Test of newField method, of class MultiLineField. */
  @Test
  public void testNewField() {
    // Make the new Field
    MultiLineField nf = (MultiLineField) ml1.newField("new value");
    assertEquals(nf.getName(), "first");
    assertEquals(nf.getType(), "multiline");
    assertEquals((String) nf.get(), "new value");
  }

  /** Test of newFieldAddLine method, of class MultiLineField. */
  @Test
  public void testNewFieldAddLine() {
    MultiLineField nf = (MultiLineField) ml1.newFieldAddLine("new value");
    assertEquals(nf.getName(), "first");
    assertEquals(nf.getType(), "multiline");
    assertEquals((String) nf.get(), "fieldValue1" + System.lineSeparator() + "new value");
  }
}
