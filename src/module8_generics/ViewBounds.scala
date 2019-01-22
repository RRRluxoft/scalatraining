package module8_generics

object ViewBounds {
  // view bounds

  // <% relation means that T can be converted to a Comparable[T]
  // through an implicit conversion
  class Pair[T <: Comparable[T]](val first: T, val second: T)
  //new Pair4(2,3) // error: inferred type arguments [Int] do not conform
  // to class Pair4's type parameter bounds [T <: Comparable[T]]

  // reason: Unlike the java.lang.Integer wrapper type,
  // the Scala Int type does not implement Comparable.
  // However, RichInt does implement Comparable[Int],
  // and there is an implicit conversion from Int to RichInt

  class Pair1[T <% Comparable[T]](val first: T, val second: T)
  new Pair1(3,4) // that works
  // <% means that T can be converted to a Comparable[T]
  // through an implicit conversion.

}
