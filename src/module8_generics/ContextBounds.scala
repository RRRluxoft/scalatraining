package module8_generics

object ContextBounds extends App {
  // context bound
  // it's improved view bound introduces in Scala 2.8.0

  // Context bound has the form T : M, where M is another generic type
  // It is used to declare that for some type A,
  // there is an implicit value of type B[A] available

  trait Maxable[T] {
    def max(a:T, b:T):T
  }
  class Person(val name: String, val age:Int)

  implicit object Person extends Maxable[Person] {
    def max(x:Person,y:Person):Person = if (x.age>y.age) x else y
  }
  val person1 = new Person("John", 20)
  val person2 = new Person("George", 30)
  println( Person.max(person1, person2).name ) // George

  class Pair[T : Maxable](val first:T, val second:T) {
    def max(implicit maxable: Maxable[T]) =
      maxable.max(first, second)
  }
  val pair = new Pair(person1, person2)
  println( pair.max.name )

  // example with Ordering trait (Ordering is already implemented in API)
  class Pair2[T : Ordering](val first: T, val second: T) {
    def smaller(implicit ord: Ordering[T]) =
      if (ord.compare(first, second) < 0) first else second
  }
  val p = new Pair2(2,3) // type T is Int
  p.smaller // finds Ordering[Int] and injects it to smaller

}
