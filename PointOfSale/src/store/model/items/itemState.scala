package store.model.items

abstract class itemState(var item: Item) {

  def description(): String

  def price(): Double

  def setBasePrice(number: Double): Unit

  def addModifier(modifier: Modifier): Unit

  def tax(): Double

}
