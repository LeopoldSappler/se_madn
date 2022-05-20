package MADN.controller

import MADN.model.{Board, Player, PlayerCreator}
import MADN.util.Observable

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine
import scala.util.Random

case class Controller(var board: Board) extends Observable {

  val r = new Random()
  val playerCreator: PlayerCreator = new PlayerCreator
  val players: Vector[Player] = Vector.fill(4)(playerCreator.build())

  def processMove(diceValue: Int, player: Player): Unit = {
    this.board = process(diceValue, player)
  }

  def process(diceValue: Int, player: Player): Board = {
    if (diceValue == 6) {
      val figuresList = getFigures(player)
      if (figuresList.isEmpty) {
        println("Keine Figur im Spielfeld + Figur im Home -> Nochmal wuerfeln und aus Startfeld ziehen.")
        board.copy(board.playerCount, moveStart(player), board.finishFields)
      } else {
        println("Willst du eine Figur im Spielfeld oder eine neue Figur ziehen? \"start\" oder \"spiel\" ... ")
        readLine() match
          case "start" =>
            board.copy(board.playerCount, moveStart(player), board.finishFields)
          case "spiel" =>
            println("Figuren im Spiel bei Feld: ")
            for (e <- figuresList)
              println("Figur bei Feld " + e)
            println("Waehle eine Figur von 1 bis " + figuresList.size)
            val index = readLine().toInt
            board.copy(board.playerCount, move(figuresList(index), figuresList(index) + 6, player), board.finishFields)
      }
    } else {
      val figuresList = getFigures(player)
      if (figuresList.nonEmpty) {
        println("Figuren im Spiel bei Feld: ")
        for (e <- figuresList)
          println("Figur bei Feld " + e)
        println("Waehle eine Figur von 0 bis " + (figuresList.size - 1))
        val index = readLine().toInt
        board.copy(board.playerCount, move(figuresList(index), figuresList(index) + diceValue, player), board.finishFields)
      } else {
        println("Keine Figuren im Spielfeld -> Kein Spielzug moeglich!")
        this.board
      }
    }
  }

  def move(fromIndex: Int, toIndex: Int, player: Player): Vector[Int] = {
    board.put(fromIndex, toIndex, player)
  }

  def moveStart(player: Player): Vector[Int] = {
    val newDiceValue = roll
    println(newDiceValue)
    player.homeCount -= 1
    board.putStart(player.startPos + newDiceValue, player)
  }

  def getFigures(player: Player): List[Int] = {
    val figures = ListBuffer[Int]()
    for (i <- board.playFields.indices) {
      if (board.playFields(i) == player.id) {
        figures += i
      }
    }
    figures.toList
  }

  def roll: Int = {
    r.nextInt(6) + 1
  }

  override def toString: String = board.toString
}
