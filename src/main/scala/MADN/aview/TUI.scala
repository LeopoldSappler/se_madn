package MADN.aview

import MADN.controller.Controller
import MADN.util.Observer

import scala.io.StdIn.readLine
import scala.language.postfixOps
import scala.util.control.Breaks.break

case class TUI (controller : Controller) extends Observer {

  controller.add(this)
  val eol: String = sys.props("line.separator")

  def run(): Unit =
    println(controller.grid.toString)
    inputLoop()

  def inputLoop(): Unit =
    for (player <- 1 to controller.grid.playerCount)
      println("Spieler " + player + " ist dran:")
      val diceValue: Int = controller.rollDice
      println("Du hast eine " + diceValue + " gewürfelt.")
      processMove(diceValue, player)
      println(controller.grid.toString)
    inputLoop()


  def processMove(diceValue: Int, player : Int): Unit =

    object context {
          var strategy = if (diceValue == 6 && !controller.grid.playField.contains(player)) strategy1 else if (diceValue == 6 && controller.grid.startField.contains(player)) strategy2

          def strategy1 = {
            println("Da du eine 6 gewürfelt hast, kannst du eine Figur aus den Startfeldern spielen!")
            setupPlayer(player)
          }

          def strategy2 = {
            println("Figur im Startfeld aber auch Figuren im Spielfeld. schreibe start oder spiel")
          readLine() match
            case "start" => setupPlayer(player)
            case "spiel" => {
              for (i <- controller.grid.playField.indices)
                if (controller.grid.playField(i) == player)
                  println("Player " + player + " hat eine Figur bei: " + i)
              println(controller.grid.toString)
              val field: Int = readLine().toInt
              move(player, field, field + diceValue)
            }
        }
    }
    context.strategy


  def setupPlayer(player: Int): Unit =
    for (i <- controller.grid.startField.indices)
      if (controller.grid.startField(i) == player)
        controller.grid.startField(i) = 0
        controller.grid.playField((player - 1) * 10) = player
        val secondDiceValue = controller.rollDice
        println(secondDiceValue)
        move(player, (player - 1) * 10, (player - 1) * 10 + secondDiceValue)
        return

  def move(player: Int, x1: Int, x2: Int): Unit =
    controller.grid.playField(x1) = 0
    if (x2 > 39)
      val newx2 = x2 - 40
      controller.grid.playField(newx2) = player
    else
      controller.grid.playField(x2) = player

  def processInput(input: String) : String =
    input match
      case "d" => "Du hast eine " + controller.rollDice + " gewürfelt."
      case "q" => "Beende Programm..."
      case _ => "Falscher Input"

  override def update(): Unit =  println(controller.gridToString)
}