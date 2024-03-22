package tests

import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.items.{BottleDeposit, Item, Modifier, Sale, SalesTax}

class Task2 extends FunSuite{

  val EPSILON: Double = 0.000001

  def compareDoubles(d1: Double, d2: Double): Boolean = {
    Math.abs(d1 - d2) < EPSILON
  }

  test("this is my test1"){
    val taxRate: Modifier = new SalesTax(8.0)
    val bdeposite: Modifier = new BottleDeposit(5.0)
    val saleRate: Modifier = new Sale(20)

    var testSelfCheckout: SelfCheckout = new SelfCheckout()

    val test1: Item = new Item("3070", 200.0)




    test1.addModifier(saleRate)
    test1.addModifier(taxRate)

    assert(compareDoubles(test1.price(),160))
    assert(compareDoubles(test1.price(),160))



    assert(compareDoubles(taxRate.updatePrice(20),20))
    assert(compareDoubles(taxRate.computeTax(20),20*0.08))

    assert(compareDoubles(bdeposite.updatePrice(5),5))
    assert(compareDoubles(bdeposite.computeTax(5),5))

    assert(compareDoubles(saleRate.updatePrice(100), 80))
    assert(compareDoubles(saleRate.computeTax(100), 0.0))

    assert(compareDoubles(testSelfCheckout.subtotal(),0.0))
    assert(compareDoubles(testSelfCheckout.tax(),0.0))


  }

  test("here is my test2"){
    val taxRate: Modifier = new SalesTax(8.0)
    val bdeposite: Modifier = new BottleDeposit(5.0)
    val saleRate: Modifier = new Sale(20)

    var testSelfCheckout: SelfCheckout = new SelfCheckout()

    val test1: Item = new Item("3070", 200.0)




    test1.addModifier(saleRate)
    test1.addModifier(saleRate)
    test1.addModifier(taxRate)

    assert(compareDoubles(test1.price(),128))
    assert(compareDoubles(test1.price(),128))



    assert(compareDoubles(taxRate.updatePrice(20),20))
    assert(compareDoubles(taxRate.computeTax(20),20*0.08))

    assert(compareDoubles(bdeposite.updatePrice(5),5))
    assert(compareDoubles(bdeposite.computeTax(5),5))

    assert(compareDoubles(saleRate.updatePrice(100), 80))
    assert(compareDoubles(saleRate.computeTax(100), 0.0))

    assert(compareDoubles(testSelfCheckout.subtotal(),0.0))
    assert(compareDoubles(testSelfCheckout.tax(),0.0))

  }

  test("this is my test3"){

    val taxRate: Modifier = new SalesTax(8.0)
    val bdeposite: Modifier = new BottleDeposit(5.0)
    val saleRate: Modifier = new Sale(20)

    var testSelfCheckout: SelfCheckout = new SelfCheckout()

    val test1: Item = new Item("3070", 200.0)



    assert(compareDoubles(test1.price(),200))
    assert(compareDoubles(test1.price(),200))



    assert(compareDoubles(taxRate.updatePrice(0.0),0.0))
    assert(compareDoubles(taxRate.computeTax(0.0),0.0))

    assert(compareDoubles(bdeposite.updatePrice(5),5))
    assert(compareDoubles(bdeposite.computeTax(5),5))

    assert(compareDoubles(saleRate.updatePrice(100), 80))
    assert(compareDoubles(saleRate.computeTax(100), 0.0))

    assert(compareDoubles(testSelfCheckout.subtotal(),0.0))
    assert(compareDoubles(testSelfCheckout.tax(),0.0))

  }

  def method1(param: Int, value: Int):Int={
    param/value
  }
  var range = method1(15,4)
  println(range)

}
