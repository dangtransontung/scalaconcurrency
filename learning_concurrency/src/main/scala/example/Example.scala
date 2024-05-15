package example
object Example extends App {
    def thread(body: () => Unit): Thread = {
        val t = new Thread {
            override def run(): Unit = {
                body()
            }
        }

        t.start()
        t
    }

    val a1 = thread({() => println(s"${Thread.currentThread().getName()} Hello World!")})
    val a2 = thread({() => println(s"${Thread.currentThread().getName()} Hello World!")})
    a1.join(); a2.join()
}