val playerCount = 2

var boardStart: Array[Int] = init()
var boardPlay: Array[Int] = Array.fill[Int](40)(0)
var boardFinish: Array[Int] = Array.fill[Int](playerCount * 4)(0)

def init(): Array[Int] = {
  var array: Array[Int] = Array()
  for(i <- 1 to playerCount) {
    for (j <- 1 to 4) {
      array = array :+ i
    }
  }
  array
}

@main def main(): Unit = print(showBoard())

def showBoard(): String = {
  boardStart.mkString("(", ", ", ")") + "\n"
  + boardPlay.mkString("(", ", ", ")") + "\n"
  + boardFinish.mkString("(", ", ", ")")
}


