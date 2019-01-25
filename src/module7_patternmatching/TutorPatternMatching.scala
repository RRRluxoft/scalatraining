package module7_patternmatching

object TutorPatternMatching extends App {

  // pattern matching as a switch
  var sign = 0
  val ch: Char = '+'

  // TODO use pattern matching to set sign to 1 in case if ch is '+',
  // TODO to -1 if ch is '-' and to 0 in all other cases
  ch match {
    case '+' => sign = 1
    case '-' => sign = -1
    case _ => 0
  }

  // using match as expression
  // TODO assign result of match directly to sign variable,
  // TODO like sign = ch match {...}
  sign = ch match {
    case '-' => -1
    case '+' => 1
    case _ => 0
  }

  // guards
  // TODO use pattern matching to find if rank of developer
  // TODO it should be "junior" if developer is younger than 30,
  // TODO "middle" if he's 30, and "senior" if he's older
  // TODO in case if it is digit, set digit to Character.digit(ch, 10)
  val age = 30
  val rank = age match {
    case _ if age < 30 => "junior"
    case _ if age == 30 => "middle"
    case _ if age > 30 => "senior"
    case _ => "undefined"
  }

  println(s"Developer is $age years old and he's $rank")
  // should print "Developer is 30 years old and he's middle"

  // variable in pattern
  val char = '1'
  var digit = 0
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
  // TODO use pattern matching for obj;
  // TODO it should set res to number if it was Int,
  // TODO set to Integer.parseInt(obj) if it was String,
  // TODO set res to Int.MaxValue if it was BigInt,
  // TODO and set to 0 otherwise

  val res = obj match {
    case n: Int => n
    case s:String => Integer.parseInt(s)
    case _: BigInt => Int.MinValue
    case _ => 0
  }
  println(res) // should print 15

  // matching Array
  // here we use extractor defined in Array - unapplySeq method
  val arr = Array(1,2)
  // TODO use pattern matching for arr to set res0
  // TODO set to "0" if Array has 1 element 0
  // TODO set to x+" "+y if Array has 2 elements x and y
  // TODO set to "0 ..." in case if Array has 0 as first element
  // TODO and more than 1 of other elements
  // TODO otherwise, set to "something else"
  val res0 = arr match {
    case Array(0) => "0"
    case Array(x ,y) => x + " " + y
    case Array(0, _*) => "0 ..."
    case _ => "smth else"
  }
  println(res0) // should print "1 2"

  // matching List
  val lst = List(1,2)
  // TODO use pattern matching for lst to set res1
  // TODO set to "0" if List has 1 element 0
  // TODO set to x+" "+y if List has 2 elements x and y
  // TODO set to "0 ..." in case if List has 0 as first element
  // TODO and more than 1 of other elements
  // TODO otherwise, set to "something else"
  val res1 = lst match {
    case 0 :: Nil => "0"
    case a :: b :: Nil => a + " " + b
    case 0 :: tail => "0 ..."
    case _ => "something else"
  }
  println(res1) // should print "1 2"

  // matching tuple
  val grades = (4,5)
  // TODO should set result to "perfect" if grades are 5 and 5
  // TODO to "very good" if grades are 5 and 4
  // TODO to "unsatisfactory" if any grade is 2
  // TODO and "ok" otherwise
  val result = grades match {
    case (5 , 5) => "perfect"
    case (4 , 5) | (4, 5) => "very good"
    case (2 , _) | (_, 2) => "unsatisfactory"
    case _ => "ok"
  }
  println(result) // should be "very good"

  // regular expressions
  val pattern = "([0-9]+) ([a-z]+)".r
  // TODO should match "99 bottles" to pattern(num, item)
  // TODO and print result like "we have 99 of bottles"
  // TODO syntax: case pattern(num, item)
  val res3 = "99 bottles" match {
    case pattern(n, i) => s"we have ${n} of ${i}"
  }

  println(res3)

}
