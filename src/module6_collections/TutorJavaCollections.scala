package module6_collections

import scala.collection.mutable.ArrayBuffer

object TutorJavaCollections extends App {
  import scala.collection.JavaConversions._

  // conversions for Scala Map<=>Java Map
  val jmap: java.util.Map[Int,Int] = Map(1->2) // implicit conversion
  println( jmap ) // {1=2}
  val scalaMap: scala.collection.Map[Int,Int] = jmap // implicit conversion
  println( scalaMap ) // Map(1 -> 2)
  val scalaMap2 = mapAsScalaMap( jmap ) // explicit conversion
  println( scalaMap2 ) // Map(1 -> 2)
  val javaMap = mapAsJavaMap(scalaMap) // explicit conversion
  println( javaMap ) // {1=2}
  //javaMap.put(2,3) // exception: UnsupportedOperationException
  // to work with the mutable map, use:
  val mutableMap = new scala.collection.mutable.HashMap[String,String]
  val javaMapMutable = mutableMapAsJavaMap(mutableMap)

  // conversions for Buffer<=>List
  val buf = ArrayBuffer("one", "two", "three")
  // TODO create list of type java.util.ArrayList and
  // TODO fill it with buf by passing buf to constructor
  // explicit conversion to Scala Buffer
  // TODO use explicit conversion asScalaBuffer to get Buffer from list
  // implicit conversion from ArrayList to Buffer
  // TODO define buf3 as mutable Buffer, and assign list to it
  // implicit conversion from Buffer to Java List
  // TODO define list as java.util.List and assign buf3 to it
  // explicit conversion to Java List
  // TODO use bufferAsJavaList to explicitly convert buf3 to Java list

  // conversions for Scala Set<=>Java Set
  val set = new java.util.HashSet[String]()
  set.add("Hi")
  val scalaSet = asScalaSet(set) // explicit conversion
  println( scalaSet ) // Set(Hi)
  // implicit conversion from Java Set to Scala Set
  val scalaSet2: scala.collection.mutable.Set[String] = set
  // implicit conversion from Scala Set to Java Set
  val javaSet: java.util.Set[String] = scalaSet2

  // implicit conversion for properties
  val props: scala.collection.mutable.Map[String, String] =
    System.getProperties()

  // conversion of Java List to Seq
  val javaList = seqAsJavaList(Seq(1,2,3))

}
