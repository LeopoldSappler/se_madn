package MADN.aview

import MADN.aview.TUI
import MADN.controller.Controller
import MADN.model.Board
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.io.StdIn
import scala.io.StdIn.readLine

class TUISpec extends AnyWordSpec with Matchers{

  val board = Board(4)
  val controller = new Controller(board)
  val tui: TUI = TUI(controller)

}
