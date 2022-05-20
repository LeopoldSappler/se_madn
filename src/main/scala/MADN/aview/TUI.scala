package MADN.aview

import MADN.controller.Controller
import MADN.util.Observer

import scala.io.StdIn.readLine
import scala.language.postfixOps
import scala.util.control.Breaks.break

case class TUI(controller: Controller) extends Observer {

  controller.add(this)
  val eol: String = sys.props("line.separator")

  override def update(): Unit = println(controller.board.toString)

  def run(): Unit = {
    println(controller.toString)
    inputLoop()
  }

  def inputLoop(): Unit = {
    for (playerIndex <- 0 until controller.board.playerCount)
      println("Spieler " + controller.players(playerIndex).id + " ist dran:")
      val diceValue: Int = controller.roll
      println("Du hast eine " + diceValue + " gewuerfelt.")
      controller.processMove(diceValue, controller.players(playerIndex))
      println(controller.toString)
    inputLoop()
  }

}