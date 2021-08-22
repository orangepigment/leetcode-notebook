package ru.orangepigment.strings

/**
 * [[https://leetcode.com/problems/valid-palindrome/]]
 */
object ValidPalindrome {

  def isPalindrome(s: String): Boolean = {
    var left = 0
    var right = s.length - 1
    while (left != right) {
      while (left < s.length && !s(left).isLetterOrDigit) {
        left += 1
      }

      if (left == s.length) {
        return true
      }

      while (!s(right).isLetterOrDigit) {
        right -= 1
      }

      if (s(left).toUpper != s(right).toUpper) {
        return false
      }
      left += 1
      right -= 1
    }
    true
  }

}
