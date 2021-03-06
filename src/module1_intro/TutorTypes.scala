package module1_intro

object TutorTypes extends App {
  //var i // error: variable must be initialized in object

  var i:Int = 1
  //i++ // error: increment with ++ is illegal in Scala
  // TODO use += to increment i value
  // TODO use function call syntax to increment value, like i.+=
  i.+=(1)

  var b:Byte = 22
  //b+=1 // error: not allowed - any operation returns Int
  println(b)

  var d = 0.1
  d+=i
  println(d)
  println(Int.MaxValue+10) // -2147483639
  var l:Long = 100
  l+=i
  println(l)

  // TODO define bool to boolean, set it to expression i>1

  // Any
  // TODO define variable a as Any
  /* TODO uncomment this
  a = 1.1
  a = true
  a = "Hello"
  a=null
  */
  var a: Any = 1.1
  a = true
  a = "Hello"
  a=null

  //var av:AnyVal = "Hi" // error: String is reference, needs AnyRef
  // TODO define av as AnyRef so that it can be set to String
  var av:AnyRef = "Hi"

  //var ar:AnyRef = 1 // error: 1 is a value, needs AnyVal
  // TODO define avc as AnyVal so that it can be set to value
  var ar:AnyVal = 1

  // String
  // TODO use implicit apply to get first letter in "Hello"
  // println(c) // should print H
  val c = "Hello"
  println(s"Hello ${c(0)}")

  val s = "Hello World"
  // TODO use function contains to check if "o" is in the string
  // TODO use function indexOf to find position of "o"

  // Range type
  // TODO define range as a range of values from 1 to 10, print it
  var range= 1 to 100
  println(s"Range ${range.filter(_ % 17 == 0).foreach(e => print(s"e-> ${e}; "))}")

  val  sum = range.fold(0)(_+_)
  println(s"Sum is ${sum.##}")
}
