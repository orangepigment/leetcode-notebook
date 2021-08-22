package ru.orangepigment.apps

import scala.annotation.tailrec

/**
 * [[https://leetcode.com/problems/first-bad-version]]
 */
object FirstBadVersion {

  def firstBadVersion(n: Int): Int = {
    impl(1, n)
  }

  def isBadVersion(version: Int): Boolean = version >= 1

  @tailrec
  private def impl(minBadVersion: Int, maxBadVersion: Int): Int = {
    if (minBadVersion < maxBadVersion) {
      val middleBadVersion = evalMiddle(minBadVersion, maxBadVersion)

      if (isBadVersion(middleBadVersion)) {
        impl(minBadVersion, middleBadVersion)
      } else {
        impl(middleBadVersion + 1, maxBadVersion)
      }
    } else {
      maxBadVersion
    }
  }

  def evalMiddle(left: Int, right: Int): Int = {
    (right - left) / 2 + left
  }

}
