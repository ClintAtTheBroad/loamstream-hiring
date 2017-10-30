package org.broadinstitute.hiring

import org.scalatest.FunSuite

final class KeyboardTest extends FunSuite {
  
  test("charAt") {
    import Keyboard.Querty.charAt
    import Position.{apply => pos }

    //past the (right) end
    assert(charAt(pos(0, 10)) === None)
    assert(charAt(pos(1, 9)) === None)
    assert(charAt(pos(2, 7)) === None)
    
    //way past the (right) end
    assert(charAt(pos(0, 42)) === None)
    assert(charAt(pos(1, 42)) === None)
    assert(charAt(pos(2, 42)) === None)
    
    //valid keys
    assert(charAt(pos(0, 0)) === Some('q'))
    assert(charAt(pos(0, 1)) === Some('w'))
    assert(charAt(pos(0, 2)) === Some('e'))
    assert(charAt(pos(0, 3)) === Some('r'))
    assert(charAt(pos(0, 4)) === Some('t'))
    assert(charAt(pos(0, 5)) === Some('y'))
    assert(charAt(pos(0, 6)) === Some('u'))
    assert(charAt(pos(0, 7)) === Some('i'))
    assert(charAt(pos(0, 8)) === Some('o'))
    assert(charAt(pos(0, 9)) === Some('p'))
    
    assert(charAt(pos(1, 0)) === Some('a'))
    assert(charAt(pos(1, 1)) === Some('s'))
    assert(charAt(pos(1, 2)) === Some('d'))
    assert(charAt(pos(1, 3)) === Some('f'))
    assert(charAt(pos(1, 4)) === Some('g'))
    assert(charAt(pos(1, 5)) === Some('h'))
    assert(charAt(pos(1, 6)) === Some('j'))
    assert(charAt(pos(1, 7)) === Some('k'))
    assert(charAt(pos(1, 8)) === Some('l'))

    assert(charAt(pos(2, 0)) === Some('z'))
    assert(charAt(pos(2, 1)) === Some('x'))
    assert(charAt(pos(2, 2)) === Some('c'))
    assert(charAt(pos(2, 3)) === Some('v'))
    assert(charAt(pos(2, 4)) === Some('b'))
    assert(charAt(pos(2, 5)) === Some('n'))
    assert(charAt(pos(2, 6)) === Some('m'))
  }
}
