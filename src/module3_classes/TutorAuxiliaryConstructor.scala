package module3_classes

import scala.annotation.tailrec

object TutorAuxiliaryConstructor extends App {

  // TODO create class Person with private fields name and age with default values
  // TODO create auxiliary constructors this(name) and this(name,age)
  class Person {
    private var name = ""
    private var age = 0

    def this(name: String) {
      this()
      this.name = name
    }

    def this(name: String, age: Int) {
      this(name)
      this.age = age
    }
  }

  // TODO create Person using constructor with no params, with name parameter
  // TODO and with name and age

  val p1 = new Person
  val p2 = new Person("Sting")
  val p3 = new Person("Sting", 42)


  class RationalNumber(n: Int, d: Int) {
    private val g = gcd(n, d)

    val numer = n / g
    val denom = d / g

    def this(n: Int) = this(n, 1)

    def add(that: RationalNumber): RationalNumber = {
      new RationalNumber(numer * that.denom + denom * that.numer, denom * that.denom)
    }

    override def toString: String = (numer + "/" + denom)

    @tailrec
    private def gcd(a: Int, b: Int): Int = {
      if (b == 0) a else gcd(b, a % b)
    }
  }

  val rationalNumber1 = new RationalNumber(7, 14)
  val rationalNumber2 = new RationalNumber(7, 3)

  println(rationalNumber1)
  println(rationalNumber2)
  println(rationalNumber1 add rationalNumber2)
}
