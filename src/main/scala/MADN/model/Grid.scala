package MADN.model

import scala.language.postfixOps

class Grid(val playerCount: Int) {
  var playFieldCount = 40
  val tempStartField = new Array[Int](playerCount * 4)
  val tempPlayField = new Array[Int](playFieldCount)
  val tempFinishField = new Array[Int](playerCount * 4)
  val eol: String = sys.props("line.separator")

  val startField: Array[Int] = startFields()
  val playField: Array[Int] = playFields()
  val finishField: Array[Int] = finishFields()

  def startFields(): Array[Int] =
    var index = 0
    for (i <- 1 to playerCount) {
      for (_ <- 1 to 4) {
        tempStartField(index) = i
        index = index + 1
      }
    }
    tempStartField

  def playFields(): Array[Int] =
    for (i <- tempPlayField.indices)
      tempPlayField(i) = 0
    tempPlayField

  def finishFields(): Array[Int] =
    for (i <- tempFinishField.indices)
      tempFinishField(i) = 0
    tempFinishField

  override def toString: String =
    startField.mkString(" ") + eol + playField.mkString("") + eol + finishField.mkString("") + eol
}