package ctodo

object ctodo extends App{
    println("Hello, wellcome to ctodo")
    var taskspool=FileandTask.getTasks()
    taskspool= CURD.create("test what can this do,now",taskspool)
    taskspool.map(Tasktoolkit.show).map(println)
}