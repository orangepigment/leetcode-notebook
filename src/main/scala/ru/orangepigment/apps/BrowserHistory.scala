package ru.orangepigment.apps

/**
 * [[https://leetcode.com/problems/design-browser-history]]
 *
 * Your BrowserHistory object will be instantiated and called as such:
 * var obj = new BrowserHistory(homepage)
 * obj.visit(url)
 * var param_2 = obj.back(steps)
 * var param_3 = obj.forward(steps)
 *
 * @param _homepage the page loaded at the launch of the browser
 */
class BrowserHistory(_homepage: String) {

  private var currentPage = new Page(_homepage)

  def visit(url: String): Unit = {
    val newPage = new Page(url, currentPage)
    currentPage.next = newPage
    currentPage = newPage
  }

  def back(steps: Int): String = {
    var leftSteps = steps
    while (leftSteps > 0 && currentPage.prev != null) {
      leftSteps -= 1
      currentPage = currentPage.prev
    }
    currentPage.page
  }

  def forward(steps: Int): String = {
    var leftSteps = steps
    while (leftSteps > 0 && currentPage.next != null) {
      leftSteps -= 1
      currentPage = currentPage.next
    }
    currentPage.page
  }

  class Page(val page: String, var prev: Page = null, var next: Page = null)

}
