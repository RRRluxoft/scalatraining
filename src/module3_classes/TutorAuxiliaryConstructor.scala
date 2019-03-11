package module3_classes

import scala.annotation.tailrec
import scala.language.implicitConversions

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


  implicit def intToRational(x: Int): RationalNumber = new RationalNumber(x)

  class RationalNumber(n: Int, d: Int) {
    private val g = gcd(n, d)

    val numer = n / g
    val denom = d / g

    def this(n: Int) = this(n, 1)
    def this() = this(1)

//    implicit def intToRational(x: Int) = new RationalNumber(x)

    def add(that: RationalNumber): RationalNumber = {
      new RationalNumber(numer * that.denom + denom * that.numer, denom * that.denom)
    }

    def +(that: RationalNumber): RationalNumber = {
      new RationalNumber(numer * that.denom + denom * that.numer, denom * that.denom)
    }

    def +(i: Int): RationalNumber = {
      new RationalNumber(numer + i * denom, denom)
    }

    def *(that: RationalNumber): RationalNumber = {
      new RationalNumber(numer * that.numer, denom * that.denom)
    }

    def *(i: Int): RationalNumber = {
      new RationalNumber(numer * i, denom)
    }

    override def toString: String = (numer + "/" + denom)

    @tailrec
    private def gcd(a: Int, b: Int): Int = {
      if (b == 0) a else gcd(b, a % b)
    }
  }

  val rationalNumber1 = new RationalNumber(7, 14)
  val rationalNumber2 = new RationalNumber(7, 3)
  val rNumEmpty = new RationalNumber()

  println(rationalNumber1)
  println(rationalNumber2)
  println(rationalNumber1 add rationalNumber2)
  println(rationalNumber1 + rationalNumber2)

  println(rNumEmpty)

  println("implicit conversation")
  val r = new RationalNumber(2, 3)
  println(r * 2)
  println(2 * r)
}
