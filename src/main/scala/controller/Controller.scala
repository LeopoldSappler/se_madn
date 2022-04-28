package controller

import model.Grid
import util.Observable


class Controller(var grid:Grid) extends Observable{
  def createEmptyGrid(size: Int):Unit = {
    grid = new Grid(size)
    notifyObservers
  }
  @Override
}
