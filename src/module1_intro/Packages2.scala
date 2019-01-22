package luxoft.scala {
  object Inside {
    private[scala] val scala = "It's SCALA!" // package visibility
  }
}
package luxoft {
  package object scala { val defaultTest = "default" }
}
package luxoft.scala {
  object Outside {
    val privateScala = Inside.scala // visible here
    var test = defaultTest
  }
}
package luxoft.scala.my {
  import luxoft.scala.Outside
  object Test {
    val test = Outside.test // error: Inside is not visible here
  }
}

object Packages {
  //println(Inside.scala) // error: scala is not visible here
  import luxoft.scala.{Outside=>Out, _}
  println(Out.test)
}

