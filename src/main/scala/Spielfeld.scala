object Spielfeld {
  def main(args: Array[String]): Unit = {
    print(zeigeSpielfeld())
  }
  def zeileA = "o o - - O a O - - o o\n"
  def zeileB = "- - - - O b O - - - -\n"
  def zeileC = "- - - - O c O - - - -\n"

  def zeigeSpielfeld(): String = {
    var stringBuilder = new StringBuilder()
    stringBuilder.append("o o - - O O A - - o o\n")
    stringBuilder.append(zeileA).append(zeileB).append(zeileC)
    stringBuilder.append("A O O O O d O O O O O\n")
    stringBuilder.append("O a b c d - d c b a O\n")
    stringBuilder.append("O O O O O d O O O O A\n")
    stringBuilder.append(zeileC).append(zeileB).append(zeileA)
    stringBuilder.append("o o - - A O O - - o o\n\n")
    stringBuilder.append("Legende: o - Figurenfeld, O - Lauffeld, (a,b,c,d) - Zielfelder, A - Startfeld")

    stringBuilder.toString()
  }
}

