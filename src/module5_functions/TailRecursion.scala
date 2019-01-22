package module5_functions

import scala.annotation.tailrec

object TailRecursion extends App {

  def sum(xs: Seq[Int]): BigInt =
    if (xs.isEmpty) 0 else xs.head + sum(xs.tail)
  // This method cannot be optimized because the last step of the
  // computation is addition, not the recursive call.

  // But a slight transformation can be optimized
  def sum2(xs: Seq[Int], partial: BigInt): BigInt =
    if (xs.isEmpty) partial else sum2(xs.tail, xs.head + partial)
  // call this method as sum2(xs, 0)

  // Since the last step of the computation is a recursive call
  // to the same method, it can be transformed into a loop
  // to the top of the method. The Scala compiler automatically
  // applies the “tail recursion” optimization.
  sum(1 to 1000000)  // stack overflow
  sum2(1 to 1000000, 0) // 500000500000

  // @tailrec checks if function contains tail recursion and optimize it
  @tailrec
  def sum3(xs: Seq[Int], partial: BigInt): BigInt =
    if (xs.isEmpty) partial
    else sum3(xs.tail, xs.head + partial)
}
