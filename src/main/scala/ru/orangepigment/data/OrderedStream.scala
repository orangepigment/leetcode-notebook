package ru.orangepigment.data

import scala.collection.mutable.ListBuffer


/**
 * [[https://leetcode.com/problems/design-an-ordered-stream/]]
 *
 * Your OrderedStream object will be instantiated and called as such:
 * var obj = new OrderedStream(n)
 * var param_1 = obj.insert(idKey,value)
 */

class OrderedStream(_n: Int) {

  private val data = new Array[String](_n)
  private var pointer = 0

  def insert(idKey: Int, value: String): List[String] = {
    data(idKey - 1) = value
    val chunks = ListBuffer.empty[String]
    while (pointer < _n && data(pointer) != null) {
      chunks += data(pointer)
      pointer += 1
    }
    chunks.toList
  }

}
