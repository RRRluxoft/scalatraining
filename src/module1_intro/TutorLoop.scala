package module1_intro

object TutorLoop extends App {

  var n=10
  var r = 1
  //while (n > 0) { r = r * n; n -= 1 }

  // TODO use for to calculate n! (use r=r*i)
  // TODO syntax: for (i <- range) code

  val s = "Hello"
  var sum = 0
  // TODO use for..until to calculate the sum of all character codes in s

  var sum1 = 0
  // TODO use for(ch <- s) to calculate the sum of all character codes in s

  // using guard
  // TODO use syntax for (i <- range if guard_expression) to print
  // TODO all even values in range 1..10 (should print 2468)

  // using yield (for comprehension)
  // TODO use for..yield to print reminder of division by 3
  // TODO for values in range 1..10
  // TODO should print Vector(1, 2, 0, 1, 2, 0, 1, 2, 0, 1)

}
