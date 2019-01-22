package module2_arrays

object JavaInterop {
  // For interoperating with Java, use
  // implicit conversion methods in scala.collection.JavaConversions

  // java.lang.ProcessBuilder class
  // has a constructor with a List<String> parameter
  import scala.collection.JavaConversions.bufferAsJavaList
  import scala.collection.mutable.ArrayBuffer
  val command = ArrayBuffer("ls", "-al", "/home/cay")
  val pb = new ProcessBuilder(command) // Scala to Java

  import scala.collection.JavaConversions.asScalaBuffer
  import scala.collection.mutable.Buffer
  val cmd : Buffer[String] = pb.command() // Java to Scala
  // You can't use ArrayBuffer:
  // the wrapped object is only guaranteed to be a Buffer

}
