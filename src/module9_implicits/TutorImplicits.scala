package module9_implicits

object TutorImplicits extends App {

  // An implicit conversion function is automatically
  // applied to convert values from one type to another
  class Person(val name:String)

  // TODO create implicit function which converts String to Person

  //val p:Person = "Mary" // TODO uncomment this

  // implicits are used to enrich existing libraries
  // for example, classes RichFile or RichInt provides additional features
  //implicit def file2RichFile(from: File) = new RichFile(from)

  // localization of conversions
  // it's usual to create special object for conversions
  // TODO create object PersonConversions with implicit
  // TODO conversion of String to Person
  // then you can import one or all conversions from this object

  // When implicit function is applied?

  // 1) If the type of the expression differs from expected type:
  // val person:Person = "John" // TODO uncomment this

  // 2) If object access nonexistent parameter
  class RichPerson(val self: Person) {
    def upperCase = self.name.toUpperCase
    override def toString = self.name
  }
  // TODO define implicit conversion from Person to RichPerson
  // TODO apply method upperCase to instance of Person

  // 3) If an object invokes a method whose parameters
  // don’t match the given arguments
  // TODO define method printRichPerson which takes RichPerson
  // TODO as a parameter and prints it
  // TODO call printRichPerson with Person instance as parameter

  // However, implicit conversions are not used if:

  // 1) Code compiles without it, for example
  // TODO try to print person.toString
  // TODO why it doesn't print person's same as defined in RichPerson?

  // 2) Compiler will never attempt multiple conversions
  implicit def richPerson2Int(p:RichPerson) = p.self.name.length

  val rich:RichPerson = null // TODO pass person as the value of rich
  // TODO uncomment this
  // val richLength: Int = rich // richPerson2Int is applied

  // TODO assign Person instance to richLength2
  // TODO why it doesn't work?
  val richLength2: Int = 0

  // 3) Ambiguous conversions are an error
  class VeryRichPerson(val self: Person) {
    def upperCase = self.name.toUpperCase
  }
  // TODO define implicit conversion of Person to VeryRichPerson
  // TODO print person.upperCase
  // TODO why it doesn't work?

}
