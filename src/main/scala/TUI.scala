import scala.io.StdIn.readLine

class TUI {
  def start() : Grid =
    val playerCount: Int = readLine("Number of players: ").toInt
    val grid: Grid = Grid(playerCount)
    grid
}
