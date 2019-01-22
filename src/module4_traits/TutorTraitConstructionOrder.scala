package module4_traits

object TutorTraitConstructionOrder extends App {

    // trait construction order
    trait Logger { println("Logger") }
    class Account { println("Account") }
    trait FileLogger extends Logger { println("FileLogger") }
    trait ShortLogger { println("ShortLogger") }
    class SavingsAccount extends Account with FileLogger with ShortLogger {
      println("SavingsAccount")
    }
    val a = new SavingsAccount
    // constructors order:
    // Account (the superclass)
    // Logger (parent of the first trait)
    // FileLogger (the first trait)
    // ShortLogger (the second trait)
    // SavingsAccount (the class)

    // TODO execute the code and check
    // TODO create your class CheckingAccount
    // TODO mix in traits in different order, check
    
}
