package module4_traits

// concrete field in trait
object TutorTraitConcreteField extends App {
  trait Logged { def log(msg: String) {} }
  class Account { var balance: Double = 0 }

  // TODO define concrete field maxLength with value 15
  trait ShortLogger extends Logged {

    override def log(msg: String) {
      // TODO uncomment
      //super.log(if (msg.length <= maxLength) msg
      //else msg.substring(0, maxLength - 3) + "...")
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
  }


}
