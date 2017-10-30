package org.broadinstitute.hiring

final case class Position(row: Int, column: Int) {
  require(row >= 0, s"row must be >= 0, but was $row")
  require(column >= 0, s"row must be >= 0, but was $column")
  
  def up(): Position = copy(row = row - 1)
  def down(): Position = copy(row = row + 1)
  def left(): Position = copy(column = column - 1)
  def right(): Position = copy(column = column + 1)
  
  def move(direction: Direction): Position = direction match {
    case Button.Up => up()
    case Button.Down => down()
    case Button.Left => left()
    case Button.Right => right()
  }
}
