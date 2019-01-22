package module4_traits

import java.io.{IOException, PrintStream}

object Traits extends App {

  // trait as interface
  trait Logger {
    def log(msg: String) // An abstract method
  }

  class ConsoleLogger0 extends Logger {
    // Use extends, not implements
    def log(msg: String) {
      println(msg)
    } // No override
  }

  class ConsoleLogger1 extends Logger with Cloneable with Serializable {
    def log(msg: String) {
      println(msg)
    }
  }


  // trait with concrete implementation
  trait ConsoleLogger2 {
    def log(msg: String) { println(msg) }
  }

  class Account {
    var balance: Double = 0
  }

  trait Logged { def log(msg: String) {} }

  // ConsoleLogger2 functionality is “mixed in” with the SavingsAccount
  class SavingsAccount extends Account with Logged {
    def withdraw(amount: Double) {
      if (amount > balance) log("Insufficient funds")
      else balance -= amount
    }
  }

  // object with traits
  trait ConsoleLogger3 extends Logged {
    override def log(msg: String) {
      println(msg)
    }
  }

  val acct = new SavingsAccount with ConsoleLogger3

  trait FileLogger extends Logged {
    override def log(msg: String) {
      super.log("")
      println("write to file " + msg)
    }
  }

  val acct2 = new SavingsAccount with FileLogger


}