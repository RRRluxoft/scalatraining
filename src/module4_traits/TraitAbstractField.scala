package module4_traits

object TraitAbstractField {
  // abstract field in a trait
  trait Logged {
    def log(msg: String) {}
  }
  class Account { var balance: Double = 0 }

  trait ShortLogger extends Logged {
    val maxLength: Int // abstract field
    override def log(msg: String) {
      super.log(if (msg.length <= maxLength) msg
      else msg.substring(0, maxLength - 3) + "...")
    }
  }

  trait ConsoleLogger extends Logged {
    override def log(msg: String) { println(msg) }
  }

  class SavingsAccount extends Account
    with ConsoleLogger with ShortLogger {
    val maxLength = 15 // we have to define it, override is not needed
    def withdraw(amount: Double) {
      if (amount > balance) log("Insufficient funds")
    }
  }
  // also it's possible to define value in variable
  val logger = new ConsoleLogger with ShortLogger {
    val maxLength = 20
  }


}
