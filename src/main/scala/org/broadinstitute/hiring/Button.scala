package org.broadinstitute.hiring

sealed trait Button

sealed trait Direction

object Button {
  case object Up extends Button with Direction
  case object Down extends Button with Direction
  case object Left extends Button with Direction
  case object Right extends Button with Direction
  case object Select extends Button
}
