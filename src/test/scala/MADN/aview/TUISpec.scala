package MADN.aview

import MADN.aview.TUI
import MADN.controller.Controller
import MADN.model.Grid
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.io.StdIn
import scala.io.StdIn.readLine

class TUISpec extends AnyWordSpec with Matchers{

  val grid = new Grid(4)
  val controller = new Controller(grid)
  val tui: TUI = TUI(controller)

  "tui should print dice" in {
    tui.processInput("d") should startWith ("Du hast eine ")
  }

  "tui should print wrong input" in {
    tui.processInput("asofjasofj") should be ("Falscher Input")
  }
}
