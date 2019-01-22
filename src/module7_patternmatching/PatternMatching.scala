package module7_patternmatching

object PatternMatching extends App {

  // pattern matching as a switch
  var sign = 0
  val ch: Char = '+'

  ch match {
    case '+' => sign = 1
    case '-' => sign = -1
    case _ => sign = 0
  }

  // using match as expression
  sign = ch match {
    case '+' => 1
    case '-' => -1
    case _ => 0
  }

  // guards
  var digit = 0
  ch match {
    case '+' => sign = 1
    case '-' => sign = -1
    case _ if Character.isDigit(ch) => digit = Character.digit(ch, 10)
    case _ => sign = 0
  }

  // variable in pattern
  val char = '1'
  char match {
    case '+' => sign = 1
    case '-' => sign = -1
    case ch => digit = Character.digit(ch, 10)
  }

  // variable can be used in guard:
  char match {
    case ch if Character.isDigit(ch) => digit = Character.digit(ch, 10)
    case _ => sign = 0
  }

  // type pattern
  // no isInstanceOf, no asInstanceOf
  val obj:Any = "15"
  val res = obj match {
    case x: Int => x
    case s: String => Integer.parseInt(s)
    case _: BigInt => Int.MaxValue
    case _ => 0
  }
  println(res)

  // matching Array
  // here we use extractor defined in Array - unapplySeq method
  val arr = Array(1,2)
  val res0 = arr match {
    case Array(0) => "0"
    case Array(x, y) => x + " " + y
    case Array(0, _*) => "0 ..."
    case _ => "something else"
  }
  println(res0) // 1 2

  // matching List
  val lst = List(1,2)
  val res1 = lst match {
    case 0 :: Nil => "0"
    case x :: y :: Nil => x + " " + y
    case 0 :: tail => "0 ..."
    case _ => "something else"
  }
  println(res1) // 1 2

  // matching tuple
  val grades = (4,5)
  val result = grades match {
    case (5,5) => "perfect!"
    case (5,4) | (4,5) => "very good"
    case (2,_) | (_,2) => "unsatisfactory"
    case _ => "ok"
  }
  println(result) // very good

  // regular expressions
  val pattern = "([0-9]+) ([a-z]+)".r
  var res3 = "99 bottles" match {
    case pattern(num, item) => s"we have $num of $item" // use interpolation
  }
  println(res3) // we have 99 of bottles





}
