package module4_traits

// concrete field in trait
object TraitConcreteField extends App {
  trait Logged { def log(msg: String) {} }
  class Account { var balance: Double = 0 }

  trait ShortLogger extends Logged {
    val maxLength = 15

    override def log(msg: String) {
      super.log(if (msg.length <= maxLength) msg
      else msg.substring(0, maxLength - 3) + "...")
    }
  }

  trait ConsoleLogger extends Logged {
    override def log(msg: String) { println(msg) }
  }

  class SavingsAccount extends Account with ConsoleLogger with ShortLogger {
    var interest = 0.0
    // balance: Double = 0 - inherited from Account
    // val maxLength = 15 - added (not inherited) from ShortLogger
    def withdraw(amount: Double) {
      if (amount > balance) log("Insufficient funds")
    }
    log("test")
  }
  new SavingsAccount


}
