package org.broadinstitute.hiring

trait Keyboard {
  def rows: IndexedSeq[Row]
  
  final def charAt(position: Position): Option[Char] = {
    def isValidRow(row: Int): Boolean = row >= 0 && row < rows.size
    def isValidColumn(row: Int, column: Int): Boolean = column >= 0 && column < rows(row).size
    
    position match {
      case Position(row, column) if isValidRow(row) && isValidColumn(row, column) => Some(rows(row)(column))
      case _ => None
    }
  }
}
