package store.model.checkout

import store.model.items.{Item, LoyaltyitemSale, State, itemSale}

class Checkout(stateT : SelfCheckout)extends State (stateT){


  override def addItemToStore(barcode: String, item: Item): Unit = {
  }

  override def numberPressed(number: Int): Unit = {
  }

  override def clearPressed(): Unit = {
  }

  override def enterPressed(): Unit = {
  }

  override def checkoutPressed(): Unit = {
  }

  override def cashPressed(): Unit = {
    stateT.emptyString = ""
    stateT.displaystring1 = ""
    stateT.Barcode = ""
    stateT.cartLst = List()

    stateT.state = new Scanned(stateT)


    for ((a,p) <- this.stateT.store){
      p.itemstate = new itemSale(p)
      p.itemstate
    }



  }

  override def creditPressed(): Unit = {
    stateT.emptyString = ""
    stateT.displaystring1 = ""
    stateT.Barcode = ""
    stateT.cartLst = List()

    stateT.state = new Scanned(stateT)

    for ((a,p) <- this.stateT.store){
      p.itemstate = new itemSale(p)

    }


  }

  override def loyaltyCardPressed(): Unit = {

//    for(k <- 0 until (stateT.cartLst.length)){
//      stateT.cartLst.apply(k).basePrice = stateT.loyaltyOff.updatePrice(stateT.cartLst.apply(k).basePrice)
//    }
//    for(k <- stateT.cartLst){
//      k.basePrice = stateT.loyaltyOff.updatePrice(k.basePrice)
//    }


//    stateT.emptyString = "cash or credit"
//    stateT.Barcode = ""
//    stateT.displaystring1=""

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
    subtotal()+tax()
  }


}

