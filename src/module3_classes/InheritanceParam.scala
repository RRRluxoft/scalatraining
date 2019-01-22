package module3_classes

// Inheritance from class with parameter
object InheritanceParam {
  class Person(val name:String)

  // Bad way
  class Emp(override val name:String) extends Person(name)

  // Correct way
  class Employee(_name:String) extends Person(_name) {
    var salary = 0
    override def toString = " employee having salary " + salary
  }

}
