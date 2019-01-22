package module8_generics

object TutorVariance extends App {
  // Problem
  class Person(val name:String) {
    var friend: Person = null
  }
  class Student(_name:String) extends Person(_name)
  class Pair[T](val first: T, val second: T)
  def makeFriends(p: Pair[Person]) = {
    p.first.friend = p.second
    p.second.friend = p.first
  }
  val s1 = new Student("John")
  val s2 = new Student("Mary")
  val p = new Pair(s1,s2)
  // TODO uncomment this
  //makeFriends(p) // error: p is pair of Students, not Person

  // TODO use Type variance Pair[+T] to allow pair to be
  // TODO pair of Students, not only Person

}