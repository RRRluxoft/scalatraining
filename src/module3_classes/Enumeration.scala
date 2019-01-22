package module3_classes

object Enumeration extends App {

  // define enumeration
  object TrafficLightColor extends Enumeration {
    val Red, Yellow, Green = Value
  }

  // Value is a special function;
  // it may accept parameters ID and name
  object TrafficLightColor1 extends Enumeration {
    val Red = Value(0, "Stop")
    val Yellow = Value(10) // Name "Yellow"
    val Green = Value("Go") // ID 11
  }

  // importing and using enumeration
  import TrafficLightColor._
  def action(color: TrafficLightColor.Value) = {
      if (color == Red) "stop"
      else if (color == Yellow) "hurry up"
      else "go"
  }

  // print enumeration values
  for (c <- TrafficLightColor1.values) println(c.id + ": " + c)

  // look up an enumeration value by ID or name
  TrafficLightColor(0) // Calls Enumeration.apply, finds by ID
  TrafficLightColor.withName("Red") // finds by name

}
