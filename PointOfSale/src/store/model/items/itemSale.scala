package store.model.items

class itemSale( item: Item)extends itemState(item) {

  override def description(): String = {
    this.item.desCription
  }

  override def price(): Double = {

    var itemPrice = item.basePrice

    for (item1 <- item.modifierList.filter(_.isInstanceOf[Sale])){
       itemPrice = item1.updatePrice(itemPrice)

    }
    for (item1 <- item.modifierList.filter(_.isInstanceOf[SalesTax])){
       itemPrice = item1.updatePrice(itemPrice)

    }
    itemPrice


  }

  override def setBasePrice(number: Double): Unit = {
    item.basePrice = this.item.basePrice*0 + number

  }

  override def addModifier(modifier: Modifier): Unit ={
    item.modifierList +:= modifier

  }

  override def tax(): Double = {
    var taxprice: Double = 0.0
    for (i <- item.modifierList){
      taxprice += i.computeTax(price())
    }
    taxprice
  }

}
