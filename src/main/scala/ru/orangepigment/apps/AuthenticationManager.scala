package ru.orangepigment.apps

import scala.collection.mutable

/**
 * https://leetcode.com/problems/design-authentication-manager/
 *
 * Your AuthenticationManager object will be instantiated and called as such:
 * var obj = new AuthenticationManager(timeToLive)
 * obj.generate(tokenId,currentTime)
 * obj.renew(tokenId,currentTime)
 * var param_3 = obj.countUnexpiredTokens(currentTime)
 */
class AuthenticationManager(_timeToLive: Int) {

  private val tokensXTtl = mutable.HashMap.empty[String, Int]

  def generate(tokenId: String, currentTime: Int): Unit = {
    tokensXTtl += tokenId -> currentTime
  }

  def renew(tokenId: String, currentTime: Int): Unit = {
    if (tokensXTtl.getOrElse(tokenId, -_timeToLive) + _timeToLive > currentTime) {
      tokensXTtl += tokenId -> currentTime
    }
  }

  def countUnexpiredTokens(currentTime: Int): Int = {
    // ToDo: delete expired tokens?
    tokensXTtl.count { case (_, generationTime) =>
      generationTime + _timeToLive > currentTime
    }
  }

}
