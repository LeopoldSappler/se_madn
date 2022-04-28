package MADN.aview

import scala.io.StdIn.readLine

class TUI {
  val dice = new Dice
  val eol: String = sys.props("line.separator")

  def start() : Grid =
    val playerCount: Int = readLine("Number of players: ").toInt
    val grid: Grid = Grid (playerCount)
    grid

  def inputLoop(grid : Grid) : Unit =
    println(eol + grid.toString)
    val input = readLine("Input: ")
    input match
      case "q" => return
      case "d" => println("Du hast eine " + dice.roll() + " gewürfelt.")
      case _ => println("Falscher Input")
    inputLoop(grid)
}