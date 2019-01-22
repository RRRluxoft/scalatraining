package module8_generics

object TypeDeclarations {
  type IntList = List[Integer]
  //type T <: Comparable[T]
  type Two[A] = Tuple2[A, A]
  //type MyCollection[+X] <: Iterable[X]
}

// http://www.scala-lang.org/files/archive/spec/2.11/04-basic-declarations-and-definitions.html#type-declarations-and-type-aliases