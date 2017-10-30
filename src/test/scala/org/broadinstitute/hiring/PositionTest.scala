package org.broadinstitute.hiring

import org.scalatest.FunSuite

final class PositionTest extends FunSuite {
  private val origin = Position(0, 0)
  
  test("guards") {
    Position(0, 0)
    Position(123, 0)
    Position(0, 234)
    Position(45, 67)
    
    intercept[Exception] {
      Position(-1, 0)
    }
    
    intercept[Exception] {
      Position(-100, 0)
    }
    
    intercept[Exception] {
      Position(0, -1)
    }
    
    intercept[Exception] {
      Position(0, -100)
    }
    
    intercept[Exception] {
      Position(-1, -1)
    }
  }
  
  test("up") {
    val p = Position(123, 456)
    
    assert(p.up === Position(122, 456))
    
    intercept[Exception] {
      origin.up
    }
  }
  
  test("down") {
    val p = Position(123, 456)
    
    assert(p.down === Position(124, 456))
    
    assert(origin.down === Position(1, 0))
  }
  
  test("left") {
    val p = Position(123, 456)
    
    assert(p.left === Position(123, 455))
    
    intercept[Exception] {
      origin.left
    }
  }
  
  test("right") {
    val p = Position(123, 456)
    
    assert(p.right === Position(123, 457))
    
    assert(origin.right === Position(0, 1))
  }
  
  test("move") {
    import Button._
    
    intercept[Exception] {
      origin.move(Up)
    }
    
    intercept[Exception] {
      origin.move(Left)
    }
    
    assert(origin.move(Right) === origin.right)
    
    assert(origin.move(Down) === origin.down)
    
    val p = Position(123,456) 
    
    assert(p.move(Up) === p.up)
    assert(p.move(Down) === p.down)
    assert(p.move(Left) === p.left)
    assert(p.move(Right) === p.right)
  }
}
