package MADN.controller

class Controller(var grid:Grid) extends Observable{
  def createEmptyGrid(size: Int):Unit =
    grid = new Grid(size)
    notifyObservers
}
