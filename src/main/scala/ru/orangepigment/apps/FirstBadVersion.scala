package ru.orangepigment.apps

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/first-bad-version]]
 */
object FirstBadVersion {

  def firstBadVersion(n: Int): Int = {
    impl(n / 2, n)
  }

  def isBadVersion(version: Int): Boolean = version >= 4

  @tailrec
  private def impl(versionToCheck: Int, minBadVersion: Int): Int = {
    if (minBadVersion - versionToCheck == 1) {
      if (isBadVersion(versionToCheck)) versionToCheck else minBadVersion
    } else if (isBadVersion(versionToCheck)) {
      impl(versionToCheck / 2, versionToCheck)
    } else {
      impl(evalMiddle(versionToCheck, minBadVersion), minBadVersion)
    }
  }

  def evalMiddle(left: Int, right: Int): Int = {
    (right - left) / 2 + left
  }

}
