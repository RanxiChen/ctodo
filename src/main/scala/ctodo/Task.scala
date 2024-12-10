package ctodo
object db_config{
    //loaction where I store data
    val db_path:os.Path=os.pwd/"misc"
    //I will store all of  tasks in 
    // file named 'todo.db'
    val db_file:os.Path={
        if (os.exists(db_path/"todo.db")){
            db_path/"todo.db"
        } else {
            os.write(db_path/"todo.db","")
            db_path/"todo.db"
        }
    }
}
//3 kinds of task
sealed abstract trait Task
case class todo(thing:String) extends Task
case class done(thing:String) extends Task
case class open(thing:String) extends Task

object Tasktoolkit{
    // use 'show' to show the task to people
    def show(item:Task):String ={
        item match {
            case todo(thing) => "[todo] " + thing
            case done(thing) => "[done] " + thing
            case open(thing) => "[open] " + thing
        }
    }
    //use TaskcodetoString to convert Task item 
    //to string,which will store in db file
    def TaskcodetoString(item:Task):String = {
        item match {
            case todo(thing) => "!#! 0 " + thing
            case done(thing) => "!#! 1 " + thing
            case open(thing) => "!#! 2 " + thing
        }
    }
    //use TaskdecoderfromString to convert extract string
    // in db file representing Task item
    def TaskdecoderfromString(str:String):Option[Task] ={
        str match {
            case task if task.startsWith("!#! 0 ") => Some(todo(task.substring(6)))
            case task if task.startsWith("!#! 1 ") => Some(done(task.substring(6)))
            case task if task.startsWith("!#! 2 ") => Some(open(task.substring(6)))
            case _ => None
        }
    }
}