package module1_intro

object TutorLoop extends App {

  var n=10
  var r = 1
  //while (n > 0) { r = r * n; n -= 1 }

  // TODO use for to calculate n! (use r=r*i)
  // TODO syntax: for (i <- range) code
  for (i <- r to n) r = r * 1

  val s = "Hello"
  var sum = 0
  // TODO use for..until to calculate the sum of all character codes in s
  for (i <- 0 until s.length) yield sum += s(i)

  var sum1 = 0
  // TODO use for(ch <- s) to calculate the sum of all character codes in s
  for (i <- s) yield sum += i

  // using guard
  // TODO use syntax for (i <- range if guard_expression) to print
  // TODO all even values in range 1..10 (should print 2468)
for (x <- 0 to 10000 if (x % 17 == 1)) println(x)

  // using yield (for comprehension)
  // TODO use for..yield to print reminder of division by 3
  // TODO for values in range 1..10
  // TODO should print Vector(1, 2, 0, 1, 2, 0, 1, 2, 0, 1)
  val result = (1 to 10).map(_ % 3)
  val result2 = for (x <- 1 to 10) yield x % 3
  println(s"Result ${result}")
  println(s"Result 2 ${result2}")

}
