package ru.orangepigment.arrays

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/top-k-frequent-elements/]]
 */
object TopKFrequent {

  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
    if (k == nums.length) {
      nums
    } else {
      val numsToFreqs = mutable.Map.empty[Int, Int]
      for (n <- nums) {
        val freq = numsToFreqs.getOrElse(n, 0)
        numsToFreqs += n -> (freq + 1)
      }

      val orderingByFreq = Ordering.by(numsToFreqs.apply).reverse
      val heap = mutable.PriorityQueue.empty[Int](orderingByFreq)
      numsToFreqs.keySet.foreach { num =>
        heap.enqueue(num)
        if (heap.size > k) {
          heap.dequeue()
        }
      }

      heap.take(k).toArray
    }
  }

}
