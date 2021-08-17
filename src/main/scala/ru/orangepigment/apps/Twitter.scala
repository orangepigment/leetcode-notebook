package ru.orangepigment.apps

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
 * [[https://leetcode.com/problems/design-twitter/]]
 *
 * Your Twitter object will be instantiated and called as such:
 * var obj = new Twitter()
 * obj.postTweet(userId,tweetId)
 * var param_2 = obj.getNewsFeed(userId)
 * obj.follow(followerId,followeeId)
 * obj.unfollow(followerId,followeeId)
 */
class Twitter() {

  /** Initialize your data structure here. */
  private val tweets = ListBuffer.empty[(Int, Int)] // user x tweet
  private val followersToFollowees = mutable.HashMap.empty[Int, Set[Int]]

  /** Compose a new tweet. */
  def postTweet(userId: Int, tweetId: Int): Unit = {
    (userId, tweetId) +=: tweets
  }

  /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
  def getNewsFeed(userId: Int): List[Int] = {
    val posters = followersToFollowees.getOrElse(userId, Set.empty[Int]) + userId

    val feed = ListBuffer.empty[Int]
    var counter = 0
    for ((posterId, tweetId) <- tweets) {
      if (counter == 10) {
        return feed.toList
      }
      if (posters(posterId)) {
        feed += tweetId
        counter += 1
      }
    }
    feed.toList
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  def follow(followerId: Int, followeeId: Int): Unit = {
    followersToFollowees += followerId -> (followersToFollowees.getOrElse(followerId, Set.empty[Int]) + followeeId)
  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  def unfollow(followerId: Int, followeeId: Int): Unit = {
    followersToFollowees += followerId -> (followersToFollowees.getOrElse(followerId, Set.empty[Int]) - followeeId)
  }

}
