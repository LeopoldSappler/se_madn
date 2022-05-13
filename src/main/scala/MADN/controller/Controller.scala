package MADN.controller

import MADN.model.Grid
import MADN.util.Observable

import scala.util.Random

class Controller(var grid:Grid) extends Observable{
    val r = new Random()

    def rollDice: Int =
        r.nextInt(6) + 1

    //def put(player: )

    var i = 0
    def actualPlayer(): Int =
        var Player = grid.startField(i)
        i + 4
        Player

    notifyObservers()

    def gridToString: String = grid.toString

}
