package ru.orangepigment.apps

/**
 * [[https://leetcode.com/problems/min-cost-climbing-stairs/]]
 */
object MinCostClimbingStairs {

  def minCostClimbingStairs(cost: Array[Int]): Int = {
    val cache = Array.fill(cost.length)(-1)
    Math.min(dp(0, cost, cache), dp(1, cost, cache))
  }

  def dp(i: Int, cost: Array[Int], cache: Array[Int]): Int = {
    if (i >= cost.length) {
      0
    } else if (cache(i) != -1) {
      cache(i)
    } else {
      cache(i) = cost(i) + Math.min(dp(i + 1, cost, cache), dp(i + 2, cost, cache))
      cache(i)
    }
  }

}
