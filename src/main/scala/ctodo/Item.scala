package ctodo
object log_path{
    val log_path:os.Path=os.pwd/"misc"
}
sealed abstract trait Item
case class todo(thing:String) extends Item
case class done(thing:String) extends Item

object Itemtoolkit{
    def show(item:Item):String ={
        item match {
            case todo(thing) => "[todo] " + thing
            case done(thing) => "[done] " + thing
        }
    }
    def ItemcodetoString(item:Item):String = {
        item match {
            case todo(thing) => "!#! 0 " + thing
            case done(thing) => "!#! 1 " + thing
        }
    }
    def Itemdecoder(str:String):Option[Item] ={
        if(str.substring(0,3) == "!#!"){
            if(str(4)=='0'){
                Some(todo(str.drop(6)))
            }else if(str(4)=='1'){
                Some(done(str.drop(6)))                
            }else{
                None
            }
        }else{
            None
        }        
    }
}
