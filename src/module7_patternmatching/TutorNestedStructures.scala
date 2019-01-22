package module7_patternmatching

object TutorNestedStructures extends App {
  abstract class Item
  case class Book(name: String, price: Double) extends Item
  case class Bundle(name: String,
    discount: Double, items: Item*) extends Item

  // Not having to use new makes it easy to specify nested objects:
  val bundle =
    Bundle("Developer pack", 30.0,
      Book("Scala for the Impatient", 40.0),
      Book("Effective Scala", 30.0),
      Bundle("Java pack", 20.0,
        Book("Efficient Java", 80.0),
        Book("Java for the Impatient", 30.0)))

  // patterns can match specific nestings, for example
  // TODO match bundle to Bundle class to retrieve name of the
  // TODO bundle and name of the first book in bunde
  // should print "Bundle Developer pack includes Scala for the Impatient"

  // you can bind a nested value to a variable with the @ notation
  // TODO use items @ _* as a parameter to retrieve list of all items;
  // TODO print how many books contained in the bundle
  // should print "Bundle Developer pack includes Scala for the Impatient and 1 other books"

  // NOTE: case Bundle(name, _, book @ Book(bookName, _), books)
  // will match exactly 1 book to books, not array

  // here's function which computes the price of an item:
  def price(it: Item): Double = it match {
    case Book(_, p) => p
    case Bundle(name, discount, items @ _*) =>
      items.map(price _).sum - discount
  }

  println(price(bundle)) // 130.0

  // TODO print all bundles names and price in this bundle

  // TODO print all book names and price in this bundle

  // TODO define nested structure of Folder and File using case classes
  // TODO define variable fs with some Folders and Files
  // TODO implement the method which calculates the total size of the FSItem
  // TODO implement the method which prints contents of the FSItem
}
