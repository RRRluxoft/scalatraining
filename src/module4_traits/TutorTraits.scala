package module4_traits

object TutorTraits extends App {

  // trait as interface:
  // create trait Logger with method log(msg:String)
  // implement it in a class

  // trait with concrete implementation
  // TODO create trait ConsoleLogger0 with already implemented log(msg:String)

  class Account {
    var balance: Double = 0
  }
  trait Logged { def log(msg: String) {} }

  class SavingsAccount extends Account with Logged {
    def withdraw(amount: Double) {
      if (amount > balance) log("Insufficient funds")
      else balance -= amount
    }
  }

  // object with traits
  trait ConsoleLogger extends Logged {
    override def log(msg: String) {
      println(msg)
    }
  }

  // TODO create acct variable as SavingsAccount instance
  // TODO with ConsoleLogger mixed in
  // TODO do withdraw to check logging

  trait FileLogger extends Logged {
    override def log(msg: String) {
      println("write to file " + msg)
    }
  }

  // TODO create acct variable as SavingsAccount instance
  // TODO with FileLogger mixed in
  // TODO do withdraw to check logging


}