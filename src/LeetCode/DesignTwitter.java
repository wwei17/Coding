package LeetCode;

import java.util.*;

public class DesignTwitter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Twitter {
    
    HashMap<Integer, HashSet<Integer>> follow_map;
    HashMap<Integer, ArrayList<Tweet>> post_list;
    int seqId;

    /** Initialize your data structure here. */
    public Twitter() {
        follow_map = new HashMap<Integer, HashSet<Integer>>();
        post_list = new HashMap<Integer, ArrayList<Tweet>>();
        seqId = 0;
    }
    
    public void validateId(int id){
        if(!post_list.containsKey(id)){
            follow_map.put(id, new HashSet<Integer>());
            follow_map.get(id).add(id);
            post_list.put(id, new ArrayList<Tweet>());
        }      
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        validateId(userId);
        post_list.get(userId).add(new Tweet(userId, seqId, tweetId));
        seqId++;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        validateId(userId);
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>();
        HashMap<Integer, Integer> i_map = new HashMap<Integer, Integer>();
        int last = 0;
        for(int id : follow_map.get(userId)){
            last = post_list.get(id).size()-1;
            i_map.put(id, last);
            if(last >=0) pq.offer(post_list.get(id).get(last));
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Tweet curr = null; 
        while(list.size() < 10 && pq.size() > 0){
            curr = pq.poll();
            last = i_map.get(curr.userId);
            last --;
            i_map.put(curr.userId, last);
            if(last >= 0) pq.offer(post_list.get(curr.userId).get(last));
            list.add(curr.tweetId);
        }
        return list;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        validateId(followerId);
        validateId(followeeId);
        follow_map.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        validateId(followerId);
        validateId(followeeId);
        follow_map.get(followerId).remove(followeeId);
    }
    
    class Tweet implements Comparable<Tweet>{
        int userId;
        int seqId;
        int tweetId;
        
        @Override
        public int compareTo(Tweet t){
            return t.seqId - this.seqId;
        }
        
        Tweet(int u, int s, int t){
            this.userId = u;
            this.seqId = s;
            this.tweetId = t;
        }
    }
}
