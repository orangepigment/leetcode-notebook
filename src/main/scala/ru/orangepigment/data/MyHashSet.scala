package ru.orangepigment.data

/**
 * [[https://leetcode.com/problems/design-hashset/]]
 *
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 *
 */
class MyHashSet() {

  /** Initialize your data structure here. */
  private var buckets = new Array[MyListNode[Int]](10) // Better to use BST
  private val maxLoadFactor = 0.75
  private var size = 0


  def add(key: Int): Unit = {
    val bucket = buckets(bucketIndex(key))
    if (bucket == null) {
      buckets(bucketIndex(key)) = new MyListNode[Int](key)
      size += 1
    } else {
      var currentBucket = bucket
      var prevBucket = bucket

      while (currentBucket != null) {
        if (currentBucket.x == key) {
          // The key already exists
          return
        } else {
          prevBucket = currentBucket
          currentBucket = currentBucket.next
        }
      }

      prevBucket.next = new MyListNode[Int](key)
      size += 1
    }

    if (loadFactor > maxLoadFactor) {
      resize()
    }
  }

  def remove(key: Int): Unit = {
    val bucket = buckets(bucketIndex(key))
    if (bucket != null) {
      if (bucket.x == key) {
        buckets(bucketIndex(key)) = bucket.next
        size -= 1
      } else {
        var currentBucket = bucket.next
        var prevBucket = bucket

        while (currentBucket != null) {
          if (currentBucket.x == key) {
            prevBucket.next = currentBucket.next
            size -= 1
          } else {
            prevBucket = currentBucket
            currentBucket = currentBucket.next
          }
        }
      }
    }
  }

  /** Returns true if this set contains the specified element */
  def contains(key: Int): Boolean = {
    val bucket = buckets(bucketIndex(key))
    var currentBucket = bucket
    while (currentBucket != null) {
      if (currentBucket.x == key) {
        return true
      } else {
        currentBucket = currentBucket.next
      }
    }
    false
  }

  private def bucketIndex(key: Int) = key % buckets.length

  private def loadFactor: Double = size / buckets.length

  private def resize(): Unit = {
    val oldBuckets = buckets
    val newBucketsNum = buckets.length * 2
    buckets = new Array[MyListNode[Int]](newBucketsNum)
    size = 0
    for (ob <- oldBuckets) {
      var currentNode = ob
      while (currentNode != null) {
        add(currentNode.x)
        currentNode = currentNode.next
      }
    }
  }

}
