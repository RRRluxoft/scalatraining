package module4_traits

// abstract method to access super
object TraitAbstractMethod extends App {
  trait Logger {
    def log(msg: String) // log method is abstract
  }

  trait TimestampLogger extends Logger {
    abstract override def log(msg: String) {
      // we need abstract here too
      super.log(new java.util.Date() + " " + msg) // to get access to super.log
    }
  }

  class PrintLogger extends Logger {
    def log(msg: String) { println(msg) }
  }

  val a = new PrintLogger with TimestampLogger
  a.log("hello, I'm a!")

}
