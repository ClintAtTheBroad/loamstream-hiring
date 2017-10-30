package org.broadinstitute.hiring

import org.scalatest.FunSuite

final class PlannerTest extends FunSuite {
  test("TODO") {
    object QuertyKeyboard extends Keyboard {
      override val rows: IndexedSeq[Row] = IndexedSeq(
          "qwertyuiop",
          "asdfghjkl",
          "zxcvbnm")
    }
    
    import Button._
    
    val plan = Seq(Down, Down, Right, Right, Select, 
                   Up, Left, Left, Select,
                   Right, Right, Right, Right, Select)
    
    assert(PlanFollower.follow(QuertyKeyboard)(plan) === "cag")
  }
}
