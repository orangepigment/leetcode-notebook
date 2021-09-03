package ru.orangepigment.strings

/**
 * [[https://leetcode.com/problems/permutation-in-string/]]
 */
object PermutationInString {

  def checkInclusion(s1: String, s2: String): Boolean = {
    s1.length <= s2.length && stringPermutations(s1).exists(s2.contains)
  }

  // FixMe: fails with out of memory - make tailrec or imperative
  def stringPermutations(str: String): Seq[String] = {
    if (str.length == 1) {
      Seq(str)
    } else {
      stringPermutations(str.tail).flatMap { p =>
        for (i <- 0 to p.length) yield
          p.substring(0, i) + str.head + p.substring(i, p.length)
      }
    }
  }

}
