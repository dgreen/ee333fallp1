/*
 * Author: David Green DGreen@uab.edu
 * Assignment:  ee333fallp1 - EE333 Fall 2021
 *
 * Credits:  ideas from https://howtodoinjava.com/java/enum/java-enum-string-example/
 */
package uab.edu.ee333.ee333fallp1;

/**
 * The states of a Kanban Card
 *
 * @author David Green DGreen@uab.edu
 */
public enum KCardState {

  /** */
  BACKLOG("Backlog"),

  /** */
  DESIGN("Design"),

  /** */
  BUILD("Build"),

  /** */
  TEST("Test"),

  /** */
  RELEASE("Release"),

  /** */
  DONE("Done"),

  /** */
  ABANDONED("Abandoned");

  private final String name;

  KCardState(String name) {
    this.name = name;
  }

  /** @return */
  public String getName() {
    return name;
  }
}
