package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/squares-of-a-sorted-array/]]
 */
object SortedSquares {

  def sortedSquares(nums: Array[Int]): Array[Int] = {
    val res = new Array[Int](nums.length)
    var iRes = res.length - 1
    var first = 0
    var last = nums.length - 1
    while (iRes >= 0) {
      if (Math.abs(nums(first)) > Math.abs(nums(last))) {
        res(iRes) = nums(first) * nums(first)
        iRes -= 1
        first += 1
      } else {
        res(iRes) = nums(last) * nums(last)
        iRes -= 1
        last -= 1
      }
    }
    res
  }
}
