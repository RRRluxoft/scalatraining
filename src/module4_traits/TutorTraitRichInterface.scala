package module4_traits

// traits with rich interfaces
object TutorTraitRichInterface extends App {
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

  // TODO mix in Logger to SavingsAccount
  // TODO we should define log() method which was abstract
  class SavingsAccount extends Account {
    def withdraw(amount: Double) {
      if (amount > balance) {
        // TODO uncomment this
        // severe("Insufficient funds")
      }
    }
  }

}
