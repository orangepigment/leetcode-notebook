package ru.orangepigment.arrays

/**
 * [[https://leetcode.com/problems/meeting-rooms/]]
 */
object MeetingRooms {

  def canAttendMeetings(intervals: Array[Array[Int]]): Boolean = {
    val sorted = intervals.sortBy(_ (0))
    for (i <- 0 until intervals.length - 1) {
      if (sorted(i)(1) > sorted(i + 1)(0)) {
        return false
      }
    }
    true
  }

}
