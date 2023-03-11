package Chapter1

object Basics {
  def main(args: Array[String]): Unit = {

    val lazyList = LazyList.range(0, 3)
    println(lazyList)
    lazyList.foreach(println)
    println("Hello world")
    val firstName = "Chiranjeevi" // Immutable (like final in java)
    var lastName = "Karthik" //Mutable
    lastName = "karthik1"
    println(firstName)
    println(lastName)

    println(s"Hello, $lastName")
    println(s"2*7 = , ${2*7}")

    println(checkOddOrEven(21))
    println(addOne(2))
    println(addTwo(2))

  }

  def checkOddOrEven(x: Int): String = {
    if (x % 2 == 0) {
      "Even"
    }
    else {
      "Odd"
    }
  }

  def addOne(x: Int) = x + 1

  def addTwo(x: Int): Int = {
    x + 2
  }
}


