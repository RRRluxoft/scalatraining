package module4_traits

// layered traits
object TutorTraitsLayered extends App {
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

  // TODO mix in TimestampLogger and ShortLogger to acct1
  val acct1 = new SavingsAccount with ConsoleLogger
  // TODO mix in ShortLogger and TimestampLogger to acct2
  val acct2 = new SavingsAccount with ConsoleLogger
  // TODO compare the results
  acct1.log("Test log message")
  acct2.log("Test log message")

  // why results are different?

}
