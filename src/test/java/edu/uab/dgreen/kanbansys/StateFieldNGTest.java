/*
 * Author: David Green <DGreen@uab.edu>
 * Assignment:  kanbansys - EE333 Fall 2021
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.dgreen.kanbansys;

import java.util.ArrayList;
import java.util.Arrays;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/** Test StateField */
public class StateFieldNGTest {

  ArrayList<String> stateList = new ArrayList<>();
  String stateListA[] = {"STILL", "RUNNING", "BROKE"};

  StateField sf1;
  StateField sf2;
  StateField sf3;

  public StateFieldNGTest() {}

  @BeforeMethod
  public void setUpMethod() throws Exception {
    stateList.addAll(Arrays.asList(stateListA));
    sf1 = new StateField("sf1", stateList, "STILL");
    sf2 = new StateField("sf2", stateList, "RUNNING");
    sf3 = new StateField("sf3", stateList, "BROKE");
  }

  @AfterMethod
  public void tearDownMethod() throws Exception {}

  /** Test of get method, of class StateField. */
  @Test
  public void testGet() {
    assertEquals(sf1.get(), "STILL");
  }

  /** Test of toString method, of class StateField. */
  @Test
  public void testToString() {
    assertEquals(sf1.toString(), "STILL");
  }

  /** Test of valueCompareTo method, of class StateField. */
  @Test
  public void testValueCompareTo() {
    assertTrue(sf1.valueCompareTo(sf2) < 0);
    assertTrue(sf1.valueCompareTo(sf3) < 0);
    assertTrue(sf1.valueCompareTo(sf1) == 0);
    assertTrue(sf3.valueCompareTo(sf2) > 0);
  }

  /** Test of newField method, of class StateField. */
  @Test
  public void testNewField() {
    StateField nf = (StateField) sf1.newField("BROKE");
    assertEquals(nf.getName(), "sf1");
    assertEquals(nf.getType(), "state");
    assertEquals(nf.get().toString(), "BROKE");
    // check to see if exactly same array of values used
    assertEquals(nf.states, sf1.states);
  }
}