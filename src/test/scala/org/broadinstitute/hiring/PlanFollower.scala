package org.broadinstitute.hiring

object PlanFollower {
  def follow(keyboard: Keyboard)(plan: Seq[Button]): String = {
    //NB: Assume we start at column 0, row 0
    val start = Position(row = 0, column = 0)
    
    val z: (String, Position) = ("", start)
    
    val (str, _) = plan.foldLeft(z) { (accTuple, button) =>
      val (acc, currentPosition) = accTuple
      
      button match {
        case d: Direction => (acc, currentPosition.move(d))
        case Button.Select => (acc ++ keyboard.charAt(currentPosition), currentPosition)
      }
    }
    
    str
  }
}
