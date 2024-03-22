package store.model.checkout

import store.model.items.{Item, LoyaltySale, Modifier, SalesTax, State}

class SelfCheckout {

  var state:State = new Scanned(this)

  var count: Int = 0


  var Barcode: String = ""

  var store: Map[String, Item] = Map()
  var emptyString: String = ""
  var cartLst: List[Item] = List()

  var displaystring1: String = ""
  var displaystring2: String = ""
  var itemdescription: String = ""

  var item: Item = new Item("",0.0)

  var amount1: Double = 0.0

  var Subtotal: Double = 0.0
  var Tax: Double = 0.0
  var Total: Double = 0.0

  //var loyaltyOff: Modifier = new LoyaltySale(20)




  def addItemToStore(barcode: String, item: Item): Unit = {
    this.store += (barcode -> item)
  }

  def numberPressed(number: Int): Unit = {
    this.state.numberPressed(number)
  }

  def clearPressed(): Unit = {
    this.state.clearPressed()
  }

  def enterPressed(): Unit = {
    this.state.enterPressed()
  }

  def checkoutPressed(): Unit = {
    this.state.checkoutPressed()
  }

  def cashPressed(): Unit = {
    this.state.cashPressed()
  }

  def creditPressed(): Unit = {
    this.state.creditPressed()
  }

  def loyaltyCardPressed(): Unit = {
    this.state.loyaltyCardPressed()
  }

  def displayString(): String = {
    this.emptyString
    // TODO
  }

  def itemsInCart(): List[Item] = {
    cartLst
  }

  def subtotal(): Double = {
    this.state.subtotal()
  }

  def tax(): Double = {
    this.state.tax()
  }

  def total(): Double = {
    this.state.total()
  }

  def prepareStore(): Unit = {

    // Example usage:
    //val testItem: Item = new Item("test item", 100.0)
    //this.addItemToStore("472", testItem)
    var loyaltyOff: Modifier = new LoyaltySale(20)
    var loyaltyOff1: Modifier = new LoyaltySale(10)


    var taxRate: SalesTax = new SalesTax(10.0)
    val apple: Item = new Item("Apple",10)
    val rtx3050:Item = new Item("rtx3050",500)
    val rtx3060:Item = new Item("rtx3060",1000)
    val rtx3070:Item = new Item("rtx3070",2000)
    val rtx3080: Item = new Item("rtx3080", 3000)
    val rtx0000: Item = new Item("rtx0000",100000)


    rtx3050.addModifier(modifier = taxRate)
    rtx3060.addModifier(modifier = taxRate)
    rtx3070.addModifier(modifier = taxRate)
    rtx3080.addModifier(modifier = taxRate)
    rtx0000.addModifier(modifier = taxRate)
    apple.addModifier(modifier = taxRate)

    rtx3050.addModifier(modifier = loyaltyOff)
    rtx3060.addModifier(modifier = loyaltyOff)
    rtx3070.addModifier(modifier = loyaltyOff)
    rtx3080.addModifier(modifier = loyaltyOff)
    rtx0000.addModifier(modifier = loyaltyOff1)
    apple.addModifier(modifier = loyaltyOff)


    addItemToStore("1",apple)
    addItemToStore("3050",rtx3050)
    addItemToStore("3060",rtx3060)
    addItemToStore("3070",rtx3070)
    addItemToStore("3080",rtx3080)
    addItemToStore("0000",rtx0000)
  }

}
