package Chapter1

object HOC {

  def main(args: Array[String]): Unit = {
    isDivisible(checkDivisibility(18, 9))
    isDivisible(checkDivisibility(17, 9))
  }

  def isDivisible(value: Boolean): Unit = {
    if (value) {
      println("Divisble")
    }
    else {
      println("Not divisble")
    }
  }

  def checkDivisibility(value: Int, denominator: Int): Boolean = {
    if (value % denominator == 0) {
      true
    }
    else {
      false
    }
  }
}
