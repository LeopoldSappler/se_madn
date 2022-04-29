package MADN.controller

import MADN.model.Grid
import MADN.controller.Controller
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ControllerSpec extends AnyWordSpec with Matchers{
  val grid = new Grid(4)
  val controller = new Controller(grid)

  "roll dice" in {
    controller.rollDice should (be >= 1 and be <= 6)
  }
}
