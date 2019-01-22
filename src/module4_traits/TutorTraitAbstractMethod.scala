package module4_traits

// abstract method to access super
object TutorTraitAbstractMethod extends App {
  trait Logger {
    def log(msg: String) // log method is abstract
  }

  // TODO define log(msg: String) method in TimestampLogger
  // it should do
  // super.log(new java.util.Date()+" "+msg)
  trait TimestampLogger extends Logger {
  }

  class PrintLogger extends Logger {
    def log(msg: String) { println(msg) }
  }

  // TODO define variable as PrintLogger with TimestampLogger
  // TODO use log() - it should print message with the date

}
