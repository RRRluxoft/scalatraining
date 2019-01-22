package module3_classes

object AuxiliaryConstructor {

  class Person {
    private var name = ""
    private var age = 0

    def this(name: String) {
      // An auxiliary constructor
      this() // Calls primary constructor
      this.name = name // we are able to use this to set name
    }

    def this(name: String, age: Int) {
      // Another auxiliary constructor
      this(name) // Calls previous auxiliary constructor
      this.age = age
    }
  }

  val p1 = new Person // Primary constructor
  val p2 = new Person("Fred") // First auxiliary constructor
  val p3 = new Person("Fred", 42) // Second auxiliary constructor
}
