package ctodo

import org.scalatest.funsuite.AnyFunSuite

class CURDTests extends AnyFunSuite{
  test("create one todo task"){
    var taskpool:Seq[Task]=Seq(todo("123"))
    taskpool=CURD.create("567",taskpool)
    assert(taskpool.length==2)
    assert(taskpool(0)==todo("123"))
    assert(taskpool(1)==todo("567"))
  }
}