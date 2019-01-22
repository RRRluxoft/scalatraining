package module5_functions

object ApplyUpdate extends App {

  // apply and update
  class Phonebook {
    val numbers = scala.collection.mutable.Map[String, String]()
    def apply(name: String): String = numbers(name)
    def update(name: String, number: String) = numbers(name) = number
  }

  val book = new Phonebook
  book("Alice") = "123-45-67" // call to update
  println(book("Alice")) // call to apply

  // extractor
  class Person(val name: String, var age: Int)

  object Person {
    def unapply(arg: Person) = Some(arg.name, arg.age)
  }

  val p = new Person("John Smith", 33)
  val Person(name, age) = p
  println(name + " of age " + age)

  // Name object as extractor for String objects
  object Name {
    def unapply(input: String) = {
      val pos = input.indexOf(" ")
      if (pos == -1) None
      else Some((input.substring(0, pos), input.substring(pos + 1)))
    }
  }

  val Name(firstName, surname) = "John Smith"
  println(firstName) // John
  println(surname) // Smith

  // in this case Name.unapply will return None
  val Name(fName, fSurname) = "John" // throws MatchError exception

  // one argument extractor

  // if the unapply method extracts a single value,
  // it should just return an Option of the target type
  object Number {
    def unapply(input: String): Option[Int] =
      try {
        Some(Integer.parseInt(input.trim))
      } catch {
        case ex: NumberFormatException => None
      }
  }
  // With this extractor, you can extract a number from a string:
  val Number(n) = "1729"
  println(n)

  // test extractor
  object IsCompound {
    def unapply(input: String) = input.contains(" ")
  }

  val author = "Ludwig Van Beethoven"
  author match {
    case Name(first, last @ IsCompound()) =>
      println("compound last name "+last)
    case Name(first, last) =>
      println("not compound name "+last)
  }
  // will print "compound last name Van Beethoven"

  object LongName {
    def unapplySeq(input: String): Option[Seq[String]] =
      if (input.trim == "") None else Some(input.trim.split("\\s+"))
  }
  author match {
    case LongName(first, last) => println("surname name is "+last)
    case LongName(first, middle, last) =>
      println("compound surname name is "+middle+" "+last)
  }
  // will print "compound surname name is Van Beethoven"

  // if amount of parameters doesn't conform to length of sequence,
  // MatchError is thrown
  //val LongName(first) = "Piotr Chaikovsky" // exception: MatchError
  val LongName(sec) = "" // exception: MatchError
}
