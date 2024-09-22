package ctodo
sealed abstract trait Item
case class todo(thing:String) extends Item
case class done(thing:String) extends Item

object Manager