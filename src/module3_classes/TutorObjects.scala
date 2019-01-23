package module3_classes

object TutorObjects extends App {

  // TODO create Accounts object which will allow to generate
  // TODO the unique number of account using
  // TODO Accounts.newUniqueNumber
  object Accounts {
    private var lastNumber = 0

    def newUniqueNumber() = {
      lastNumber += 1;
      lastNumber
    }
  }

  // TODO let we have class Account
  // TODO define apply() method which will allow to create
  // TODO Account by using this syntax:
  // val account = Account(1000)
  // 1000 is the initialBalance value
  // TODO generate id using Accounts.newUniqueNumber
  class Account private(val id: Int, initialBalance: Double) {
    private var balance = initialBalance
  }

  object Account {
    def apply(initNumber: Int): Account = new Account(Accounts.newUniqueNumber(), initNumber)
  }

  val account = Account(10000)

}
