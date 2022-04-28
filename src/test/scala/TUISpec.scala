import MADN.model.Grid
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

import scala.io.StdIn

class TUISpec extends AnyWordSpec {

  "start" in {
    val tui = new TUI
    val grid = new Grid(4)

    tui.start() should be (grid: Grid)
  }

}
