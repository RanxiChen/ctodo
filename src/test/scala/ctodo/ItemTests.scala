package ctodo
import org.scalatest.funsuite.AnyFunSuite

class TaskSuite extends AnyFunSuite{
    test("show in item tool kit"){
        assert(Tasktoolkit.show(todo("123"))=="[todo] 123")
        assert(Tasktoolkit.show(done("567"))=="[done] 567")
        assert(Tasktoolkit.show(open("789"))=="[open] 789")
    }
    test("write item to string"){
        assert(Tasktoolkit.TaskcodetoString(todo("123"))=="!#! 0 123")
        assert(Tasktoolkit.TaskcodetoString(done("567"))=="!#! 1 567")
        assert(Tasktoolkit.TaskcodetoString(open("789"))=="!#! 2 789")
    }
    test("decode from string"){
        assert(Tasktoolkit.TaskdecoderfromString("!#! 0 123") == Some(todo("123")))
        assert(Tasktoolkit.TaskdecoderfromString("!#! 1 567") == Some(done("567")))
        assert(Tasktoolkit.TaskdecoderfromString("!#! 2 789") == Some(open("789")))
        assert(Tasktoolkit.TaskdecoderfromString("123")== None)
    }
    test("does db_file exist"){
        assert(os.exists(db_config.db_file))
    }
}
class FileandTaskSuite extends AnyFunSuite{
    test("get tasks from file"){
        os.write.over(db_config.db_file,"!#! 0 123\n!#! 1 456\n!#! 2 789")
        val tasks = FileandTask.getTasks()
        assert(tasks.length == 3)
        assert(tasks(0) == todo("123"))
        assert(tasks(1) == done("456"))
        assert(tasks(2) == open("789"))
    }
    test("write tasks to file"){
        val tasks = Seq(todo("123"),done("456"),open("789"))
        FileandTask.writeTasks(tasks)
        val lines = os.read.lines(db_config.db_file)
        assert(lines.length == 3)
        assert(lines(0) == "!#! 0 123")
        assert(lines(1) == "!#! 1 456")
        assert(lines(2) == "!#! 2 789")
    }
}