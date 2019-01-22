package module1_intro

object TutorAssignments extends App {

  class Holder {
    println("Holder")
  }

  // TODO define 2 objects h1 and h2 in the same line by using ,
  val h1, h2 = new Holder()

  //val a=b=1 -not working in scala
  val a = 1 // a type is Unit

  // make 2 assignments
  // TODO make 2 assignments in the same like with (v1,v2)=(value1, value2)
  // TODO assign y to 1 and z to 2
  val (v1, v2) = (6, 7)

  // returning 2 values
  // TODO write function minMax which takes 2 parameters x and y of type Int
  // TODO and returns tuple (Int,Int)
  def minMax(x: Int, y: Int): (Int, Int) = if (x >= y) (y, x) else (x, y)

  val (min, max) = minMax(5, 10) // TODO uncomment and print the result

  val str = "balll"
  val b = str contains "a"

  def isCont(inp: String)(implicit f: String => Boolean): Boolean = {
//    inp contains(f)
    f(inp)
  }

  val res = isCont("input")(_ contains("i"))
  println(res)

}