package org.broadinstitute.hiring

import org.scalatest.FunSuite

final class PlanFollowerTest extends FunSuite {
  test("Can follow button-press plans") {
    import Keyboard.Querty
    import Button._
    
    val plan = Seq(Down, Down, Right, Right, Select, 
                   Up, Left, Left, Select,
                   Right, Right, Right, Right, Up, Select)
    
    assert(PlanFollower.follow(Querty)(plan) === "cat")
  }
}
