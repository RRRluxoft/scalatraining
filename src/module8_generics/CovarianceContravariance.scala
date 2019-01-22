package module8_generics

object CovarianceContravariance {
  class Human
  class Person extends Human
  class Employee extends Person
  def transform(p:Person):Person = p
  val h = new Human
  val p = new Person
  val e = new Employee
  // covariance -T
  transform(e) // ok: Employee < Person
  //transform(h) // Type Mismatch: Human > Person
  // contravariance: +R
  val r: Human = transform(p) // ok: Person > Employee
  //val r2: Employee = transform(p) // error: Employee < Person

}
