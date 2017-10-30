package org.broadinstitute.hiring

trait Planner {
  def findKeypresses(keyboard: Keyboard)(desired: String): Seq[Button]
}
