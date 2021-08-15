package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/rotate-array/]]
 */
object RotateArray {

  def rotate(nums: Array[Int], k: Int): Unit = {
    val rotations = k % nums.length
    if (rotations != 0) {
      var rTargetI = 0
      for (ri <- nums.length - rotations until nums.length) {
        val currentRotatedElem = nums(ri)

        for (j <- ri until rTargetI by -1) {
          nums(j) = nums(j - 1)
        }

        nums(rTargetI) = currentRotatedElem
        rTargetI += 1
      }
    }
  }

}
