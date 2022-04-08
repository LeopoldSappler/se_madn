import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

class MADNSpec extends AnyWordSpec{
  val madn = new MADN
  private val eol = sys.props("line.separator")

  "playerCount" in {
    madn.playerCount should be (4)
  }

  "playerField" in {
    madn.playFieldCount should be (40)
  }

  "eol" in {
    madn.eol should be (sys.props("line.separator"))
  }

  "madn" should {
    "print 4 start fields for every player from playerCount" in {
      madn.playerCount = 1
      madn.startFields() should be ("1 1 1 1 " + eol)
      madn.playerCount = 4
      madn.startFields(4) should be ("1 1 1 1 2 2 2 2 3 3 3 3 4 4 4 4 " + eol)
    }

    "print one playing field for every value from playFieldCount" in {
      madn.playFieldCount = 1
      madn.playFields() should be ("0" + eol)
      madn.playFieldCount = 40
      madn.playFields() should be ("0000000000000000000000000000000000000000" + eol)
    }

    "print 4 finish fields for every player from playerCount" in {
      madn.playerCount = 1
      madn.finishFields() should be ("____ " + eol)
      madn.playerCount = 4
      madn.finishFields() should be ("____ ____ ____ ____ " + eol)
    }

    "print the board" in {
      madn.print() should be ("1 1 1 1 2 2 2 2 3 3 3 3 4 4 4 4 " + eol
        + "0000000000000000000000000000000000000000" + eol
        + "____ ____ ____ ____ " + eol)
    }
    "print madn.board include" in {
      madn.board should (include("0") and include("1") and include("2") and include("3") and include("4") and include("_"))
    }
  }
}
