package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/permutations/]]
 */
object Permutations {

  def permute(nums: Array[Int]): List[List[Int]] = {
    permutations(nums)
  }

  private def permutations(nums: Array[Int]): List[List[Int]] = {
    if (nums.length == 1) {
      List(nums.toList)
    } else {
      permutations(nums.tail).flatMap { p =>
        for (i <- 0 to nums.length) yield
          p.slice(0, i) ++: nums.head +: p.slice(i, p.length)
      }.distinct
    }
  }

}
