class MADN {
  var playerCount = 4
  var playFieldCount = 40
  private val eol = sys.props("line.separator")

  def startFields(Player: Int = playerCount): String =
    var str = ""
    for (i <- 1 to playerCount) {
      for (j <- 1 to 4) {
        str = str + i + " "
      }
    }
    str + eol

  def playFields(Field: Int = playFieldCount): String =
    ("0" * Field) + eol

  def finishFields(Player: Int = playerCount): String =
    (("_" * 4) + " ") * Player + eol

  val board: String = startFields() + playFields() + finishFields()

  def print(): String = {
    board
  }
}

object MADN {
  @main def main(): Unit = {
    val madn = new MADN()
    println(madn.print())
  }
}