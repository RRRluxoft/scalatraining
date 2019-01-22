package module5_functions

object TutorApplyUpdate extends App {

  // apply and update

  // TODO define class Phonebook with numbers as mutable Map String->String
  // TODO define apply(name:String) method which will retrieve value from map
  // TODO define update(name:String, number:String) which will keep number in map

  /* TODO uncomment this
  val book = new Phonebook
  book("Alice") = "123-45-67" // call to apply
  println(book("Alice")) // call to update
  */

  // extractor
  class Person(val name: String, var age: Int)

  // TODO define companion object Person with unapply(Person) method
  // TODO it should return Option with tuple (name, age) of Person

  val p = new Person("John Smith", 33)
  /* TODO uncomment this
  val Person(name, age) = p
  println(name + " of age " + age)
  */

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

  // one argument extractor

  // if the unapply method extracts a single value,
  // it should just return an Option of the target type

  // TODO define object Number with unapply(input:String):Option[Int] method
  // TODO it should parse input with Integer.parseInt in try-catch block
  // TODO in case of NumberFormatException it should return None

  // With this extractor, you can extract a number from a string:
  // val Number(n) = "1729" // TODO uncomment this
  // println(n)


  // test extractor
  object IsCompound {
    def unapply(input: String) = input.contains(" ")
  }

  val author = "Ludwig Van Beethoven"
  // TODO use IsCompount test extractor in match for author
  // use case(first, last @ IsCompound()) =>
  // to check if last name contains a space

  // result should print "compound last name Van Beethoven"


  // TODO implement unapplySeq(input: String): Option[Seq[String]]
  // it should return None in case of empty String and
  // String sequence in case of not empty
  // use String.split("\\s+") to get a sequence
  object LongName {
  }
  /* TODO uncomment this
  author match {
    case LongName(first, last) => println("surname name is "+last)
    case LongName(first, middle, last) =>
      println("compound surname name is "+middle+" "+last)
  }
  */
  // should print "compound surname name is Van Beethoven"

}
