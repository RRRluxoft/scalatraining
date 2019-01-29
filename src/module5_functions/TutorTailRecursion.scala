package module5_functions

object TutorTailRecursion extends App {

  def sum(xs: Seq[Int]): BigInt =
    if (xs.isEmpty) 0 else xs.head + sum(xs.tail)
  // This method cannot be optimized because the last step of the
  // computation is addition, not the recursive call.

  // TODO create method sum2 which will evaluate the sum of Seq[Int]
  // TODO using tail recursion
  // TODO mark it with @tailrec annotation

  def sum3(xs: Seq[Int], r: BigInt): BigInt =
    if (xs.isEmpty) r else sum3(xs.tail, xs.head + r)

  def sum3_1(xs: Seq[Int], r: BigInt): BigInt  = {
    var r1 = r
    var xs1 = xs
    while(xs1.nonEmpty) {
      r1 += xs1.head
      xs1 = xs1.tail
    }
    r1
  }

  val test = sum3((1 to 1000000).toList, 0)
  println(test)

}
