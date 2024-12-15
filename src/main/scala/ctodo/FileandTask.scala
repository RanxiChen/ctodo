package ctodo
// This part will process how read from file
// and write back

object FileandTask {
    def getTasks():Seq[Task]={
        os.read.lines(db_config.db_file).map(Tasktoolkit.TaskdecoderfromString).flatten
    }
    def writeTasks(tasks:Seq[Task]):Unit={
        os.write.over(db_config.db_file,tasks.map(Tasktoolkit.TaskcodetoString).mkString("\n"))
    }
}