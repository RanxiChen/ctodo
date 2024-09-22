package ctodo
object log_path{
    val log_path:os.Path=os.pwd
}
sealed abstract trait Item
case class todo(thing:String) extends Item
case class done(thing:String) extends Item