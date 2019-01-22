package module3_classes

object TutorObjects extends App {

  // TODO create Accounts object which will allow to generate
  // TODO the unique number of account using
  // TODO Accounts.newUniqueNumber

  // TODO let we have class Account
  // TODO define apply() method which will allow to create
  // TODO Account by using this syntax:
  // val account = Account(1000)
  // 1000 is the initialBalance value
  // TODO generate id using Accounts.newUniqueNumber
  class Account private (val id: Int, initialBalance: Double) {
    private var balance = initialBalance
  }

}
