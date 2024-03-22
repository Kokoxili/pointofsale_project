package store.model.items

abstract class Modifier{

  def updatePrice( prIce: Double): Double

  def computeTax(prIce1: Double): Double

}


