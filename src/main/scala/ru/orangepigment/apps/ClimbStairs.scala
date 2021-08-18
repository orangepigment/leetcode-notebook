package ru.orangepigment.apps

/**
 * [[https://leetcode.com/problems/climbing-stairs/]]
 */
object ClimbStairs {

  def climbStairs(n: Int): Int = {
    val cache = Array.fill(n)(-1)
    dp(n, cache)
  }

  def dp(n: Int, cache: Array[Int]): Int = {
    if (n <= 1) {
      1
    } else if (cache(n - 1) != -1) {
      cache(n - 1)
    } else {
      cache(n - 1) = dp(n - 1, cache) + dp(n - 2, cache)
      cache(n - 1)
    }
  }

  def main(args: Array[String]): Unit = {
    val res = climbStairs(45)
    println(res.toString)
  }

}
