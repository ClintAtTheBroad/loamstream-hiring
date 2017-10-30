package org.broadinstitute.hiring

/**
 * A trait/ADT to represent all the buttons on our remote control 
 */
sealed trait Button

/**
 * A trait/ADT to represent the directional buttons on our remote control 
 */
sealed trait Direction

object Button {
  case object Up extends Button with Direction
  case object Down extends Button with Direction
  case object Left extends Button with Direction
  case object Right extends Button with Direction
  case object Select extends Button
}
