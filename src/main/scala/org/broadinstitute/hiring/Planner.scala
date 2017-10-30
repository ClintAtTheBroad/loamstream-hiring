package org.broadinstitute.hiring

/**
 * A trait to represent the notion of finding the button presses needed to spell out a given string on a given
 * virtual keyboard.
 */
trait Planner {
  /**
   * Given a keyboard and a desired string, return the sequence of button presses that will "type" out the desired 
   * string.  For example, if we wanted to spell "cat" on a qwerty keyboard, with the cursor starting on 'q', 
   * one solution is:
   * 
   * down, down, right, right, select, 			//c
   * up, left, left, select,           			//a
   * up, right, right, right, right, select //t
   * 
   * NOTE: you DO NOT need to find every solution, or the best one according to some metric, just a valid one.
   */
  def findButtonPresses(keyboard: Keyboard)(desired: String): Seq[Button]
}

object Planner {
  object Default extends Planner {
    /**
     * TODO: Implement this to make the tests pass.
     */
    override def findButtonPresses(keyboard: Keyboard)(desired: String): Seq[Button] = {
      ???
    }
  }
}
