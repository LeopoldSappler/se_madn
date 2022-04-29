package MADN.controller

import MADN.model.Grid
import MADN.util.Observable

import scala.util.Random

class Controller(var grid:Grid) extends Observable{
    val r = new Random()

    def rollDice: Int =
        r.nextInt(6) + 1

    def gridToString: String = grid.toString
}
