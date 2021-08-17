package ru.orangepigment.arrays


/**
 * [[https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/]]
 */
object MaxProfitManyTransactions {

  def maxProfit(prices: Array[Int]): Int = {
    var maxProfit = 0

    var buyPrice = prices(0)
    var sellPrice = 0
    for (i <- 1 until prices.length) {
      if (prices(i) > sellPrice && prices(i) > buyPrice) {
        sellPrice = prices(i)
      } else if (prices(i) < sellPrice || prices(i) < buyPrice) {
        // End current transaction
        if (sellPrice - buyPrice > 0) {
          maxProfit += sellPrice - buyPrice
        }

        buyPrice = prices(i)
        sellPrice = 0
      }
    }

    if (sellPrice == 0) { // We don't have stock to sell
      maxProfit
    } else {
      // Sell the remaining stock
      maxProfit + sellPrice - buyPrice
    }
  }

}
