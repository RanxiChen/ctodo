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
    /*def codetoFile(list:Array[Item]):Unit*/
}