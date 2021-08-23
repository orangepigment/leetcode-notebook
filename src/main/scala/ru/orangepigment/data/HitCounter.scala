package ru.orangepigment.data

import scala.annotation.tailrec
import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/design-hit-counter/]]
 *
 * Your HitCounter object will be instantiated and called as such:
 * var obj = new HitCounter()
 * obj.hit(timestamp)
 * var param_2 = obj.getHits(timestamp)
 */
class HitCounter() {

  /** Initialize your data structure here. */
  private val timestampXHits = mutable.ArrayDeque.empty[(Int, Int)]
  private var total = 0


  /** Record a hit.
   * @param timestamp - The current timestamp (in seconds granularity). */
  def hit(timestamp: Int): Unit = {
    removeOldHits(timestamp)
    timestampXHits.lastOption match {
      case Some((t, counter)) if t == timestamp =>
        timestampXHits.removeLast()
        timestampXHits.append(timestamp -> (counter + 1))
      case _ =>
        timestampXHits.append(timestamp -> 1)
    }
    total += 1
  }

  @tailrec
  private def removeOldHits(timestamp: Int): Unit = {
    timestampXHits.headOption match {
      case Some((t, count)) if t + 300 <= timestamp =>
        timestampXHits.removeHead()
        total -= count
        removeOldHits(timestamp)
      case _ =>
    }
  }

  /** Return the number of hits in the past 5 minutes.
   * @param timestamp - The current timestamp (in seconds granularity). */
  def getHits(timestamp: Int): Int = {
    removeOldHits(timestamp)
    total
  }

}
