package module3_classes

object Classes extends App {
  class Counter {
    private var value = 0 // You must initialize the field
    def increment() { value += 1 } // Methods are public by default
    def current = value
  }

  val myCounter = new Counter
  myCounter.increment()
  myCounter.increment
  //println(myCounter.current()) // not allowed: method defined with no ()
  println(myCounter.current)

  // use () for a mutator method, don't use for accessor

  // Scala generates getters and setters automatically
  class Person {
    var age = 0
  }
  val p = new Person
  p.age = 10 // implicit call age_=
  println(p.age) // implicit call age()

  // but we can redefine it later
  class Person1 {
    private var privateAge = 0 // make private and rename

    def age = privateAge
    def age_=(newValue: Int) {
      if (newValue > privateAge) privateAge = newValue; // can't get younger
    }
  }
  val john = new Person1
  john.age = 30
  john.age = 21
  println(john.age) // 30

  // using Uniform Access Principle

  // Getters and Setters generation rules
  //  If the field is private, the getter and setter are private
  //  If the field is a val, only a getter is generated
  //  If you don’t want any getter or setter, declare the field as private[this]

  class Message {
    val timeStamp = new java.util.Date // Scala will create only getter
  }

  // Getter and Setter generation
  // 1. var foo: Scala synthesizes a getter and a setter
  // 2. val foo: Scala synthesizes a getter
  // 3. You define methods foo and foo_=
  // 4. You define a method foo


  // Class-private and Object-private fields

  // In Scala method can access
  // the private fields of all objects of its class
  class Counter1 {
    private var value = 0
    def increment() { value += 1 }

    def isLess(other : Counter1) = value < other.value
    // Can access private field of other object
  }

  // we can change it by using private[this]:
  class Counter2 {
    private[this] var value = 0 // Accessing someObject.value is not allowed
    def increment() { value += 1 }

    //def isLess(other : Counter2) = value < other.value
    // Error: value is inaccessible
  }
  // NOTE: for object-private getters and setters are not generated

  // Generating Java-style getters and setters
  class Person2 {
    import scala.beans.BeanProperty
    @BeanProperty var name: String = _
  }

  // These methods will be generated:
  // 1. name: String
  // 2. name_=(newValue: String): Unit
  // 3. getName(): String
  // 4. setName(newValue: String): Unit


}
