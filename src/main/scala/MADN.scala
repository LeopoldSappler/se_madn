class MADN {
}

object MADN {
  @main def main(): Unit = {
    val tui = new TUI
    val grid = tui.start()
    println(grid.print())
  }
}