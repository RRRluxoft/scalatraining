package module3_classes

object TutorClasses extends App {

  // TODO create class Counter with a private value variable
  // TODO create methods increment and parameterless get which will return value
  // TODO create counter instance, do increment and print the value
  class Counter {
    private var value: Int = 0
    def increment(): Unit = value += 1
    def current = value
  }

  // TODO create class person with private age,
  // TODO add getter method for age
  // TODO add setter method which will prohibit to get younger
  // TODO create instance and try to get younger
  class Person {
    private var privateAge = 0 // make private and rename

    def age = privateAge
    def age_=(newValue: Int) {
      if (newValue > privateAge) privateAge = newValue; // can't get younger
    }
  }

  val p1 = new Person
  println(p1.age)
  p1.age = 30
  println(p1.age)
  p1.age_=(42)
  println(p1.age)
  p1.age = (22)
  println(p1.age)


  // Class-private and Object-private fields

  // TODO why are we able to access other.value here?
  // TODO how to disallow it?
  class Counter1 {
    private var value = 0
    def increment() { value += 1 }

    def isLess(other : Counter1) = value < other.value
    // Can access private field of other object
  }

  // TODO Generate Java-style getters and setters for property name
  class Person2 {
    import scala.beans.BeanProperty
    @BeanProperty var name: String = _
  }

  val p2 = new Person2
  p2.name = "Sting"
  println(p2.name)

  p2.name_=("rrrr")

  p2.getName
  p2.setName("fff")

  // These methods will be generated:
  // 1. name: String
  // 2. name_=(newValue: String): Unit
  // 3. getName(): String
  // 4. setName(newValue: String): Unit


}
