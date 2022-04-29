import MADN.model.Grid
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

import scala.io.StdIn
import MADN.aview.TUI
import MADN.controller.Controller

import scala.io.StdIn.readLine

class TUISpec extends AnyWordSpec {

  "start" in {
    val playerCount: Int = 4
    val grid: Grid = Grid (playerCount)
    val controller = new Controller(grid)
    val tui = new TUI(controller)

    grid should be (grid: Grid)
  }

}
