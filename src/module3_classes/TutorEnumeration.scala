package module3_classes

object TutorEnumeration extends App {

  // TODO define enumeration Grade with options Bad, Normal, Good, Perfect
  object Grade extends Enumeration {
    val Bad, Normal, Good, Perfect = Value
  }

  // TODO use Value function to define grade options with ids 2,3,4,5
  object Grade1 extends Enumeration {
    val Bad = Value(2, "boo")
    val Normal = Value(3, "pfffff")
    val Good = Value(4, "not bad")
    val Perfect = Value(5, "ok")
  }

  // TODO create method which takes Grade value as a parameter
  // TODO it should return ID of the grade (2,3,4,5)
  def action(value: Grade1.Value) = value match {
    case Grade1.Bad => Grade1.Bad.id
    case Grade1.Normal => Grade1.Normal.id
    case Grade1.Good => Grade1.Good.id
    case Grade1.Perfect => Grade1.Perfect.id
    case _ => "undefined"
  }

  // TODO print all grade ids and values, use for
  println(Grade1.Bad.id, Grade1.Bad)
  println(Grade1.Normal.id, Grade1.Normal)
  println(Grade1.Good.id, Grade1.Good)
  println(Grade1.Perfect.id, Grade1.Perfect)

  for (c <- Grade1.values) println(c.id + ": " + c)

  // TODO find the grade with ID 5 and print it
  // TODO find the grade with name "Bad" and print it (use withName)
  println(Grade1(5))
  println(Grade1.withName("boo"))

}
