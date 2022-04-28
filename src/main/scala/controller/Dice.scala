package controller

import scala.util.Random

class Dice {
  val r = new Random()
  def roll(): Int ={
    r.nextInt(6) + 1
  }
}