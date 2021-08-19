package ru.orangepigment.strings

/**
 * [[https://leetcode.com/problems/wildcard-matching/]]
 */
object WildcardMatch {

  def isMatch(s: String, p: String): Boolean = {
    val cache: Array[Array[Option[Boolean]]] = Array.fill(p.length)(Array.fill(s.length)(None))
    dp(p, s, cache)
  }

  def dp(
          p: String,
          s: String,
          cache: Array[Array[Option[Boolean]]],
          pi: Int = 0,
          si: Int = 0
        ): Boolean = {
    if (pi == p.length) {
      if (si == s.length) true else false
    } else if (si == s.length) {
      // The string is over, we can scan the pattern further, e.g. s = "a", p = "***"
      if (p(pi) == '*') dp(p, s, cache, pi + 1, si) else false
    } else if (cache(pi)(si).nonEmpty) {
      cache(pi)(si).get
    } else {
      cache(pi)(si) =
        p(pi) match {
          case '?' => Some(dp(p, s, cache, pi + 1, si + 1))
          case letter if s(si) == letter => Some(dp(p, s, cache, pi + 1, si + 1))
          case '*' => Some(dp(p, s, cache, pi + 1, si) || dp(p, s, cache, pi, si + 1))
          case _ => Some(false)
        }
      cache(pi)(si).get
    }
  }

  def main(args: Array[String]): Unit = {
    isMatch("acdcb", "a*c?b")
  }

}
