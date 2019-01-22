package module3_classes

object CompanionObject {
  class Test {
    private var b:Int = 0
    def apply(a:Int) = a+1
  }

  // we can access the private fields of class
  object Test {
    def apply(a:Int) = a+2
    def test(a:Int) = a+2

    def setB(t:Test, _b:Int) = if (_b>0) t.b=_b
  }

  val t = new Test()
  Test.setB(t, 10)
  Test(2) // 3 - call to apply in object Test
  t(2) // 4 - call to apply in class Test
  //t.b // error - cannot be accessed directly

}
