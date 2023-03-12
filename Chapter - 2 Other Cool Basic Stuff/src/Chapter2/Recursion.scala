package Chapter2

object Recursion {
  def main(args: Array[String]): Unit = {
    val result = factorial(5)
    println(result)

  }

  private def factorial(x: Int): Int = {
    if (x <= 1) 1
    else x * factorial(x - 1)
  }
}