package module7_patternmatching

object TutorEnumerations {
  // Case classes let you simulate enumerated types in Scala
  sealed abstract class TrafficLightColor
  // TODO define enumeration options as case objects
  // Red, Yellow, Green inherited from TrafficLightColor

  //val color: TrafficLightColor = Red // TODO uncomment this

  // TODO use pattern matching to assign result
  // TODO to "stop" if color is Red, to "hurry up" if color is Yellow
  // TODO and "go" if color is Green
  val result = ""

  // superclass was declared as sealed, enabling the compiler
  // to check that the match clause is complete

}
