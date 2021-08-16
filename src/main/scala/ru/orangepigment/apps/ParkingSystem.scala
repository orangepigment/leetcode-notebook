package ru.orangepigment.apps

/**
 * [[https://leetcode.com/problems/design-parking-system/]]
 *
 * Your ParkingSystem object will be instantiated and called as such:
 * var obj = new ParkingSystem(big, medium, small)
 * var param_1 = obj.addCar(carType)
 */
class ParkingSystem(private var _big: Int, private var _medium: Int, private var _small: Int) {

  def addCar(carType: Int): Boolean = {
      carType match {
        case 1 if _big > 0 =>
          _big -= 1
          true
        case 2 if _medium > 0 =>
          _medium -= 1
          true
        case 3 if _small > 0 =>
          _small -= 1
          true
        case _ => false
      }
  }

}


