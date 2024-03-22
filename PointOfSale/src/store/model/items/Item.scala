package store.model.items

class Item (val desCription: String, var basePrice: Double){

  // TODO: Complete this class according to the features listed in the HW document

  var modifierList: List[Modifier] = List()

  var itemstate: itemState = new itemSale(this)



  def description(): String = {
    itemstate.description()
  }

  def price(): Double = {
    itemstate.price()
  }

  def setBasePrice(number: Double): Unit = {
    itemstate.setBasePrice(number)

  }

  def addModifier(modifier: Modifier): Unit ={
    itemstate.addModifier(modifier)

  }

  def tax(): Double = {
    itemstate.tax()
  }

  def modifierout(): Unit = {
    modifierList = modifierList.drop(1)
  }

}
