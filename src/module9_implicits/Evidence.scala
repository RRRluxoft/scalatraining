package module9_implicits

object Evidence extends App {

  // Type constraints give you another way of restricting types.
  // T =:= U  test if T equals U
  // T <:< U  test if T is a subtype of U

  case class Foo[A](a: A) {
    // 'A' can be substituted with any type
    // getStringLength can only be used if this is a Foo[String]
    def getStringLength(implicit evidence: A =:= String) = a.length
  }

  Foo("blah").getStringLength // 4
  //Foo(123).getStringLength // error: cannot prove that Int =:= String

  // why to use Evidence?

  class Pair0[T](val first: T, val second: T)(implicit ev: T <:< Comparable[T])
  // here there's no advantage over type bound class Pair[T <: Comparable[T]]

  // with evidence we can bound only for method, not the whole class
  class Pair[T](val first: T, val second: T) {
    def younger(implicit ev: T <:< Person) =
      if (first.age < second.age) first else second
  }
  // You can create a Pair of any type, however method younger
  // can be used only if we have a Pair of Person or its descendants
  // Otherwise will get an error if you invoke the younger method.

  class Person(val name:String, val age:Int)
  val p1 = new Person("John", 20)
  val p2 = new Person("George", 30)
  val pair = new Pair(p1,p2)
  println( pair.younger.name ) // John
}
// http://stackoverflow.com/questions/3427345/what-do-and-mean-in-scala-2-8-and-where-are-they-documented