package ru.orangepigment.data

/**
 * [[https://leetcode.com/problems/design-circular-deque/]]
 *
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = new MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */
class MyCircularDeque(_k: Int) {

  /** Initialize your data structure here. Set the size of the deque to be k. */
  private var size = 0
  private val data = new Array[Int](_k)
  private var first = 0
  private var next = 0

  /** Adds an item at the front of Deque. Return true if the operation is successful. */
  def insertFront(value: Int): Boolean = {
    if (!isFull()) {
      first = decrementIndex(first)
      data(first) = value
      size += 1
      true
    } else {
      false
    }
  }

  /** Adds an item at the rear of Deque. Return true if the operation is successful. */
  def insertLast(value: Int): Boolean = {
    if (!isFull()) {
      data(next) = value
      next = incrementIndex(next)
      size += 1
      true
    } else {
      false
    }
  }

  /** Deletes an item from the front of Deque. Return true if the operation is successful. */
  def deleteFront(): Boolean = {
    if (!isEmpty()) {
      first = incrementIndex(first)
      size -= 1
      true
    } else {
      false
    }
  }

  /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
  def deleteLast(): Boolean = {
    if (!isEmpty()) {
      next = decrementIndex(next)
      size -= 1
      true
    } else {
      false
    }
  }

  /** Get the front item from the deque. */
  def getFront(): Int = {
    if (!isEmpty()) data(first) else -1
  }

  /** Get the last item from the deque. */
  def getRear(): Int = {
    if (!isEmpty()) data(decrementIndex(next)) else -1
  }

  /** Checks whether the circular deque is empty or not. */
  def isEmpty(): Boolean = {
    size == 0
  }

  /** Checks whether the circular deque is full or not. */
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

  private def decrementIndex(index: Int): Int = {
    if (index - 1 > -1) {
      index - 1
    } else {
      _k - 1
    }
  }

}
