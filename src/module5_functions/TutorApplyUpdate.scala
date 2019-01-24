package module5_functions

object TutorApplyUpdate extends App {

  // apply and update

  // TODO define class Phonebook with numbers as mutable Map String->String
  // TODO define apply(name:String) method which will retrieve value from map
  // TODO define update(name:String, number:String) which will keep number in map
  class Phonebook {
    val numbers = collection.mutable.Map[String, String]()

    def apply(name: String): String = numbers(name)

    def update(name: String, number: String): Unit = {
      numbers(name) = number // <-> numbers.put(name, number)
    }
  }

  /* TODO uncomment this */
  val book = new Phonebook
  book("Alice") = "123-45-67" // call to apply
  println(book("Alice")) // call to update

  // extractor
  class Person(val name: String, var age: Int)

  object Person {
    def unapply(arg: Person) = Some(arg.name, arg.age)
  }

  // TODO define companion object Person with unapply(Person) method
  // TODO it should return Option with tuple (name, age) of Person

  val p = new Person("John Smith", 33)

  /* TODO uncomment this */
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

  // TODO use Name unapply to extract name and surname from fullName
  val fullName = "John Smith"
  val Name(_n, _s) = fullName
  println(_n)
  println(_s)
//  val Name(_name, _sName) = "cool"
//  println(_name)
//  println(_sName)

  /* one argument extractor  */

  // if the unapply method extracts a single value,
  // it should just return an Option of the target type

  // TODO define object Number with unapply(input:String):Option[Int] method
  // TODO it should parse input with Integer.parseInt in try-catch block
  // TODO in case of NumberFormatException it should return None

  object Number {
    def unapply(input:String):Option[Int] = {
      try {
        Some(Integer.parseInt(input.trim))
      } catch {
        case ex: NumberFormatException  => None
      }
    }
  }

  // With this extractor, you can extract a number from a string:
   val Number(n) = "1729" // TODO uncomment this
   println("Extract " + n)


  // test extractor
  object IsCompound {
    def unapply(input: String) = input.contains(" ")
  }

  val author = "Ludwig Van Beethoven"

  // TODO use IsCompount test extractor in match for author
  // use case(first, last @ IsCompound()) =>
  // to check if last name contains a space
  author match {
    case Name(first, last @ IsCompound()) =>
      println("compound last name "+last)
    case Name(first, last) =>
      println("not compound name "+last)
  }

  // result should print "compound last name Van Beethoven"


  // TODO implement unapplySeq(input: String): Option[Seq[String]]
  // it should return None in case of empty String and
  // String sequence in case of not empty
  // use String.split("\\s+") to get a sequence
  object LongName {
    def unapplySeq(input: String): Option[Seq[String]] =
      if (input.trim == "") None else Some(input.trim.split("\\s+"))
  }

  /* TODO uncomment this */
  author match {
    case LongName(first, last) => println("surname name is "+last)
    case LongName(first, middle, last) =>
      println("compound surname name is "+middle+" "+last)
  }

  // should print "compound surname name is Van Beethoven"

}
