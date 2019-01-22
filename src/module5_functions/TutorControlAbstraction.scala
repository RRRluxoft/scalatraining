package module5_functions

object TutorControlAbstraction {

  // sequence of statements as a function
  // with no parameters or return value
  // block: () => Unit

  // TODO define function runInThread which takes block as a parameter
  // TODO block should be used in run()

  // TODO uncomment this
  // runInThread { () => println("Hi"); Thread.sleep(10000); println("Bye") }

  // TODO to avoid the () => in the call, use the call by name notation
  // define appropriate function runInThread
  def runInThread(block: => Unit) {
    new Thread {
      override def run() { block }
    }.start()
  }

  // TODO uncomment this
  // runInThread2 { println("Hi"); Thread.sleep(10000); println("Bye") }

  // control abstractions: functions that look like they are language keywords
  // using call by name and currying
  // TODO define function until which will use recursive call
  // TODO to execute block until condition will be true
  // TODO function should take 2 curried parameters: condition and block
  // TODO defined with syntax: block: => Unit

  // using until as a language construction
  /* TODO uncomment this
  var x = 10
  until (x == 0) {
    x -= 1
    println(x)
  }
  */

  // without currying, it would look this way:
  // until(x == 0, { ... })

  // return expression

  // In Scala, you don’t use a return statement to return function values

  // you can use return to return a value
  // from an anonymous function to an enclosing named function
  // TODO define function indexOf which will use until function
  // TODO use return when the character is found
  // def indexOf(str: String, ch: Char): Int = { ... }

  // return throws special exception in the anonymous function
  // and caught in the indexOf function
}
