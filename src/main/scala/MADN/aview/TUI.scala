package MADN.aview

import MADN.controller.Controller
import MADN.model.Grid
import MADN.util.Observer

import scala.io.StdIn.readLine

case class TUI (controller : Controller) extends Observer {

  controller.add(this)
  val eol: String = sys.props("line.separator")

  def inputLoop(grid : Grid) : Unit =
    println(eol + grid.toString)
    val input = readLine("Input: ")
    input match
      case "q" => return
      case "d" => println("Du hast eine " + controller.rollDice + " gewürfelt.")
      case _ => println("Falscher Input")
    inputLoop(grid)

  override def update(): Unit =  println(controller.gridToString)
}