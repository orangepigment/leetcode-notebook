package ru.orangepigment.strings

import scala.collection.mutable.ListBuffer

object IntegerToEnglish {

  val quantities: Array[String] = Array(
    "",
    "Thousand",
    "Million",
    "Billion"
  )

  val numsToWords = Map(
    '1' -> "One",
    '2' -> "Two",
    '3' -> "Three",
    '4' -> "Four",
    '5' -> "Five",
    '6' -> "Six",
    '7' -> "Seven",
    '8' -> "Eight",
    '9' -> "Nine"
  )

  val numsToDecies = Map(
    '2' -> "Twenty",
    '3' -> "Thirty",
    '4' -> "Forty",
    '5' -> "Fifty",
    '6' -> "Sixty",
    '7' -> "Seventy",
    '8' -> "Eighty",
    '9' -> "Ninety"
  )

  val groupToSkip = Seq(0, 0, 0)

  def numberToWords(num: Int): String = {
    if (num == 0) {
      return "Zero"
    }

    val acc = ListBuffer.empty[String]
    val groups = num.toString.reverse.grouped(3).map(_.reverse).toSeq.reverse

    val maxRank = groups.size - 1
    for ((g, gi) <- groups.zipWithIndex if g != "000") {
      var i = 0
      while (i < g.length) {
        val curChar = g(i)
        curChar match {
          case '0' =>
          case _ =>
            val digitNum = g.length - i
            digitNum match {
              case 1 => acc.addOne(numsToWords(curChar))
              case 2 if curChar == '1' =>
                i += 1
                g(i) match {
                  case '0' => acc.addOne("Ten")
                  case '1' => acc.addOne("Eleven")
                  case '2' => acc.addOne("Twelve")
                  case '3' => acc.addOne("Thirteen")
                  case '4' => acc.addOne("Fourteen")
                  case '5' => acc.addOne("Fifteen")
                  case '6' => acc.addOne("Sixteen")
                  case '7' => acc.addOne("Seventeen")
                  case '8' => acc.addOne("Eighteen")
                  case '9' => acc.addOne("Nineteen")
                }

              case 2 => acc.addOne(numsToDecies(curChar))
              case 3 => acc.addOne(s"${numsToWords(curChar)} Hundred")
            }
        }
        i += 1
      }
      acc.addOne(quantities(maxRank - gi))
    }
    acc.mkString(" ").stripSuffix(" ")
  }

}
