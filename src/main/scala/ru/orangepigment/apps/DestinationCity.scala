package ru.orangepigment.apps

/**
 * [[https://leetcode.com/problems/destination-city/]]
 */
object DestinationCity {

  def destCity(paths: List[List[String]]): String = {
    val pathsMap = paths.map(l => l.head -> l.last).toMap
    var destination = pathsMap.head._2
    while (pathsMap.contains(destination)) {
      destination = pathsMap(destination)
    }
    destination
  }

}
