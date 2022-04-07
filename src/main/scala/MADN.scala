class MADN {
  val playerCount = 4
  val playFieldCount = 40

  def startFields(Player: Int = playerCount): String =
    var str = ""
    for (i <- 1 to playerCount) {
      for (j <- 1 to 4) {
        str = str + i + " "
      }
    }
    str + "\n"

  def playFields(Field: Int = playFieldCount): String =
    ("0" * Field) + "\n"

  def finishFields(Player: Int = playerCount): String =
    (("_" * 4) + " ") * Player + "\n"

  val board: String = startFields() + playFields() + finishFields()

  def print(): String = {
    board
  }
}

object MADN {
  @main def main(): Unit = {
    val MADN = new MADN();
    println(MADN.print())
  }
}