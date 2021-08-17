package ru.orangepigment.apps

/**
 * [[https://leetcode.com/problems/binary-watch/]]
 */
object BinaryWatch {

  private val HOUR_LEDS = 4
  private val MAX_HOUR_ON_LEDS = 3
  private val MINUTE_LEDS = 6
  private val MAX_MINUTE_ON_LEDS = 5
  private val MAX_ON_LEDS = 8

  // Hours - 4 LEDs, max value is 11 = b 1011, max lighted LEDs = 3
  // Minutes - 6 LEDs, max value is 59 = b 111011, max lighted LEDs = 5
  // Max valid turnedOn = 10
  def readBinaryWatch(turnedOn: Int): List[String] = {
    if (turnedOn > MAX_ON_LEDS) {
      List.empty[String]
    } else {
      (for {
        hourLedsOn <- 0 to Math.min(MAX_HOUR_ON_LEDS, turnedOn)
      } yield {
        val possibleHours = generateBinaryStrings(hourLedsOn, HOUR_LEDS)
          .map(Integer.parseInt(_, 2))
          .filter(_ <= 11)

        val minutesLedsOn = turnedOn - hourLedsOn
        val possibleMinutes = generateBinaryStrings(minutesLedsOn, MINUTE_LEDS)
          .map(Integer.parseInt(_, 2))
          .filter(_ <= 59)

        for {
          h <- possibleHours
          m <- possibleMinutes
        } yield (h, m)
      }).toList.flatten.sorted.map { case (h, m) => "%d:%02d".format(h, m) }
    }
  }

  private def generateBinaryStrings(numberOfOnes: Int, length: Int): Seq[String] = {
    val digits = "0" * (length - numberOfOnes) + "1" * numberOfOnes
    stringPermutations(digits)
  }

  private def stringPermutations(str: String): Seq[String] = {
    if (str.length == 1) {
      Seq(str)
    } else {
      stringPermutations(str.tail).distinct.flatMap { p =>
        for (i <- 0 to p.length) yield
          p.substring(0, i) + str.head + p.substring(i, p.length)
      }.distinct
    }
  }

}
