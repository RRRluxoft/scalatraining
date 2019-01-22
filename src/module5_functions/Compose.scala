package module5_functions

object Compose extends App {

  val capital: String => String =
    Map(
      "France" -> "Paris",
      "Japan"->"Tokyo",
      "Norway"->"Oslo");

  val population: String => Int = {
    case "Paris" => 5
    case "Tokyo" => 15
    case "Oslo" => 1
  }

  val h:String =>Int = population compose capital

  println(h("France"))
}