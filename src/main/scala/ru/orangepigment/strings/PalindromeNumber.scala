package ru.orangepigment.strings

object PalindromeNumber {

  def isPalindrome(x: Int): Boolean = {
    if (x < 0) {
      false
    } else {
      val s = x.toString
      val l = s.length
      for (i <- 0 until l / 2) {
        if (s(i) != s(l - i - 1)) return false
      }
      true
    }
  }

}
