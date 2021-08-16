package ru.orangepigment.strings

/**
 * [[https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/]]
 */
object AreAlmostEqual {

  def areAlmostEqual(s1: String, s2: String): Boolean = {
    var firstDiffIndex = -1
    var swapDone = false
    for (i <- s1.indices) {
      if (s1(i) != s2(i)) {
        if (firstDiffIndex == -1) {
          firstDiffIndex = i
        } else if (swapDone) {
          return false
        } else if (s1(firstDiffIndex) == s2(i) && s1(i) == s2(firstDiffIndex)) {
          swapDone = true
        } else {
          return false
        }
      }
    }

    firstDiffIndex == -1 || swapDone
  }

}
