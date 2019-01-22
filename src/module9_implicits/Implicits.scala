package module9_implicits

object Implicits extends App {

  // An implicit conversion function is automatically
  // applied to convert values from one type to another
  class Person(val name:String)

  implicit def string2Person(s: String) = new Person(s)

  val p:Person = "Mary" // works! use implicit conversion

  // implicits are used to enrich existing libraries
  // for example, classes RichFile or RichInt provides additional features
  //implicit def file2RichFile(from: File) = new RichFile(from)

  // localization of conversions
  // it's usual to create special object for conversions
  object PersonConversions {
    implicit def string2Person(s: String) = new Person(s)
  }
  // then you can import one or all conversions from this object

  // When implicit function is applied?
  // 1) If the type of the expression differs from expected type:
  val person:Person = "John"
  // 2) If object access nonexistent parameter
  class RichPerson(val self: Person) {
    def upperCase = self.name.toUpperCase
    override def toString = self.name
  }
  implicit def person2RichPerson(p:Person) = new RichPerson(p)
  println( person.upperCase ) // JOHN
  // 3) If an object invokes a method whose parameters
  // don’t match the given arguments
  def printRichPerson(p:RichPerson): Unit = println(p)
  printRichPerson(person) // prints John

  // However, implicit conversions are not used if:
  // 1) Code compiles without it, for example
  println(person.toString) // Person@3b81a1bc
  // it does not execute RichPerson toString

  // 2) Compiler will never attempt multiple conversions
  implicit def richPerson2Int(p:RichPerson) = p.self.name.length
  val rich:RichPerson = p
  val richLength: Int = rich // richPerson2Int is applied
  //val richLength2: Int = p // error: 2 implicit conversions are not applied

  // 3) Ambiguous conversions are an error
  class VeryRichPerson(val self: Person) {
    def upperCase = self.name.toUpperCase
  }
  implicit def person2VeryRichPerson(p:Person) = new VeryRichPerson(p)
  //println( person.upperCase ) // error: ambiguous conversion
  // upperCase is defined in RichPerson and VeryRichPerson

}
