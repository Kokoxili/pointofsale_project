package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.{Item, LoyaltySale, Modifier, SalesTax}


class ApplicationObjective extends FunSuite {
  val EPSILON: Double = 0.000001

  def compareDoubles(d1: Double, d2: Double): Boolean = {
    Math.abs(d1 - d2) < EPSILON
  }


  val testSelfCheckout: SelfCheckout = new SelfCheckout()

  val rtx3050: Item = new Item("rtx3050",500.0)
  val rtx3060: Item = new Item("rtx3060",1000.0)
  val rtx3070: Item = new Item("rtx3070",2000.0)
  val rtx3080: Item = new Item("rtx3080", 3000.0)
  val rtx0000: Item = new Item("rtx0000",1000000.0)

  val loyaltyOFF = new LoyaltySale(10)

  rtx3050.addModifier(modifier = loyaltyOFF)
  rtx3060.addModifier(modifier = loyaltyOFF)
  rtx3070.addModifier(modifier = loyaltyOFF)
  rtx3080.addModifier(modifier = loyaltyOFF)
  rtx0000.addModifier(modifier = loyaltyOFF)

  testSelfCheckout.addItemToStore("3050",rtx3050)
  testSelfCheckout.addItemToStore("3060",rtx3060)
  testSelfCheckout.addItemToStore("3070",rtx3070)
  testSelfCheckout.addItemToStore("3080",rtx3080)
  testSelfCheckout.addItemToStore("0000",rtx0000)




  test("1"){

    testSelfCheckout.numberPressed(3)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(5)
    testSelfCheckout.numberPressed(0)

    testSelfCheckout.enterPressed()
    testSelfCheckout.checkoutPressed()
    testSelfCheckout.loyaltyCardPressed()

    println(testSelfCheckout.itemsInCart()(0).price())
    assert(testSelfCheckout.itemsInCart()(0).description() == "rtx3050")
    assert(compareDoubles(testSelfCheckout.itemsInCart()(0).price(),450))
//    println(testSelfCheckout.itemsInCart()(0).price())


    testSelfCheckout.cashPressed()
  }

  test("2"){

    testSelfCheckout.numberPressed(3)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(5)
    testSelfCheckout.numberPressed(0)

    testSelfCheckout.enterPressed()
    testSelfCheckout.checkoutPressed()

    assert(testSelfCheckout.itemsInCart()(0).description() == "rtx3050")
    assert(compareDoubles(testSelfCheckout.itemsInCart()(0).price(),500))

    testSelfCheckout.creditPressed()


  }

//  test("3"){
//    testSelfCheckout.numberPressed(3)
//    testSelfCheckout.numberPressed(0)
//    testSelfCheckout.numberPressed(7)
//    testSelfCheckout.numberPressed(0)
//
//    testSelfCheckout.enterPressed()
//
//    testSelfCheckout.loyaltyCardPressed()
//    testSelfCheckout.loyaltyCardPressed()
//
//
//    testSelfCheckout.checkoutPressed()
//
//    assert(testSelfCheckout.itemsInCart()(0).description() == "rtx3070")
//    println(testSelfCheckout.itemsInCart()(0).price())
//    assert(compareDoubles(testSelfCheckout.itemsInCart()(0).price(),1800))
//    testSelfCheckout.creditPressed()
//
//
//  }

}
