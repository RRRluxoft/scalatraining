package module4_traits

object TraitConstructionOrder {

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

}
