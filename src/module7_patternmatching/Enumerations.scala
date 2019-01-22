package module7_patternmatching

object Enumerations {
  // Case classes let you simulate enumerated types in Scala
  sealed abstract class TrafficLightColor
  case object Red extends TrafficLightColor
  case object Yellow extends TrafficLightColor
  case object Green extends TrafficLightColor

  val color: TrafficLightColor = Red
  color match {
    case Red => "stop"
    case Yellow => "hurry up"
    case Green => "go"
  }
  // superclass was declared as sealed, enabling the compiler
  // to check that the match clause is complete

}
