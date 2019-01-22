package module8_generics

import scala.collection.mutable.ArrayBuffer
import scala.reflect.ClassTag

object ManifestContextBound extends App {

  // Manifest Context Bound: using Manifest to create classes
  // When type is defined as T:Manifest, compiler will look for
  // implicit Manifest[T] and use it to create objects
  // syntax: [T:Manifest]
  import scala.reflect.runtime.universe._

  def createVariable1[T](first: T)(implicit m:Manifest[T]) = {
    val v = m.runtimeClass.newInstance()
    v
  }
  // create variable of the same type as parameter
  // adds (implicit cla:ClassTag[T]) which is available with classOf[T]
  def createVariable[T:ClassTag](first: T) = {
    val v = implicitly[ClassTag[T]].runtimeClass.newInstance
    v
  }

  class Holder1[T](obj:T) {
    var holder = obj
    def set(newObj:T) = {
      holder = newObj
    }
  }
  val h = new Holder1(2)
  h.set(3)

  class PersonFactory {
    def create(name:String) = new Person(name)
  }

  class Employee(name:String) extends Person(name) {
    override def toString=s"employee $name"
  }
  class PersonFactory1[T:ClassTag] {
    def create(name:String) = {
      val clazz = implicitly[ClassTag[T]].runtimeClass
      val obj = clazz.getConstructors()(0).newInstance(name)
      obj
    }
  }

  val factory = new PersonFactory1[Person]
  val person = factory.create("John")
  println( person ) // Person(John)
  val factory2 = new PersonFactory1[Employee]
  val emp = factory2.create("George")
  println( emp ) // employee George

  val s = createVariable[String]("Hello")
  println("s="+s)
  case class Person(name:String)
  val p1 = new Person("John")
  val p2 = new Person("George")
  //val p = createVariable(p1)
  //println("p2="+p2)

  def createArray[T:ClassTag](first: T, second: T) = {
    //val arr = implicitly[ClassTag[T]].newArray(2)
    val arr = new Array[T](2)
    arr(0) = first
    arr(1) = second
    arr
  }

  val a = createArray(p1,p2)
  println("created array: "+a)
  val ab = a.toBuffer
  println(ab)


  // create variable
  def createArrayBuffer[T: TypeTag](first: T, second:T) = {
    println(typeOf[T]) // Int
    val a = new ArrayBuffer[T]
    a+=first
    a+=second
    a
  }
  val arr1 = createArrayBuffer(1, getStr) // created ArrayBuffer[Int]
  // compiler locates the implicit Manifest[Int]

  // arr1 += "hi" // error: cannot put String to ArrayBuffer[Int]
  def getStr = if (scala.math.random>0.5) "hi" else 1
  arr1 += getStr
  arr1 += 1 // correct - put Int

}
