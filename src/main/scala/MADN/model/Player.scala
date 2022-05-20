package MADN.model

case class Player(val id: Int, val startPos: Int, var homeCount: Int) {

}

case class PlayerCreator() {
  var plCount = 0

  def build(): Player =
    val plCountTemp = plCount
    plCount += 1
    Player(plCountTemp + 1, plCountTemp * 10, 4)
}
