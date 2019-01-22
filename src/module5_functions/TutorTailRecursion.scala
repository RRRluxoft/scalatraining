package module5_functions

object TutorTailRecursion extends App {

  def sum(xs: Seq[Int]): BigInt =
    if (xs.isEmpty) 0 else xs.head + sum(xs.tail)
  // This method cannot be optimized because the last step of the
  // computation is addition, not the recursive call.

  // TODO create method sum2 which will evaluate the sum of Seq[Int]
  // TODO using tail recursion
  // TODO mark it with @tailrec annotation

}
