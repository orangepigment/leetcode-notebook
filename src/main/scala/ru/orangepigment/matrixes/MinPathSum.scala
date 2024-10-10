package ru.orangepigment.matrixes

object MinPathSum {

  def main(args: Array[String]): Unit = {
    println(minPathSum(
      Array(
        Array(1, 3, 1),
        Array(1, 5, 1),
        Array(4, 2, 1),
      )
    ))
  }

  // Non-stack-safe
  def minPathSum(grid: Array[Array[Int]]): Int = {
    val numRows = grid.length
    val numCols = grid.head.length
    val costs = Array.fill(numRows)(Array.fill(numCols)(-1))

    def loop(
              row: Int = 0,
              col: Int = 0,
              prevRow: Int = 0,
              prevCol: Int = 0
            ): Int = {
      val prevCost: Int =
        if (row == 0 && col == 0) {
          0
        } else costs(prevRow)(prevCol)
      val curCost = prevCost + grid(row)(col)
      if (row == numRows - 1 && col == numCols - 1) curCost
      else {
        costs(row)(col) = curCost
        val goRight = if (col + 1 < numCols) loop(row, col + 1, prevRow = row, prevCol = col) else Int.MaxValue
        val goDown = if (row + 1 < numRows) loop(row + 1, col, prevRow = row, prevCol = col) else Int.MaxValue
        Math.min(goRight, goDown)
      }
    }

    loop()
  }

}
