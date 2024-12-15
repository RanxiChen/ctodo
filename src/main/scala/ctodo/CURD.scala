package ctodo

object CURD {
    def create(str:String,tasksSeq:Seq[Task]):Seq[Task]= {
       tasksSeq :+ todo(str)
    }

    def read():Unit={
        println("Read a task")
    }
    def update():Unit={
        println("Update a task")
    }
    def delete():Unit={
        println("Delete a task")
    }
}