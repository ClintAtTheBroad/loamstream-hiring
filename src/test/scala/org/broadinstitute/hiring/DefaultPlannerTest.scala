package org.broadinstitute.hiring

import org.scalatest.FunSuite

final class DefaultPlannerTest extends FunSuite {
  test("single-letter 0 - alphabetical") {
    doTest(Planner.Default, Keyboard.Alphabetical, "a")
  }
  
  test("single-letter 1 - azerty") {
    doTest(Planner.Default, Keyboard.Azerty, "a")
  }
  
  test("single-letter 2 - azerty") {
    doTest(Planner.Default, Keyboard.Azerty, "z")
  }
  
  test("single-letter 3 - qwerty") {
    doTest(Planner.Default, Keyboard.Alphabetical, "k")
  }
  
  test("star - alphabetical") {
    doTest(Planner.Default, Keyboard.Alphabetical, "star")
  }
  
  test("star - qwerty") {
    doTest(Planner.Default, Keyboard.Querty, "star")
  }
  
  test("starwars - alphabetical") {
    doTest(Planner.Default, Keyboard.Alphabetical, "star")
  }
  
  test("starwars - qwerty") {
    doTest(Planner.Default, Keyboard.Querty, "star")
  }
  
  test("batman - azerty") {
    doTest(Planner.Default, Keyboard.Azerty, "batman")
  }
  
  test("batman - qwertz") {
    doTest(Planner.Default, Keyboard.Qwertz, "batman")
  }
  
  test("cat - qwerty") {
    doTest(Planner.Default, Keyboard.Querty, "cat")
  }
  
  private def doTest(planner: Planner, keyboard: Keyboard, desired: String): Unit = {
    val plan = planner.findButtonPresses(keyboard)(desired)
    
    assert(plan.isEmpty === false)
    assert(plan.count(_ == Button.Select) === desired.size)
    
    assert(PlanFollower.follow(keyboard)(plan) === desired)
  }
}
