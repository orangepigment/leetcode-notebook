package ru.orangepigment.data

/**
 * [[https://leetcode.com/problems/design-circular-queue/]]
 *
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = new MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */
class MyCircularQueue(_k: Int) {

  private var size = 0
  private val data = new Array[Int](_k)
  private var first = 0
  private var next = 0

  def enQueue(value: Int): Boolean = {
    if (!isFull()) {
      data(next) = value
      next = incrementIndex(next)
      size += 1
      true
    } else {
      false
    }
  }

  def deQueue(): Boolean = {
    if (!isEmpty()) {
      first = incrementIndex(first)
      size -= 1
      true
    } else {
      false
    }
  }

  def Front(): Int = {
    if (isEmpty()) -1 else data(first)
  }

  def Rear(): Int = {
    if (isEmpty()) {
      -1
    } else {
      val rearIndex = if (next == 0) _k - 1 else next - 1
      data(rearIndex)
    }
  }

  def isEmpty(): Boolean = {
    size == 0
  }

  def isFull(): Boolean = {
    size == _k
  }

  private def incrementIndex(index: Int): Int = {
    if (index + 1 < _k) {
      index + 1
    } else {
      0
    }
  }

}