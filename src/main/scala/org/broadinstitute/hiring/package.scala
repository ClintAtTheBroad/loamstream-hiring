package org.broadinstitute

package object hiring {
  /**
   * A Row is a sequence of chars representing keys on a virtual keyboard that we can index into efficiently. 
   */
  type Row = IndexedSeq[Char]
}
