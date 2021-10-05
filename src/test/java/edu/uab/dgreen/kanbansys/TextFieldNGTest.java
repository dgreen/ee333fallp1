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

/** Test text field */
public class TextFieldNGTest {

  TextField tf1;
  TextField tf2;
  TextField tf3;

  public TextFieldNGTest() {}

  @BeforeMethod
  public void setUpMethod() throws Exception {
    tf1 = new TextField("tf1", "text field 1");
    tf2 = new TextField("tf2", "text field 2");
    tf3 = new TextField("tf3", "first\nsecond");
  }

  @AfterMethod
  public void tearDownMethod() throws Exception {}

  /** Test of get method, of class TextField. */
  @Test
  public void testGet() {
    assertEquals(tf1.get(), "text field 1");
  }

  /** Test of toString method, of class TextField. */
  @Test
  public void testToString() {
    assertEquals(tf1.toString(), "text field 1");
    assertEquals(tf3.toString(), "first");
  }

  /** Test of valueCompareTo method, of class TextField. */
  @Test
  public void testValueCompareTo() {
    assertTrue(tf1.valueCompareTo(tf2) < 0);
    assertTrue(tf1.valueCompareTo(tf1) == 0);
    assertTrue(tf2.valueCompareTo(tf1) > 0);
  }

  /** Test of newField method, of class TextField. */
  @Test
  public void testNewField() {
    // Make the new Field
    TextField nf = (TextField) tf1.newField("new value\nnoise");
    assertEquals(nf.getName(), "tf1");
    assertEquals(nf.getType(), "text");
    assertEquals((String) nf.get(), "new value");
  }

  /** Test of filter method, of class TextField. */
  @Test
  public void testFilter() {
    assertEquals(TextField.filter("This is valid"), "This is valid");
    assertEquals(TextField.filter(null), "");
    assertEquals(TextField.filter("before\nAfter"), "before");
    String slong =
        """
									 This
                   is a multi-line
                   string.
                 """;
    assertEquals(TextField.filter(slong), "This");
  }
}