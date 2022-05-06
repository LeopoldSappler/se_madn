package MADN.aview

import MADN.controller.Controller
import MADN.util.Observer

import scala.io.StdIn.readLine

case class TUI (controller : Controller) extends Observer {

  controller.add(this)
  val eol: String = sys.props("line.separator")

  def processInput(input: String) : String =
    input match
      case "d" => "Du hast eine " + controller.rollDice + " gewürfelt."
      case "q" => "Beende Programm..."
      case _ => "Falscher Input"
      
  override def update(): Unit =  println(controller.gridToString)
}