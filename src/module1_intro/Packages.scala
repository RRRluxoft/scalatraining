package com // package for all elements below
package luxoft {
  package scala {
    object Inside { val test = "Hello from Inside" }
  }
}
package luxoft.scala {
  object Outside {
    val test = "Hello from Outside"
    val inside = Inside.test // it is accessible: same package
  }
}
object Packages extends App {
  import com.luxoft.scala.Inside // import only com.luxoft.scala.Inside
  println(Inside.test)
  import  luxoft.scala._ // import everything from com.luxoft.scala
  println(Outside.test)
}

