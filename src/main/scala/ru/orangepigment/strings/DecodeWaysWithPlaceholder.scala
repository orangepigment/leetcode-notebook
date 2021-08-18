package ru.orangepigment.strings

/**
 * [[https://leetcode.com/problems/decode-ways-ii/]]
 */
object DecodeWaysWithPlaceholder {

  // 10 ** 9 + 7
  private val modulo = 1000000007

  def numDecodings(s: String): Int = {
    val cache = Array.fill(s.length)(-1)
    dp(s, cache) % modulo
  }

  def dp(s: String, cache: Array[Int], index: Int = 0): Int = {
    index match {
      case i if i == s.length => 1
      case i if s(i) == '0' => 0
      case i if i == s.length - 1 => if (s(i) == '*') 9 else 1
      case i if cache(i) != -1 => cache(i)
      case i if s(i) == '*' && s(i + 1) == '*' =>
        cache(i) = 9 * dp(s, cache, i + 1) + 15 * dp(s, cache, i + 2)
        cache(i)
      case i if s(i) == '*' =>
        if (s(i + 1).asDigit <= 6) {
          cache(i) = 9 * dp(s, cache, i + 1) + 2 * dp(s, cache, i + 2)
        } else {
          cache(i) = 9 * dp(s, cache, i + 1) + dp(s, cache, i + 2)
        }
        cache(i)
      case i if s(i + 1) == '*' =>
        if (s(i).asDigit == 1) {
          cache(i) = dp(s, cache, i + 1) + 9 * dp(s, cache, i + 2)
        } else if (s(i).asDigit == 2) {
          cache(i) = dp(s, cache, i + 1) + 6 * dp(s, cache, i + 2)
        } else {
          cache(i) = dp(s, cache, i + 1)
        }
        cache(i)
      case i =>
        if (10 * s(i).asDigit + s(i + 1).asDigit <= 26) {
          cache(i) = dp(s, cache, i + 1) + dp(s, cache, i + 2)
        } else {
          cache(i) = dp(s, cache, i + 1)
        }
        cache(i)
    }
  }

}
