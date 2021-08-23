package ru.orangepigment.data

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
  private val timestampXHits = mutable.Map.empty[Int, Int]


  /** Record a hit.
   * @param timestamp - The current timestamp (in seconds granularity). */
  def hit(timestamp: Int): Unit = {
    // FixME: it will be nice to add eviction
    timestampXHits += timestamp -> (timestampXHits.getOrElse(timestamp, 0) + 1)
  }

  /** Return the number of hits in the past 5 minutes.
   * @param timestamp - The current timestamp (in seconds granularity). */
  def getHits(timestamp: Int): Int = {
    timestampXHits.keys.filter(_ + 300 > timestamp).toList.map(timestampXHits.apply).sum
  }

}
