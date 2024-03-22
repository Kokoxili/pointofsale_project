package store.model.items

class BottleDeposit(var ttamount: Double) extends Modifier{

  override def updatePrice(prIce: Double): Double = {
    prIce
  }

  override def computeTax(prIce1: Double): Double = {
    this.ttamount
  }

}
