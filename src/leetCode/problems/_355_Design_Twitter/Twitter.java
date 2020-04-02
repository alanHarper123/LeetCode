package leetCode.problems._355_Design_Twitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class User{
	int userId;
	private int tweetsLimit = 10;
	LinkedList<Tweet> tweets = new LinkedList<>();
	HashSet<User> followees = new HashSet<>();
	public void addtweet(Tweet tweet){
		tweets.addFirst(tweet);
		if (tweets.size()>tweetsLimit)
			tweets.pollLast();
	}
	public void addFollowee(User user) {
		followees.add(user);
	}
	public void deleteFollowee(User user) {
		followees.remove(user);
	}
	public User(int userId) {
		this.userId = userId;
	}
}
class Tweet{
	private static int count = 0;
	final long date;
	final Integer id;
	public Tweet(Integer id) {
		this.id = id;
		date = count++;
	}
}
public class Twitter {
	private HashMap<Integer, User> usersMap = new HashMap<>();
	
    /** Initialize your data structure here. */
    public Twitter() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        User user = usersMap.get(userId);
        if(user==null) {
        	user = new User(userId);
        	usersMap.put(userId, user);
        }
        user.addtweet(new Tweet(tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	List<Integer> result = new LinkedList<>();
    	User user = usersMap.get(userId);
    	ArrayList<Iterator<Tweet>> baseIter = null;
    	if(user!=null) {
    		baseIter = new ArrayList<>(user.followees.size()+1);
    		if(!user.followees.contains(user)&&user.tweets.size()!=0)
    			baseIter.add(user.tweets.listIterator(0));
    		for (User followee: user.followees) {
				if(followee.tweets.size()!=0)
					baseIter.add(followee.tweets.listIterator(0));
			}
    		ArrayList<Tweet> base = new ArrayList<>(baseIter.size());
        	for (Iterator<Tweet> iter:baseIter) {
    			base.add(iter.next());
    		}
        	for (int i = base.size()/2; i > -1 ; i--) {
    			maxifyArr(base, baseIter, i);
    		}
        	for (int i = 0; i < 10; i++) {
    			if(base.size()!=0) {
    				result.add(base.get(0).id);
    				if(baseIter.get(0).hasNext()) {
    					base.set(0, baseIter.get(0).next());
    				}else {
    					if(base.size()==1)
    						break;
    					else {
    						base.set(0, base.get(base.size()-1));
    						base.remove(base.size()-1);
    						baseIter.set(0, baseIter.get(baseIter.size()-1));
    						baseIter.remove(baseIter.size()-1);
    					}
    				}
    				maxifyArr(base, baseIter, 0);
    			}else 
    				break;
    			
    				
    		}
    	}
    	return result;
        
    }
    private void maxifyArr(ArrayList<Tweet> base,
    		ArrayList<Iterator<Tweet>> baseIter, int bindex) {
    	while ((bindex+1)*2<=base.size()) {
    		int maxIndex = bindex;
			if(base.get(maxIndex).date<base.get((bindex+1)*2-1).date) {
				maxIndex = (bindex+1)*2-1;
			}
			if((bindex+1)*2<base.size()&&base.get(maxIndex).date<base.get((bindex+1)*2).date) {
				maxIndex = (bindex+1)*2;
			}
			if(maxIndex == bindex) {
				return;
			}else {
				Tweet tweet = base.get(maxIndex);
				Iterator<Tweet> iter = baseIter.get(maxIndex);
				base.set(maxIndex, base.get(bindex));
				baseIter.set(maxIndex, baseIter.get(bindex));
				base.set(bindex, tweet);
				baseIter.set(bindex, iter);
				bindex = maxIndex;
			}
		}
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	User follower = usersMap.get(followerId);
        if(follower==null) {
        	follower = new User(followerId);
        	usersMap.put(followerId, follower);
        }
        User followee = usersMap.get(followeeId);
        if(followee==null) {
        	followee=new User(followeeId);
        	usersMap.put(followeeId,followee);
        }
        follower.addFollowee(followee);
        	
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        User followee = usersMap.get(followeeId);
        if(followee!=null) {
        	User follower = usersMap.get(followerId);
        	if(follower!=null)
        		follower.deleteFollowee(followee);
        }
    }
    public static void main(String[] args) {
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 4);
		twitter.postTweet(2, 5);
		twitter.unfollow(1, 2);
		twitter.follow(1, 2);
		System.out.println(twitter.getNewsFeed(1));
	}
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
