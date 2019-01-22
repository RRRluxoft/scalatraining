package module8_generics

object Variance extends App {
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
  //makeFriends(p) // error: p is pair of Students, not Person

  // solution: use Type variance Pair[+T]
  class Pair2[+T](val first: T, val second: T)
  val p2 = new Pair2(s1,s2)
  // Since Student is a subtype of Person,
  // a Pair[Student] is now a subtype of Pair[Person]
  def makeFriends2(p: Pair2[Person]) = {
    p.first.friend = p.second
    p.second.friend = p.first
  }
  makeFriends2(p2)

  // class Pair3[+T](var first: T, var second: T) // Error
  // covariant type T occurs in contravariant
  // position in type T of value first_=, second_=

/*
  // covariant and contravariant position
  class Creature[+T](val name:T)
  class Human[+T](_name:String) extends Creature(_name)
  class Person2[+T,-R](val _name: T, _friend:R) {
    private[this] var friend:R = _friend
    def name: T = _name // this position is contravariant
    def setFriend(_friend:R) = friend = _friend // this position is covariant
  }
  // Parameters can be contravariant or invariant
  // Return type can be contravariant or invariant
  val sb:StringBuilder = new StringBuilder("Peter")
  val c = new Human("Bob")
  val person2 = new Person2(sb, c)
  val o:Object = person2.name
  val dog = new Creature("Dog")
  //person2.setFriend(dog)
  //val s: String = person2.getName

  //println(  ) // Peter

*/
  /*
  def makeFriends3(p: Pair3[Student]) = {
    p.first.friend = p.second
    p.second.friend = p.first
  }
  val person1 = new Person("Joseph")
  val person2 = new Person("Helen")
  val pair = new Pair3(person1, person2)
  makeFriends3(pair)
  def getFriends(p) = (p.first,p.second)
  println( getFriends(pair) )
  */
}

// Contravariance example from
// https://twitter.github.io/scala_school/type-basics.html