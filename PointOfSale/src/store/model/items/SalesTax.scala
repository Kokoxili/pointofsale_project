package store.model.items

class SalesTax(var percentTax: Double) extends Modifier{

  override def updatePrice(prIce: Double): Double = {
    prIce
  }

  override def computeTax(prIce1: Double): Double = {
    prIce1 * this.percentTax * 0.01
  }
}
