package MADN

import MADN.aview.TUI
import MADN.controller.Controller
import MADN.model.Grid

import scala.io.StdIn.readLine

@main def main(): Unit =
  println("Mensch ärgere dich nicht")
  println("------------------------")
  val playerCount: Int = readLine("Number of players: ").toInt
  val grid: Grid = Grid (playerCount)
  val controller = new Controller(grid)
  val tui = TUI(controller)

  tui.run()