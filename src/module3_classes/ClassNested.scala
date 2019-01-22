package module3_classes

object ClassNested {

  import scala.collection.mutable.ArrayBuffer

  class Network {
    class Member(val name: String) {   // Inner Class per Object
      val contacts = new ArrayBuffer[Member]
    }
    private val members = new ArrayBuffer[Member]
    def join(name: String) = { val m = new Member(name); members += m; m }
  }

  // Inner Class per Object: each instance has its own class Member,
  // just like each instance has its own field members
  val cosaNostra = new Network
  val camorra = new Network
  // cosaNostra.Member and camorra.Member are different classes!

  val fred = cosaNostra.join("Fred")
  val wilma = cosaNostra.join("Wilma")
  fred.contacts += wilma // OK

  val barney = camorra.join("Barney") // Has type myFace.Member
  //fred.contacts += barney // No! barney is of other type

  // you can use a type projection Network#Member,
  // which means "a Member of any Network"
  class Network2 {
    class Member(val name: String) {
      val contacts = new ArrayBuffer[Network#Member]
    }
    private val members = new ArrayBuffer[Member]
    def join(name: String) = { val m = new Member(name); members += m; m }
  }
  val cosaNostra2 = new Network2
  val camorra2 = new Network2
  // cosaNostra2.Member and camorra2.Member are the same class

  val fred2 = cosaNostra2.join("Fred")
  val wilma2 = cosaNostra2.join("Wilma")
  //fred2.contacts += wilma2 // OK

  val barney2 = camorra.join("Barney") // Has type myFace.Member
  fred2.contacts += barney2 // Ok! now barney is the same type

  // access this reference of the enclosing class
  // you can use Network.this,
  // or create custom variable referencing outer class
  class Network3(val name: String) { outer =>
    class Member(val name: String) {
      def description = name + " inside " + outer.name
    }
  }

}
