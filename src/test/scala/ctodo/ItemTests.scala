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
}