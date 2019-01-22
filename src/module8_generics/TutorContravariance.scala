package module8_generics

object TutorContravariance extends App {

  class Person(val name:String) {
    var friend: Person = null
  }
  class Student(_name:String) extends Person(_name)
  val student = new Student("John")
  val person = new Person("Joseph")
  student.friend = person
  person.friend = student
  // Parameters are contravariant positions, and return types are covariant
  val getStudent: (Student => String) = ((a: Student) => a.friend.name)
  // trait Function1 [-T, +R] extends AnyRef
  // p:Function1[Student,String]
  def printFriend(p:Student=>String)(s:Student) =
    println("friend is " + p(s) )

  printFriend(getStudent)(student) // friend is Joseph

  // using contravariance allows to pass getPerson function to printFriend
  // TODO create function getPerson of type Person=>String
  // TODO pass getPerson and student to printFriend

  // one more task
  // TODO change printFriend function to make possible to take
  // TODO not only Student, but also Person as 2nd argument
  // TODO getStudent or getPerson should still be passed as 1st argument
  // TODO additionally print person's name, so
  // TODO printFriend should print "John's friend is Joseph"

}
