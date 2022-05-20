package MADN

import MADN.aview.TUI
import MADN.controller.Controller
import MADN.model.{Board, Grid}
import MADN.util.Strat

import javax.swing.text.StyledEditorKit.BoldAction
import scala.io.StdIn.readLine

@main def main(): Unit =
  println("Mensch aergere dich nicht")
  println("------------------------")
  val strategy: String = readLine("Wählen sie r für random Gegner oder a für advanced: ")
  Strat(strategy)
  val playerCount: Int = readLine("Number of players: ").toInt
  val board: Board = Board(playerCount, Vector.fill(56)(0), Vector.fill(playerCount, 4)(0))
  val controller = new Controller(board)
  val tui = TUI(controller)

  tui.run()