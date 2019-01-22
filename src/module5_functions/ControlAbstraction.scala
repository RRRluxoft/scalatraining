package module5_functions

object ControlAbstraction {

  // sequence of statements as a function
  // with no parameters or return value
  // block: () => Unit

  def runInThread(block: () => Unit) {
    new Thread {
      override def run() { block() }
    }.start()
  }

  // we should use {} if we have several commands in block
  runInThread { () => println("Hi"); Thread.sleep(10000); println("Bye") }

  // To avoid the () => in the call, use the call by name notation
  def runInThread2(block: => Unit) {
    new Thread {
      override def run() { block }
    }.start()
  }

  // then call becomes
  runInThread2 { println("Hi"); Thread.sleep(10000); println("Bye") }

  // control abstractions: functions that look like they are language keywords
  // using call by name and currying
  def until(condition: => Boolean)(block: => Unit) {
      if (!condition) {
        block
        until(condition)(block)
      }
  }

  // using until as a language construction
  var x = 10
  until (x == 0) {
    x -= 1
    println(x)
  }

  // without currying, it would look this way:
  // until(x == 0, { ... })

  // return expression

  // In Scala, you don’t use a return statement to return function values

  // you can use return to return a value
  // from an anonymous function to an enclosing named function
  def indexOf(str: String, ch: Char): Int = {
      var i = 0
      until (i == str.length) {
        if (str(i) == ch) return i
        // return: indexOf terminates and returns the given value
        i += 1
      }
      return -1
  }
  // return throws special exception in the anonymous function
  // and caught in the indexOf function
}
