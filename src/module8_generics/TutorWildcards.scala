package module8_generics

object TutorWildcards extends App {

  // In Java, all generic types are invariant.
  // However, you can vary the types where you use them, using wildcards
  // ex: void makeFriends(List<? extends Person> people)

  class Pair[T](val first: T, val second: T)

  class Person(val name: String) {
    var friend: Person = null
  }
  class Student(_name:String) extends Person(_name)
  val s1 = new Student("John")
  val s2 = new Student("Mary")
  val p = new Pair(s1,s2)

  def makeFriends(p: Pair[Person]) = {
    p.first.friend = p.second
    p.second.friend = p.first
  }

  // In Scala, you could use type variance: Pair[+T]
  // then you can use def makeFriends(p: Pair[Person])
  // and it will work with Student as well

  // however, wildcards offers another way to fix
  // syntax: Type[_ <: T]
  // TODO change makeFriends with use of wildcards

  // TODO uncomment this
  // makeFriends(p)

}
