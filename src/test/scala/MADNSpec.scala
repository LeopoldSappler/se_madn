import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class MADNSpec extends AnyWordSpec{
  val grid = new Grid(4)
  private val eol = sys.props("line.separator")

  "playerCount" in {
    grid.playerCount should be (4)
  }

  "playerField" in {
    grid.playFieldCount should be (40)
  }

  "eol" in {
    grid.eol should be (sys.props("line.separator"))
  }

  "grid" should {
    "print 4 start fields for every player from playerCount" in {
      val grid1 = new Grid(1)
      grid1.startFields() should be ("1 1 1 1 " + eol)
      val grid4 = new Grid(4)
      grid4.startFields(4) should be ("1 1 1 1 2 2 2 2 3 3 3 3 4 4 4 4 " + eol)
    }

    "print one playing field for every value from playFieldCount" in {
      val grid1 = new Grid(4)
      grid1.playFieldCount = 1
      grid1.playFields() should be ("0" + eol)
      grid1.playFieldCount = 40
      grid1.playFields() should be ("0000000000000000000000000000000000000000" + eol)
    }

    "print 4 finish fields for every player from playerCount" in {
      val grid1 = new Grid(1)
      grid1.finishFields() should be ("____ " + eol)
      val grid4 = new Grid(4)
      grid4.finishFields() should be ("____ ____ ____ ____ " + eol)
    }

    "print the board" in {
      grid.print() should be ("1 1 1 1 2 2 2 2 3 3 3 3 4 4 4 4 " + eol
        + "0000000000000000000000000000000000000000" + eol
        + "____ ____ ____ ____ " + eol)
    }
    "print grid.board include" in {
      grid.board should (include("0") and include("1") and include("2") and include("3") and include("4") and include("_"))
    }
  }
}
