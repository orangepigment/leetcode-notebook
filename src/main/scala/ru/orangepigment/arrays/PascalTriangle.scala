package ru.orangepigment.arrays

import scala.annotation.tailrec

object PascalTriangle {

  def main(args: Array[String]): Unit = {
    println(generate(5))
  }

  def generate(numRows: Int): List[List[Int]] =
    @tailrec
    def loop(currentRow: Int = 1, acc: List[List[Int]] = List.empty): List[List[Int]] = {
      val newAcc =
        if currentRow == 1 then List(List(1))
        else
          val row =
            for i <- 0 until currentRow
              yield if i == 0 || i == currentRow - 1 then 1
              else acc(currentRow - 2)(i - 1) + acc(currentRow - 2)(i)
          acc :+ row.toList
      if numRows == currentRow then newAcc else loop(currentRow + 1, newAcc)
    }

    loop()

}
