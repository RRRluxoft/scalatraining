package module2_arrays

import java.util

object Maps extends App {

  // creates an immutable Map[String, Int]
  val scores1 = Map("Alice" -> 5, "John" -> 3, "Paul" -> 4)

  // that's the same as creating the Map using pairs (tuples)
  val scores2 = Map(("Alice", 10), ("Bob", 3), ("Cindy", 8))

  // creates a mutable Map[String, Int]
  val scoresMutable = scala.collection.mutable.Map(
    "Alice" -> 5, "John" -> 3, "Paul" -> 4)

  // creates an empty mutable Map[String,Int]
  val scores4 = new scala.collection.mutable.HashMap[String, Int]

  // accessing Map element
  val aliceScore = scores1("Alice")
  // if key is not found, throws NoSuchElementException

  // contains
  val bobsScore = if (scores1.contains("Bob")) scores1("Bob") else 0

  // short variant
  val bobsScore1 = scores1.getOrElse("Bob", 0)

  // get() returns Option with values Some(3) or None
  val bobsScoreOption = scores1.get("Bob")

  // returns value or 0
  val bobsScore2 = bobsScoreOption.getOrElse(0)

  // returns value or throws NoSuchElementException
  bobsScoreOption.get

  // updating immutable map
  //scores1("Bob") = 5 // error - scores1 is immutable

  scoresMutable("Bob") = 5 // updates Bob's grade
  scoresMutable("George") = 4 // adds new value to mutable map

  //scores1 += ("Bob" -> 10, "Fred" -> 7) // error - immutable

  scoresMutable+= ("James" -> 3, "Fred" -> 4) // adds 2 values
  scoresMutable -= "Alice" // removes value

  // updating immutable map
  val newScores = scores1 + ("James" -> 3, "Fred" -> 4) // New map
  val newScores2 = scores1 - "Alice"

  // iterating map
  for((k,v) <- scores1) println(k+":"+v)
  // get keySet
  scores1.keySet // return set like Set("Bob", "Fred", "Alice")
  // print all values
  for (v <- scores1.values) println(v)

  // switch keys and values
  val reversedMap = for ((k, v) <- scores1) yield (v, k)

  // all maps above are hash maps
  // let's create a sorted map - it can be only immutable in Scala
  val scoresSortedMap = scala.collection.immutable.SortedMap(
    "Alice" -> 5, "John" -> 3, "Bob" -> 4)

  // LinkedHashMap
  val linkedScores = scala.collection.mutable.LinkedHashMap(
    "Alice" -> 5, "John" -> 3, "Bob" -> 4)

  // interoperating with Java
  // Java map to Scala map
  import scala.collection.JavaConversions.mapAsScalaMap
  val scores: scala.collection.mutable.Map[String, Int] =
    new util.TreeMap[String, Int]

  // Scala map to Java map
  import scala.collection.JavaConversions.mapAsJavaMap
  val javaMap:java.util.Map[String,Int] =
    scala.collection.mutable.Map("Bob"->3, "Alice"->5)

  // Tuples
  val tuple = (1, 1.1, "John")
  // creating tuple of explicit type
  val tuple3:Tuple3[Int, Double, java.lang.String] = (2, 2.2, "Paul")
  // tuples may be accessed using _1, _2, _3 and so on
  val second = tuple._2 // Sets second to 1.1
  val second2 = tuple _2 // Sets second2 to 1.1
  // use pattern matching
  val (a,b,c) = tuple // sets a to 1, b to 1.1 and c to "John"
  val (_,second3,_) = tuple // set second3 to 1.1
  // String partition function returns a pair of strings with
  // the characters which fulfills condition and those that don't
  val tupleP = "Hello World".partition(_.isUpper)
  // tupleP is ("HW","ello orld")

  // zipping
  val symbols = Array("<", "-", ">")
  val counts = Array(2, 10, 2)
  val pairs = symbols.zip(counts)
  // pairs is Array(("<", 2), ("-", 10), (">", 2))

  // printing pairs
  for ((s,n) <- pairs) print(s+n)
  // prints <2-10>2
}
