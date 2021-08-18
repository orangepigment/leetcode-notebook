package ru.orangepigment.apps

import scala.collection.mutable

/**
 * [[https://leetcode.com/problems/design-underground-system/]]
 *
 * Your UndergroundSystem object will be instantiated and called as such:
 * var obj = new UndergroundSystem()
 * obj.checkIn(id,stationName,t)
 * obj.checkOut(id,stationName,t)
 * var param_3 = obj.getAverageTime(startStation,endStation)
 */

class UndergroundSystem() {

  private val timeToTravel = mutable.Map.empty[(String, String), List[Int]]
  private val passengers = mutable.Map.empty[Int, (String, Int)]

  def checkIn(id: Int, stationName: String, t: Int): Unit = {
    passengers += id -> (stationName, t)
  }

  def checkOut(id: Int, stationName: String, t: Int): Unit = {
    val (startStation, startTime) = passengers(id)
    val timesList = timeToTravel.getOrElse((startStation, stationName), List.empty[Int])
    timeToTravel += (startStation, stationName) -> ((t - startTime) +: timesList)
    passengers.remove(id)
  }

  def getAverageTime(startStation: String, endStation: String): Double = {
    val timeList = timeToTravel((startStation, endStation))
    timeList.sum.toDouble / timeList.length
  }

}
