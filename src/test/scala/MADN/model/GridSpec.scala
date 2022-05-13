package MADN.model

import MADN.model.Grid
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class GridSpec extends AnyWordSpec{

  "playerCount" in {
    val grid = new Grid(4)
    grid.playerCount should be (4)
  }

  "playerField" in {
    val grid = new Grid(4)
    grid.playFieldCount should be (40)
  }

  "eol" in {
    val grid = new Grid(4)
    grid.eol should be (sys.props("line.separator"))
  }

  "grid" should {
    "print 4 start fields for every player from playerCount" in {
      val grid1 = new Grid(1)
      grid1.Start.startFields() should be (Array(1, 1, 1, 1))
      val grid4 = new Grid(4)
      grid4.Start.startFields() should be (Array(1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4))
    }

    "print one playing field for every value from playFieldCount" in {
      val grid1 = new Grid(4)
      grid1.playFieldCount = 40
      grid1.Play.playFields() should be (Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
    }

    "print 4 finish fields for every player from playerCount" in {
      val grid1 = new Grid(1)
      grid1.Finish.finishFields() should be (Array(0, 0, 0, 0))
      val grid4 = new Grid(4)
      grid4.Finish.finishFields() should be (Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))
    }

    "print the board" in {
      val grid = new Grid(4)
      val eol: String = sys.props("line.separator")
      grid.toString() should be ("1 1 1 1 2 2 2 2 3 3 3 3 4 4 4 4" + eol
        + "0000000000000000000000000000000000000000" + eol
        + "0000000000000000" + eol)
    }
  }
}
