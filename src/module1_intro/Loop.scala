package module1_intro

object Loop extends App {

  var n=10
  var r = 1
  //while (n > 0) { r = r * n; n -= 1 }

  for (i <- 1 to n) r = r * i

  val s = "Hello"
  var sum = 0
  for (i <- 0 until s.length) // Last value for i is s.length - 1
    sum += s(i)

  var sum1 = 0
  for (ch <- "Hello") sum1 += ch

  // using guard
  for (i <- 1 to 10 if i % 2 == 0) print(i)

  // using yield (for comprehension)
  println(for (i <- 1 to 10) yield i % 3) // prints Vector(1, 2, 0, 1, 2, 0, 1, 2, 0, 1)

}
