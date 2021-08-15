package ru.orangepigment.data

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/lru-cache/]]
 *
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
class LRUCache(_capacity: Int) {

  private val cache = mutable.LinkedHashMap.empty[Int, Int]

  def get(key: Int): Int = {
    cache.get(key) match {
      case Some(value) =>
        cache.remove(key)
        cache.put(key, value)
        value
      case None => -1
    }
  }

  def put(key: Int, value: Int): Unit = {
    if (cache.contains(key)) {
      cache.remove(key)
    } else if (cache.size == _capacity) {
      // Remove least recently used key
      cache.remove(cache.head._1)
    }
    cache.put(key, value)
  }

}
