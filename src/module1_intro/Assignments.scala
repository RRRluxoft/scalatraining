package module1_intro

object Assignments  extends App {
  
  class Holder {
    println("Holder")
  }
  var h1,h2=new Holder  // h1 and h2 have different objects
  
  //val a=b=1 -not working in scala
  val a=1 // a type is Unit
  
  // make 2 assignments
  val (y,z)=(1,2)
  
  // returning 2 values
  def minMax(x:Int,y:Int):(Int,Int) = if (x<y) (x,y) else (y,x)
  val (min,max)=minMax(5,10)

}