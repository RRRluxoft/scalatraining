package module4_traits

object TutorTraitAbstractField extends App {
  // abstract field in a trait
  trait Logged {
    def log(msg: String) {}
  }
  class Account { var balance: Double = 0 }

  // TODO define maxLength as abstract field
  trait ShortLogger extends Logged {
    override def log(msg: String) {
      //TODO uncomment
      //super.log(if (msg.length <= maxLength) msg
      //else msg.substring(0, maxLength - 3) + "...")
    }
  }

  trait ConsoleLogger extends Logged {
    override def log(msg: String) { println(msg) }
  }

  // TODO define maxLength value in the class
  class SavingsAccount extends Account
    with ConsoleLogger with ShortLogger {
    def withdraw(amount: Double) {
      if (amount > balance) log("Insufficient funds")
    }
  }

  // TODO define maxLength value for the object
  val logger = new ConsoleLogger with ShortLogger {
  }


}
