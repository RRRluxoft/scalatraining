package module4_traits

// traits with rich interfaces
object TraitRichInterface extends App {
  class Account {
    var balance: Double = 0
  }
  // trait can have many utility methods
  // that depend on a few abstract ones
  trait Logger {
    def log(msg: String)
    def info(msg: String) { log("INFO: " + msg) }
    def warn(msg: String) { log("WARN: " + msg) }
    def severe(msg: String) { log("SEVERE: " + msg) }
  }

  class SavingsAccount extends Account with Logger {
    def withdraw(amount: Double) {
      if (amount > balance) severe("Insufficient funds")
    }
    def log(msg: String) { println(msg) }
  }

}
