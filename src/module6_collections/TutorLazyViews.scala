package module6_collections

object TutorLazyViews extends App {
  import scala.math._

  // view yields a collection that is unevaluated
  // TODO take range 0 until 1000 , do the view from it and
  // TODO use map to calcuate square of each element
  // TODO assign the result to squares, print squares(1), squares(5), etc.
  val power = (0 until 1000).view.map(pow(10, _))

  // take will allow to limit the elements amount
  // TODO use take(5) to get 5 results from squares at once (then use mkString)
  println( (1 to 10).view.map(_ + 1).take(5) mkString(",") )

}
