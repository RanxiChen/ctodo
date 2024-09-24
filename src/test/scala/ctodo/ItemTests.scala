package ctodo
import org.scalatest.funsuite.AnyFunSuite

class ItemSuite extends AnyFunSuite{
    test("show in item tool kit"){
        assert(Itemtoolkit.show(todo("123"))=="[todo] 123")
        assert(Itemtoolkit.show(done("567"))=="[done] 567")
    }
    test("write item to string"){
        assert(Itemtoolkit.ItemcodetoString(todo("123"))=="!#! 0 123")
        assert(Itemtoolkit.ItemcodetoString(done("567"))=="!#! 1 567")
    }
    test("decode from string"){
        assert(Itemtoolkit.Itemdecoder("!#! 0 123") == Some(todo("123")))
        assert(Itemtoolkit.Itemdecoder("!#! 1 567") == Some(done("567")))
        assert(Itemtoolkit.Itemdecoder("123")== None)
    }
}