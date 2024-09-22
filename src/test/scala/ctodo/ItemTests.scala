package ctodo
import org.scalatest.funsuite.AnyFunSuite

class ItemSuite extends AnyFunSuite{
    test("show in item tool kit"){
        assert(Itemtoolkit.show(todo("123"))=="[todo] 123")
        assert(Itemtoolkit.show(done("567"))=="[done] 567")
    }
    test("write list to file"){
    }
}