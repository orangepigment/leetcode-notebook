package ru.orangepigment.strings

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/is-subsequence/]]
 */
object IsSubsequence {

  def isSubsequence(s: String, t: String): Boolean = {
    if (s.isEmpty) {
      true
    } else if (t.isEmpty) {
      false
    } else {
      isSubsequenceRec(s, t)
    }
  }

  @tailrec
  def isSubsequenceRec(
                        s: String,
                        t: String,
                        si: Int = 0,
                        ti: Int = 0
                      ): Boolean = {
    if (si == s.length) {
      true
    } else if (ti == t.length) {
      false
    } else {
      if (s(si) == t(ti)) {
        isSubsequenceRec(s, t, si + 1, ti + 1)
      } else {
        isSubsequenceRec(s, t, si, ti + 1)
      }
    }
  }

}
