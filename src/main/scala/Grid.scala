class Grid(playerCount: Int) {
  var playFieldCount = 40
  val eol = sys.props("line.separator")

  def startFields(Player: Int = playerCount): String =
    var str = ""
    for (i <- 1 to Player) {
      for (_ <- 1 to 4) {
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
