## Intro

**Scala** is an *object-oriented* programming language. It also supports functional programming paradigm, and not just features of FP. In scala everything is an object ranging from a function to a literal value. A file containing scala code will end with **.scala** or .**sc** extension. Scala runs on the **JVM** (Java Virtual Machine). Where a scala program is converted into bytecode and is run on the JVM. Scala is a **statically typed** progrmming language. And the most interesting thing about scala for me is that, you can compile your scala code into JavaScript using **Scala.js** and **Scala Native** to compile scala to native machine code without ever needing any kind of JVM or JavaScript runtimes. 

Apache Spark and Apache Kafka are written in scala.

The word scala is derived from the word scalable.

A hello world program in scala :

```
object MainObject
{
	def main(args: Array[String]) : Unit = 
	{
		print("Hello world")
	}
}
```

An **object** in scala is similar to **class**, but defines a sigleton instance that you can pass arround. **Unit** is a return type in scala and its actually same as **void** in other programming languages. In scala if you print a function returning a Unit type, then it prints **( )**.

## What is so cool in scala ?

- **Variables are immutable** : All the declared variables are immutable by default.
	```
	val firstName = "Chiranjeevi" // Immutable (like final in java)
	var lastName = "Karthik" //Mutable
	lastName = "Karthik1"
	```
	
	Any variable declared by the keyword **var** is a mutable variable, and any variable declared using the **val** keyword is an immutable variable.
	
- **Type Inference** : There is no need to explicitly mention the type of  variables or function return types. The compiler can automatically infer that using contextual information available.

```
object MainObject {
  def main(args: Array[String]): Unit = {
    println("Hello world")
    val firstName = "Chiranjeevi" // Immutable (like final in java)
    var lastName = "Karthik" //Mutable &  Compiler can infer that the value firstName is a string.
    println(firstName)
    println(lastName)

    println(checkOddOrEven(21))

  }

  def checkOddOrEven(x: Int): String = {
    if (x % 2 == 0) {
      "Even" // No need of explicit return statement
    }
    else {
      "Odd" // No need of explicit return statement
    }
  }
}
```

Now imagine the following fucntion :

```
def addOne(x: Int) = x +1
```

Here the compiler automatically infers the return type as Int.

*Note* : The function paramters are never inferenced by the compiler. Because of which the below code does not work.

```
def addOne(x) = x +1
```


- **Lazy Evaluation** : Let us say you want to open a connection with a mongo DB and execute some query. But is the connection need not be opened until a specified condition is met, then you dont need to open the connection at the start of the execution of the program. You can delya it.

You can use the **lazy** keyword which will evaluate the expressions only when they are required. **LazyList** is a lazy implementation of Linked List. 

```
val lazyList = LazyList.range(0,3)
println(lazyList)
lazyList.foreach(println)
```

The output of the above will be :
```
LazyList(<not computed>)
0
1
2
```

Unless the foreach method(bascially accessing it) is forced upon the lazyList nothing happens and the list is not computed. This saves a lot of un-necessary computations and improves performance of applications drastically.

- **Signleton Object** : An object is class that has exactly one instance. it is similar to lazy eval, in the sense that it is creeated lazily, only when it is referenced. An object is basically a singleton.

- **Companion Objects** : You can create a class and an object with same name. And the object is called as the companion object, which can access the private members of its companion. And similarly a class can access its companion objects private members.

```
case class Companion(name: String) {

  import Companion.prependString

  private val result: String = {
    if (name.length > 10) {
      prependString(name, "Hello")
    }
    else {
      prependString(name, "Welcome")
    }
  }
}

object Companion {
  def main(args: Array[String]): Unit = {
    val companion1 = new Companion("Chiranjeevi")
    println(companion1.result)

    val companion2 = new Companion("karthik")
    println(companion2.result)
  }

  private def prependString(name: String, toPrepend: String): String = toPrepend + " " + name
}
```

The **case** keyword bascially makes the class immutable. Later we can use this for **pattern match** various case classes.

The output of the above code :

```
Hello Chiranjeevi
Welcome karthik
```

- **String Interpolation** : String interpolation is similar to what we use in javascript.

```
let name = "Karthik"
console.log(`Hello, $name`);
```

In scala we prepend s to any string literal for allowing usage of variables inside that literal. And also you can evaluate any expressions wrapped inside **${expression}**. You can also use other interpolators such as **f** (*Which is similar to* **printf( )** ) and **raw** nterpolator wih no escaping.

```
val name : String = "Karthik"
println(s"Hello, $name")
println(s"2*7 = , ${2*7}")
```

- **Higher Order Functions** : HOF is a function that takes a function as an argument or teturns a function.

One simple example of this would be :

```
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
```

The above program will give the below output :

```
Divisble
Not divisble
```

There are even more cool stuff to look at like : Variances, Traits, Inner classes... etc

*References* :
1. https://docs.scala-lang.org/tour/tour-of-scala.html
2. https://www.javatpoint.com/features-of-scala