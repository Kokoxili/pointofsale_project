package store.model.items

class Sale(var percentOff: Double) extends Modifier (){

  override def updatePrice(prIce: Double): Double = {
    prIce - (prIce* (percentOff/100))
    }

  override def computeTax(prIce1: Double): Double = {
    0.0
  }

}

