package MADN.model

import MADN.model.Player

case class Board(val playerCount: Int, val playFields: Vector[Int], val finishFields: Vector[Vector[Int]]) {
  val eol: String = sys.props("line.separator")
  val baseSize: Int = 56

  def put(fromIndex: Int, toIndex: Int, player: Player): Vector[Int] = {
    val updatedPlayField = playFields.updated(fromIndex, 0)
    if (toIndex > baseSize - 1)
      val newToIndex = toIndex - 56
      updatedPlayField.updated(newToIndex, player.id)
    else
      updatedPlayField.updated(toIndex, player.id)
  }

  def putStart(toIndex: Int, player: Player): Vector[Int] = {
    playFields.updated(toIndex, player.id)
  }

  override def toString: String = {
    playFields.mkString(" ") + eol + finishFields.mkString(" ") + eol
  }
}
