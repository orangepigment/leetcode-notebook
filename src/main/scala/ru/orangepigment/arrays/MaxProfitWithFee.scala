package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/]]
 */
object MaxProfitWithFee {

  // DP approach
  def maxProfit(prices: Array[Int], fee: Int): Int = {
    var cash = 0
    var hold = -prices(0)

    for (i <- 1 until prices.length) {
      cash = Math.max(cash, hold + prices(i) - fee)
      hold = Math.max(hold, cash - prices(i))
    }

    cash
  }

}
