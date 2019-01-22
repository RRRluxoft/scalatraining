package module8_generics

object Contravariance extends App {

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

  // using contravariance allows to pass getPerson in printFriend
  val getPerson: (Person => String) = ((a: Person ) => a.friend.name)
  printFriend(getPerson)(student) // friend is Joseph

  // because of contravariance -T, we cannot pass more concrete function
  class StudentFirst(_name:String, val grade:Int) extends Student(_name)
  val getStudentFirst: (StudentFirst => String) =
    ((a:StudentFirst) => a.friend.name+a.grade)
  //printFriend(getStudentFirst)(student) // error: Type mismatch
  // getStudentFirst cannot be applied because it may
  // access more detailed data than expected: for example, printFriend
  // applies function to Student,
  // but function needs details defined in StudentFirst

  //printFriend(getPerson)(person) // error: 2nd param type should be only Student

  // one more task solution
  // printFriend2 function makes possible to take
  // not only Student, but also Person as 2nd argument
  // getStudent and getPerson should still be passed as 1st argument
  // additionally it prints person's name, so
  // printFriend should print "John's friend is Mary"
  def printFriend2[T<:Person](p:T=>String)(s:T) =
    println(s.name+"'s friend is " + p(s) )

  printFriend2(getPerson)(person) // Joseph's friend is John
}
