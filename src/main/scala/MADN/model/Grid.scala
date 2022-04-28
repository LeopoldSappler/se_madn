package MADN.model

import scala.language.postfixOps

class Grid(val playerCount: Int) {
  var playFieldCount = 40
  val startField = new Array[Int](playerCount * 4)
  val playField = new Array[Int](playFieldCount)
  val finishField = new Array[Int](playerCount * 4)
  val eol: String = sys.props("line.separator")

  def startFields(): Array[Int] =
    var index = 0
    for (i <- 1 to playerCount) {
      for (_ <- 1 to 4) {
        startField(index) = i
        index = index + 1
      }
    }
    startField

  def playFields(): Array[Int] =
    for (i <- playField.indices)
      playField(i) = 0
    playField

  def finishFields(): Array[Int] =
    for (i <- finishField.indices)
      finishField(i) = 0
    finishField

  val board: String = startFields().mkString(" ") + eol + playFields().mkString("") + eol + finishFields().mkString("") + eol

  override def toString: String = board
}
