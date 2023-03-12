package Chapter2

import scala.math.random


trait ExpressionsNew {
  def printInsideTrait(): Unit = {
    println("Inside the trait ExpressionsNew")
  }
}

object Expressions extends ExpressionsNew {
  def main(args: Array[String]): Unit = {
    val value = (random() * 100).toInt
    println(s"value = $value")
    val updatedValue = {
      if (value % 2 == 0) {
        println("Disivsible by 2");
        value / 2
      }
      else {
        println("Not disivsible by 2");
        value * 2
      }
    }
    println(s"updatedValue = $updatedValue")


    val valueToCheck = 49
    val divisibleBy7 = if (valueToCheck % 7 == 0) true else false
    println(divisibleBy7)
    val divisibleCriteria = {
      if (valueToCheck % 2 == 0) 2
      else if (valueToCheck % 3 == 0) 3
      else if (valueToCheck % 5 == 0) 5
      else if (valueToCheck % 7 == 0) 7
      else 0
    }
    println(divisibleCriteria)

    val addOne = (x: Int) => x + 1
    println(addOne(1))

    printInsideTrait()
  }

  override def printInsideTrait(): Unit = {
    println("Inside Expressions class")
  }


}



