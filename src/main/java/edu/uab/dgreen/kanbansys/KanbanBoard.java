/*
 * Author: David Green <DGreen@uab.edu>
 * Assignment:  kanbansys - EE333 Fall 2021
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.dgreen.kanbansys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Model a Kanban Board
 *
 * <p>Create the concept of a KanbanBoard which models a Kanban Board, as a minimum, it should
 * Collect all Kanban Cards into an HashMap using UID as the key Find all Kanban cards of a
 * particular state
 */
public class KanbanBoard {

  private HashMap<String, KanbanCard> cards;

  public KanbanBoard() {
    cards = new HashMap<>();
  }

  /**
   * Add a card to the board
   *
   * @param kc the card to add
   */
  public void add(KanbanCard kc) {
    cards.put(kc.getUid(), kc);
  }

  /**
   * Provide all cards that have a particular state value
   *
   * @param aState the state we are looking
   * @return ArrayList of cards with the matching state
   */
  public ArrayList<KanbanCard> getAllWithState(String aState) {
    KanbanCard c;
    ArrayList<KanbanCard> result = new ArrayList<>();

    Set<String> uids = cards.keySet();

    for (String uid : uids) {
      c = cards.get(uid);
      if (c.getField("state").get().equals(aState)) {
        result.add(c);
      }
    }
    return result;
  }
}
