package module3_classes

object TutorAuxiliaryConstructor {

  // TODO create class Person with private fields name and age with default values
  // TODO create auxiliary constructors this(name) and this(name,age)
  class Person {
    private var name = ""
    private var age = 0

    def this(name: String) {
      this()
      this.name = name
    }

    def this(name: String, age: Int) {
      this(name)
      this.age = age
    }
  }

  // TODO create Person using constructor with no params, with name parameter
  // TODO and with name and age

  val p1 = new Person
  val p2 = new Person("Sting")
  val p3 = new Person("Sting", 42)

}
