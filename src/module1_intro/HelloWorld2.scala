package module1_intro

object HelloWorld2 extends App {
  println("Hello World")

  def gcdLoop(x: Long, y: Long): Long = {
    var a = x
    var b = y
    while (a != 0) {
      val tmp = a
      a = b % a
      b = tmp
    }
    b
  }

  def gcd(a: Long, b: Long): Long = {
    if (b == 0) a else gcd(b, a % b)
  }

  println(gcdLoop(15, 55))
  println(gcd(55, 15))
  println(s"are equal? ${gcdLoop(15, 55).toLong == gcd(55, 15).toLong}")
}
