package module1_intro

object Types extends App {
  //var i // error: variable must be initialized in object

  var i:Int = 1
  //i++ // error: increment with ++ is illegal in Scala
  i+=1 // that's only way to increment
  i.+=(1) // actually that's call of += method in Int class
  var b:Byte = 22
  //b+=1 // error: not allowed - any operation returns Int
  println(b)
  var d = 0.1
  d+=i
  println(d)
  println(Int.MaxValue+10) // -2147483639
  var l:Long = 100;
  l+=i
  println(l)

  var bool:Boolean = true
  bool=i>1

  // Any
  var a:Any = 1
  a = 1.1
  a = true
  a = "Hello"
  a=null

  //var av:AnyVal = "Hi" // error: String is reference, needs AnyRef
  var arc:AnyRef = "Hi" // correct
  //var ar:AnyRef = 1 // error: 1 is a value, needs AnyVal
  var avc:AnyVal = 1 // correct

  // String
  val c="Hello"(1) // implicit apply() function executed
  println(c) // e
  val s = "Hello World"
  val contains = s contains "o" // true
  s indexOf "o" // 4

  // Range type
  val range = 1 to 10 // yields Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val range1 =1.to(10) // the same
}
