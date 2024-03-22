package store.model.checkout

import store.model.items.{Item, LoyaltySale, LoyaltyitemSale, State}

class Scanned(stateT: SelfCheckout) extends State(stateT){


  def getorelseVal(): Item = {
    val error:Item = new Item("error",0.0)
    val erit:Item= stateT.store.getOrElse(stateT.displaystring1, error)
    erit
  }

//  def receitm(): Item = {
//    val newit: Item = new Item(stateT.displaystring2, stateT.amount1)
//    newit
//  }
//
//  def nsubtotal(): Item = {
//    val tx: Item = new Item("subtotal", stateT.Subtotal)
//    tx
//  }
//
//  def ntax(): Item = {
//    val tx: Item = new Item("tax", stateT.Tax)
//    tx
//  }
//
//  def ntotal(): Item = {
//    val tx: Item = new Item("total", stateT.Total)
//    tx
//  }

  override def addItemToStore(barcode: String, item: Item): Unit = {
  }

  override def numberPressed(number: Int): Unit = {
    stateT.Barcode += number.toString
    stateT.emptyString = stateT.Barcode
    stateT.displaystring1 = stateT.Barcode

  }

  override def clearPressed(): Unit = {
    stateT.displaystring1 = ""
    stateT.Barcode = ""
    stateT.emptyString = ""


  }

  override def enterPressed(): Unit = {

    val error:Item = new Item("error",0.0)
    val erit:Item= stateT.store.getOrElse(stateT.displaystring1, error)


    stateT.itemdescription = getorelseVal().description()

    stateT.cartLst = stateT.cartLst :+ erit

    stateT.Barcode = ""
    stateT.emptyString = ""
//    stateT.displaystring1 = ""




  }

  override def checkoutPressed(): Unit = {

    stateT.emptyString = "cash or credit"
    stateT.Barcode = ""
    stateT.displaystring1 = ""
    stateT.state = new Checkout(stateT)
  }

  override def cashPressed(): Unit = {

  }

  override def creditPressed(): Unit = {

  }

  override def loyaltyCardPressed(): Unit = {

//    for (goods <- stateT.store.keys){
//      stateT.store(goods).addModifier(modifier = stateT.loyaltyOff)
//
//    }

//    for(k <- stateT.cartLst){
//      k.basePrice = stateT.loyaltyOff.updatePrice(k.basePrice)
//    }

    for ((a,p) <- this.stateT.store){
      p.itemstate = new LoyaltyitemSale(p)

    }

  }

  override def displayString(): String = {
    stateT.emptyString

  }

  override def itemsInCart(): List[Item] = {
    stateT.cartLst


  }

  override def subtotal(): Double = {
    stateT.Subtotal = 0.0
    for (itm <- stateT.cartLst){
      stateT.Subtotal += itm.price()
    }
    stateT.Subtotal

  }

  override def tax(): Double = {
    stateT.Tax = 0.0
    for (itm <- stateT.cartLst){
      stateT.Tax += itm.tax()
    }
    stateT.Tax

  }

  override def total(): Double = {
    tax() + subtotal()
  }


}

