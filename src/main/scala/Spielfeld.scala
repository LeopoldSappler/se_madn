object Spielfeld {
  def main(args: Array[String]): Unit = {
    print("o o - - O O A - - o o\n"
        + zeileA + zeileB + zeileC
        + "A O O O O d O O O O O\n"
        + "O a b c d - d c b a O\n"
        + "O O O O O d O O O O A\n"
        + zeileC + zeileB + zeileA
        + "o o - - A O O - - o o\n")
  }
  def zeileA = "o o - - O a O - - o o\n"
  def zeileB = "- - - - O b O - - - -\n"
  def zeileC = "- - - - O c O - - - -\n"
}