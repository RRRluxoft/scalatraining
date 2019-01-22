package module3_classes

object Objects extends App {

  // using Object as a Singleton
  object Accounts {
    private var lastNumber = 0
    def newUniqueNumber() = { lastNumber += 1; lastNumber }
  }

  val number = Accounts.newUniqueNumber

  // apply method and companion object
  class Account private (val id: Int, initialBalance: Double) {
    private var balance = initialBalance
  }

  object Account { // The companion object
    def apply(initialBalance: Double) =
      new Account(Accounts.newUniqueNumber, initialBalance)
  }

  val account = Account(1000)



}
