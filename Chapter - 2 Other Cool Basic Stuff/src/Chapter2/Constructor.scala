package Chapter2

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
  //Throws error
  //  private class Child(name: String) extends Parent
  private class Child(val name: String) extends Parent

  private val child: Child = new Child("Karthik")
  println(child.name)

}
