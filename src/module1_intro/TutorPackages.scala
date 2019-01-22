package com // package for all elements below
package luxoft {
  package scala {
    object Inside1 { val test = "Hello from Inside" }
  }
}
package luxoft.scala {
  object Outside1 {
    val test = "Hello from Outside"
    val inside = Inside.test // it is accessible: same package
  }
}
object Packages1 extends App {
  // TODO import only com.luxoft.scala.Inside1
  // println(Inside1.test) // TODO uncomment
  // TODO import everything from com.luxoft.scala
  // println(Outside1.test) // TODO uncomment
}

