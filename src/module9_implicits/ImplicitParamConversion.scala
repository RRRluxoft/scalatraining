package module9_implicits

object ImplicitParamConversion extends App {

  // this function doesn't work: < operator is not defined for any type
  //def smaller[T](a: T, b: T) = if (a < b) a else b // error

  // we can supply a conversion function:

  def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]) =
    if (order(a) < b) a else b
  // Ordered trait has < operator, so order(a) now has < defined

  // Predef object defines implicit values T=>Ordered[T] for many types
  // so you can use it:
  smaller(40,2)
  smaller("Hello", "World")

  // also we can define our custom implementation
  class Person(val name:String, val age:Int)
  val p1 = new Person("John", 20)
  val p2 = new Person("George", 30)
  println( smaller(p1,p2)(p=>new Ordered[Person] {
    override def compare(that:Person) = p.age.compare(that.age)
  }).name ) // John

  // also we can provide conversion as implicit function
  implicit def personOrdered(p:Person) = new Ordered[Person] {
    override def compare(that:Person) = p.age.compare(that.age)
  }
  // now we can call smaller for persons:
  println( smaller(p1, p2).name ) // John

  // let's look again to function smaller
  def smaller2[T](a: T, b: T)(implicit order: T => Ordered[T]) =
    if (order(a) < b) a else b
  // implicit order: T => Ordered[T] is actually not only implicit parameter
  // it is implicit conversion, so we can use it as already converted
  def smaller3[T](a: T, b: T)(implicit order: T => Ordered[T]) =
    if (a < b) a else b
  // a was converted implicitly to Ordered[T], so we can use <



}
