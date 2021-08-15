package ru.orangepigment.data

import scala.collection.mutable

/**
 * Your ru.orangepigment.data.LFUCache object will be instantiated and called as such:
 * var obj = new ru.orangepigment.data.LFUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

// ToDo: store key usage timestamp
class LFUCache(_capacity: Int) {

  private val cache = mutable.Map.empty[Int, Int]
  private val counter = mutable.Map.empty[Int, Int]
  private var leastUsedKey: Option[Int] = None

  def get(key: Int): Int = {
    val v = cache.getOrElse(key, -1)
    if (v != -1) {
      counter.put(key, counter(key) + 1)
    }
    v
  }

  def put(key: Int, value: Int): Unit = {
    if (cache.size == _capacity && !cache.keySet.contains(key)) {
      leastUsedKey.foreach { k =>
        counter.remove(k)
        cache.remove(k)
      }
      // ToDo: find new least used key? It is the new key by definition? No, it can be another old putten key
    }
    internalPut(key, value)
  }

  private def internalPut(key: Int, value: Int): Unit = {
    cache.put(key, value)
    counter.put(key, counter.getOrElse(key, 0) + 1)

    if (leastUsedKey.map(counter.apply).getOrElse(Int.MaxValue) > counter(key)) {
      leastUsedKey = Some(key)
    }
  }

}
