package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/best-time-to-buy-and-sell-stock/]]
 */
object MaxProfit {

  def maxProfit(prices: Array[Int]): Int = {
    var maxProfit = 0

    var buyPrice = prices(0)
    var sellPrice = 0
    for (i <- 1 until prices.length) {
      if (prices(i) < buyPrice) {
        if (sellPrice - buyPrice > maxProfit) {
          maxProfit = sellPrice - buyPrice
        }

        buyPrice = prices(i)
        sellPrice = 0
      } else if (prices(i) > sellPrice) {
        sellPrice = prices(i)
      }
    }
    Math.max(maxProfit, sellPrice - buyPrice)
  }

}
