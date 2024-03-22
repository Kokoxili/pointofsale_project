package store.model.items

import store.model.checkout.{ItemsInCart, SelfCheckout}

abstract class State(stateT: SelfCheckout) {

  def addItemToStore(barcode:String,item:Item):Unit

  def numberPressed(number: Int): Unit

  def clearPressed(): Unit

  def enterPressed(): Unit

  def checkoutPressed(): Unit

  def cashPressed(): Unit

  def creditPressed(): Unit

  def loyaltyCardPressed(): Unit

  def displayString(): String

  def itemsInCart(): List[Item]

  def subtotal(): Double

  def tax(): Double

  def total(): Double




}
