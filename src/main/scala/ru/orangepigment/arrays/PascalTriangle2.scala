package ru.orangepigment.arrays

import scala.annotation.tailrec

object PascalTriangle2 {

  def main(args: Array[String]): Unit = {
    println(getRow(33))
  }

  def getRow(rowIndex: Int): List[Int] = {
    val numRows = rowIndex + 1

    @tailrec
    def loop(currentRow: Int = 1, acc: List[List[Int]] = List.empty): List[List[Int]] = {
      val newAcc =
        if (currentRow == 1) List(List(1))
        else
          val row =
            for i <- 0 until currentRow
              yield if (i == 0 || i == currentRow - 1) 1
              else acc(currentRow - 2)(i - 1) + acc(currentRow - 2)(i)
          acc :+ row.toList
      if (numRows == currentRow) newAcc else loop(currentRow + 1, newAcc)
    }

    loop(numRows)(rowIndex)
  }

}
