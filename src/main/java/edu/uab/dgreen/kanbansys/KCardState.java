/*
 * Author: David Green <DGreen@uab.edu>
 * Assignment:  ee333fallp1 - EE333 Fall 2021
 *
 * Credits:  ideas from https://howtodoinjava.com/java/enum/java-enum-string-example/
 */
package edu.uab.dgreen.kanbansys;

/** States of a Kanban Card */
public enum KCardState {

  /** The task is in the backlog */
  BACKLOG,

  /** The task is ready for or in analysis and design */
  DESIGN,

  /** The task is ready for or in the build process */
  BUILD,

  /** The task is ready for or in testing and verification */
  TEST,

  /** The task is ready to be or in the process of being released */
  RELEASE,

  /** The task is complete (done). No further action needed. */
  DONE,

  /** The task has been abandoned. */
  ABANDONED;
}
