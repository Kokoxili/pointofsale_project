package store.model.items

class LoyaltySale(percentof: Double) extends Modifier {


  override def updatePrice(prIce: Double): Double = {
    prIce - (prIce* (percentof/100))

  }

  override def computeTax(prIce1: Double): Double = {
    0.0
  }
}
