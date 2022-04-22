@main def main(): Unit =
  println("Mensch ärgere dich nicht")
  println("------------------------")
  val tui = new TUI
  val grid = tui.start()
  println(grid.print())
