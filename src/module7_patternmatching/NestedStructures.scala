package module7_patternmatching

object NestedStructures extends App {
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
  bundle match {
    case Bundle(name, _, Book(bookName, _), _*) =>
      println(s"Bundle $name includes book $bookName")
  } // Bundle Developer pack includes Scala for the Impatient

  // you can bind a nested value to a variable with the @ notation
  bundle match {
    case Bundle(name, _, book @ Book(bookName, _), books @ _*) =>
      val len = books.length -1
      println(s"Bundle $name includes book $bookName " +
        s"and $len other books")
  } // Bundle Developer pack includes Scala for the Impatient and 1 other books

  // NOTE: case Bundle(name, _, book @ Book(bookName, _), books)
  // will match exactly 1 book to books, not array

  // here's function which computes the price of an item:
  def price(it: Item): Double = it match {
    case Book(_, p) => p
    case Bundle(name, discount, items @ _*) =>
      items.map(price _).sum - discount
  }

  println(price(bundle)) // 130.0
  // print all bundles names and price in this bundle
  bundle.items.foreach(e => e match {
    case Bundle(name,_, books @ _*) => println(name + " " + price(e))
    case _ =>
  })
  // print all book names and price in this bundle
  bundle.items.foreach(_ match {
    case Book(name,price) => println(name+" "+price)
    case _ =>
  })

}
