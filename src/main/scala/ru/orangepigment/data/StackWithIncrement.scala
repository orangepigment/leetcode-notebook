package ru.orangepigment.data

/**
 * [[https://leetcode.com/problems/design-a-stack-with-increment-operation/]]
 *
 * Your CustomStack object will be instantiated and called as such:
 * var obj = new StackWithIncrement(maxSize)
 * obj.push(x)
 * var param_2 = obj.pop()
 * obj.increment(k,`val`)
 */
class StackWithIncrement(_maxSize: Int) {

  private val data = new Array[Int](_maxSize)
  private var top = -1

  def push(x: Int): Unit = {
    if (size != _maxSize) {
      top += 1
      data(top) = x
    }
  }

  def pop(): Int = {
    if (size != 0) {
      top -= 1
      data(top + 1)
    } else {
      -1
    }
  }

  def increment(k: Int, `val`: Int): Unit = {
    for (i <- 0 to Math.min(k - 1, top)) {
      data(i) += `val`
    }
  }

  def size: Int = top + 1

}
