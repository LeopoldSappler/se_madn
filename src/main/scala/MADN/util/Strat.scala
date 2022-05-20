package MADN.util

case class Strat(val strategyVal: String) {
  object context {
    var strategy = if (strategyVal.equals("r")) strategyRand else if (strategyVal.equals("a")) strategyAdvanced

    def strategyRand = {
      println("Strategy: Random")
    }

    def strategyAdvanced = {
      println("Strategy: Advanced")
    }
  }

  context.strategy
}
