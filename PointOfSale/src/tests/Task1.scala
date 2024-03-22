package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.Item
import store.view.SelfCheckoutGUI.checkoutModel.addItemToStore

class Task1 extends FunSuite {
  val EPSILON: Double = 0.001

  def compareDoubles(d1: Double, d2: Double): Boolean = {
    Math.abs(d1 - d2) < EPSILON
  }

  test("your test name") {
    var testSelfCheckout: SelfCheckout = new SelfCheckout()

    var testItem: Item = new Item("test item", 100.0)

    //testSelfCheckout.addItemToStore("123", testItem)
    assert(testSelfCheckout.displayString()=="")


    assert(compareDoubles(testItem.price(),100))


    testSelfCheckout.numberPressed(3)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(0)
    assert(testSelfCheckout.displayString()=="3070")
    testSelfCheckout.enterPressed()
    testSelfCheckout.enterPressed()
    testSelfCheckout.enterPressed()
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.enterPressed()
    testSelfCheckout.numberPressed(3)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.enterPressed()

    testSelfCheckout.numberPressed(3)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.clearPressed()
    assert(testSelfCheckout.displayString()=="")


    testSelfCheckout.numberPressed(3)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.enterPressed()
    assert(testSelfCheckout.displayString()=="")

    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(7)
    testSelfCheckout.enterPressed()
    assert(testSelfCheckout.displayString()=="")


    // TODO
    val bf: Item = new Item("bf", 3000.0)
    assert(compareDoubles(bf.price(),3000))
    assert(bf.description() == "bf")

    bf.setBasePrice(2000)
    assert(compareDoubles(bf.price(),2000))


  }

  test("test2"){

    var testSelfCheckout: SelfCheckout = new SelfCheckout()

    val rtx3050: Item = new Item("rtx3050",500)
    val rtx3060: Item = new Item("rtx3060",1000)
    val rtx3070: Item = new Item("rtx3070",2000)
    val rtx3080: Item = new Item("rtx3080", 3000)
    val rtx0000: Item = new Item("rtx0000",100000)

    testSelfCheckout.addItemToStore("3050",rtx3050)
    testSelfCheckout.addItemToStore("3060",rtx3060)
    testSelfCheckout.addItemToStore("3070",rtx3070)
    testSelfCheckout.addItemToStore("3080",rtx3080)
    testSelfCheckout.addItemToStore("0000",rtx0000)

    testSelfCheckout.numberPressed(3)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(5)
    testSelfCheckout.numberPressed(0)
    assert(testSelfCheckout.displayString() == "3050")
    testSelfCheckout.enterPressed()
    assert(testSelfCheckout.itemsInCart()(0).description() == "rtx3050")
    assert(compareDoubles(testSelfCheckout.itemsInCart()(0).price(), 500))

    rtx3050.setBasePrice(600)
    assert(compareDoubles(testSelfCheckout.itemsInCart()(0).price(), 600))



    testSelfCheckout.numberPressed(3)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(6)
    testSelfCheckout.numberPressed(0)
    assert(testSelfCheckout.displayString() == "3060")
    testSelfCheckout.enterPressed()
    assert(testSelfCheckout.itemsInCart()(1).description() == "rtx3060")
    assert(compareDoubles(testSelfCheckout.itemsInCart()(1).price(), 1000))

    testSelfCheckout.numberPressed(3)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(6)
    testSelfCheckout.numberPressed(0)
    assert(testSelfCheckout.displayString() == "3060")
    testSelfCheckout.enterPressed()
    assert(testSelfCheckout.itemsInCart()(2).description() == "rtx3060")
    assert(compareDoubles(testSelfCheckout.itemsInCart()(2).price(), 1000))

    testSelfCheckout.numberPressed(3)
    testSelfCheckout.numberPressed(0)
    assert(testSelfCheckout.displayString() == "30")
    testSelfCheckout.enterPressed()
    assert(testSelfCheckout.itemsInCart()(3).description() == "error")
    assert(compareDoubles(testSelfCheckout.itemsInCart()(3).price(), 0.0))

    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(0)
    testSelfCheckout.numberPressed(0)
    assert(testSelfCheckout.displayString() == "0000")
    testSelfCheckout.enterPressed()
    assert(testSelfCheckout.itemsInCart()(4).description() == "rtx0000")
    assert(compareDoubles(testSelfCheckout.itemsInCart()(4).price(), 100000))



  }

}
