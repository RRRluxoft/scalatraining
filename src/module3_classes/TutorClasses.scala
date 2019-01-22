package module3_classes

object TutorClasses extends App {

  // TODO create class Counter with a private value variable
  // TODO create methods increment and parameterless get which will return value
  // TODO create counter instance, do increment and print the value

  // TODO create class person with private age,
  // TODO add getter method for age
  // TODO add setter method which will prohibit to get younger
  // TODO create instance and try to get younger


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
    var name: String = _
  }

}
