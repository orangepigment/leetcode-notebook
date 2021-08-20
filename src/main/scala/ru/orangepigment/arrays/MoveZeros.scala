package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/move-zeroes/]]
 */
object MoveZeros {

  def moveZeroes(nums: Array[Int]): Unit = {
    var zeroPointer = -1 // Points to the most left zero
    for (i <- nums.indices) {
      nums(i) match {
        case 0 if zeroPointer == -1 =>
          zeroPointer = i
        case x if x != 0 && zeroPointer != -1 =>
          nums(zeroPointer) = nums(i)
          nums(i) = 0
          zeroPointer += 1
        case _ =>
      }
    }
  }

}
