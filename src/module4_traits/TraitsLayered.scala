package module4_traits

// layered traits
object TraitsLayered extends App {
  trait Logged { def log(msg: String) {} }
  class SavingsAccount

  trait ConsoleLogger extends Logged {
    override def log(msg: String) { println(msg) }
  }

  trait TimestampLogger extends Logged {
    override def log(msg: String) {
      super.log(new java.util.Date() + " " + msg)
    }
  }

  trait ShortLogger extends Logged {
    val maxLength = 15
    override def log(msg: String) {
      super.log(if (msg.length <= maxLength) msg
      else msg.substring(0, maxLength - 3) + "...")
    }
  }

  // You can add, to a class or an object, multiple traits
  // that invoke each other starting with the last one
  val acct1 = new SavingsAccount with ConsoleLogger with
    TimestampLogger with ShortLogger
  val acct2 = new SavingsAccount with ConsoleLogger with
    ShortLogger with TimestampLogger
  acct1.log("Test log message")
  // Thu Jun 09 03:32:20 MSK 2016 Test log mes...
  acct2.log("Test log message")
  // Thu Jun 09 0...


}
