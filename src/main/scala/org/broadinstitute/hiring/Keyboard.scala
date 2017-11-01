package org.broadinstitute.hiring

/**
 * A type to represent a fictional on-screen keyboard for a Netflix-like system.
 */
trait Keyboard {
  /**
   * The rows of keys on this keyboard.  For example, on a querty keyboard, the first row is
   * q, w, e, r, t, y, u, i, o, p
   */
  def rows: IndexedSeq[Row]
  
  /**
   * Given a position (a row and column), return an Option wrapping the character at that row and column on this
   * keyboard.  If the position is out-of-bounds, return None.
   */
  final def charAt(position: Position): Option[Char] = {
    def isValidRow(row: Int): Boolean = row >= 0 && row < rows.size
    def isValidColumn(row: Int, column: Int): Boolean = column >= 0 && column < rows(row).size
    
    position match {
      case Position(row, column) if isValidRow(row) && isValidColumn(row, column) => Some(rows(row)(column))
      case _ => None
    }
  }
}

/**
 * Default keyboards
 */
object Keyboard {
  /**
   * Widely used in North America
   */
  object Qwerty extends Keyboard {
    override val rows: IndexedSeq[Row] = IndexedSeq(
        "qwertyuiop",
        "asdfghjkl",
        "zxcvbnm")
  }
  
  /**
   * Most common in France
   */
  object Azerty extends Keyboard {
    override val rows: IndexedSeq[Row] = IndexedSeq(
        "azertyuiop",
        "qsdfghjklm",
        "wxcvbn")
  }
  
  /**
   * Widely used in German-speaking countries
   */
  object Qwertz extends Keyboard {
    override val rows: IndexedSeq[Row] = IndexedSeq(
        "qwertzuiopü",
        "asdfghjklöä",
        "yxcvbnm")
  }
  
  /**
   * Arranges letters in rows of 8 or 9 letters, starting with 'a' and proceeding in (English) alphabetical order.
   */
  object Alphabetical extends Keyboard {
    override val rows: IndexedSeq[Row] = IndexedSeq(
        "abcdefghi",
        "jklmnopqr",
        "stuvwxyz")
  }
}
