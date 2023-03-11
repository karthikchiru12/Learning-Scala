package Chapter1

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

