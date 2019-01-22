package module6_collections

object LazyViews extends App {
  import scala.math._

  // view yields a collection that is unevaluated
  val powers = (0 until 1000).view.map(pow(10, _))
  println( powers(1) ) // 10

  // take will allow to limit the elements amount
  println( (1 to 10).view.map( _ + 1).take(5).mkString(",") )
  // 2,3,4,5,6

}
