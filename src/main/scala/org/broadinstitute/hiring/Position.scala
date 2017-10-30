package org.broadinstitute.hiring

/**
 * A class representing a position on a virtual keyboard, described by a row and column index.
 * The constructor will throw if negative column or row indices are passed in.
 */
final case class Position(row: Int, column: Int) {
  require(row >= 0, s"row must be >= 0, but was $row")
  require(column >= 0, s"row must be >= 0, but was $column")
  
  /** The Position obtained by moving up from this Position */ 
  def up(): Position = copy(row = row - 1)
  /** The Position obtained by moving down from this Position */
  def down(): Position = copy(row = row + 1)
  /** The Position obtained by moving left from this Position */
  def left(): Position = copy(column = column - 1)
  /** The Position obtained by moving right from this Position */
  def right(): Position = copy(column = column + 1)
  
  /** The Position obtained by moving from this Position in the direction indicated by the passed button. */
  def move(direction: Direction): Position = direction match {
    case Button.Up => up()
    case Button.Down => down()
    case Button.Left => left()
    case Button.Right => right()
  }
}
