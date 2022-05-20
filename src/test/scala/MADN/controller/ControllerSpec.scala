package MADN.controller

import MADN.model.{Board, Grid}
import MADN.controller.Controller
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ControllerSpec extends AnyWordSpec with Matchers{
  val board = new Board(4)
  val controller = new Controller(board)

  "roll dice" in {
    controller.roll should (be >= 1 and be <= 6)
  }
}
