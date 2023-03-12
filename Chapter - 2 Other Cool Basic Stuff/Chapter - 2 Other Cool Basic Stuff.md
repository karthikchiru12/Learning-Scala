## Intro

In scala, every expression or codeblock is reduced to a value. Imagine the below code :

```
import scala.math.random

object Expressions {
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
  }
}
```

In the above code the code block **val updatedValue = {...}** finally evaluates a signle value, *which is the last expression of the codeblock* . i.e Its either **value/2** or **value * 2**. And the type of the expression is automatically evaluated by the compiler.

The output of the above program is :

```
value = 29
Not disivsible by 2
updatedValue = 58
```

## Thinking In Recursion

More and more we move into using the functional paradigm to code our business logic, the less we need to use loops. Instead we use recursion.

Let us say I want to write a program to find factorial of a number :

```
object Recursion {
  def main(args: Array[String]): Unit = {
    val result = factorial(5)
    println(result)

  }

  private def factorial(x: Int) {
    if (x <= 1) 1
    else x * factorial(x - 1)
  }
}
```

But the following program will through the below error :

```
overloaded method * with alternatives:
  (x: Double)Double <and>
  (x: Float)Float <and>
  (x: Long)Long <and>
  (x: Int)Int <and>
  (x: Char)Int <and>
  (x: Short)Int <and>
  (x: Byte)Int
 cannot be applied to (Unit)
    else x * factorial(x - 1)
```

Because the compiler cannot infer the return type. Whenever we are using recursive functions, we have to explicitly specify the return type of the function.

So to fix the above, we metnion the return type explicitly in the factorial function.

```
. . .
private def factorial(x: Int) : Int = {
    if (x <= 1) 1
    else x * factorial(x - 1)
  }
. . .
```

## Why conditional statements in Scala are cool ?

In the above code, we have used a if-else block inside the factorial function and it is relatively more readable than in other languages.

You can also have a chain of if-else-if statements which will finally resolve to a value. 

  ```
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
```

And the output of the below program would be :

```
true
7
```

## Anonymous functions

You can create an anonymous function like below :

 ```
val addOne = (x : Int) => x + 1
    println(addOne(1))
```


## Traits

Traits are abstract data types, which contain its members. In scala, a class can only inherit one other class, But can inherit one or more traits. Traits are similar to interfaces in java.

You can define a trait like below :
```
. . . 
trait ExpressionsNew {
  def printInsideTrait(): Unit = {
    println("Inside the trait ExpressionsNew")
  }
}

object Expressions extends ExpressionsNew {
. . .
``` 

And then you can override the **printInsideTrait()** method inside the object.

```
. . .
  override def printInsideTrait(): Unit = {
    println("Inside Expressions class")
   }
  }
```

And when you call the function inside the main method, from object Expression, *Inside Expressions class* is printed instead of "Inside the trait ExpressionsNew".

## Class constructor

If the below code is executed :

```
object Constructor {
  def main(args: Array[String]): Unit = {

  }

  class Parent {
    val selfFunctioning: Boolean = true


    def earn = {
      println("Earning")
    }
  }

  // Inheritance
  private class Child(name: String) extends Parent

  private val child: Child = new Child("Karthik")
  println(child.name)
}

```

Then the compiler throws an error :

```
value name is not a member of Parent.this.Child println(child.name)
```

This is because the constructer arguments are not readily available as the class member of Child. 

In order to make them available as class fields, we need to modify the constructers argument by appending it with **val**.

i.e 
```
private class Child(val name: String) extends Parent
```

And one more cool thing in scala is that, you can actually have a class within another class.
