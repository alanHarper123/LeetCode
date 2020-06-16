package leetCode.problems._677_Map_Sum_Pairs;


class Dictionary{
	boolean isWord;
	int sum;
	Dictionary[] newChar = new Dictionary[26];
}
public class MapSum {
	Dictionary dictionary= new Dictionary();;
    /** Initialize your data structure here. */
    public MapSum() {
        
    }
    
    public void insert(String key, int val) {
    	Dictionary runner = dictionary;
    	runner.sum+=val;
    	for (int i = 0; i < key.length(); i++) {
    		int index = key.charAt(i)-'a';
    		if(runner.newChar[index]==null)
    			runner.newChar[index] = new Dictionary();
			runner = runner.newChar[index];
			runner.sum+=val;
		}
    	if(runner.isWord) {
    		deleteExitedKey(key, runner.sum-val);
    	}else {
    		runner.isWord = true;
    	}
    }
    private void deleteExitedKey(String key, int val) {
    	Dictionary runner = dictionary;
    	runner.sum-=val;
    	for (int i = 0; i < key.length(); i++) {
    		int index = key.charAt(i)-'a';
			runner = runner.newChar[index];
			runner.sum-=val;
		}
    }
    public int sum(String prefix) {
    	Dictionary runner = dictionary;
    	for (int i = 0; i < prefix.length(); i++) {
    		int index = prefix.charAt(i)-'a';
			runner = runner.newChar[index];
			if(runner==null)
				return 0;
		}
    	return runner.sum;
    }
    
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 * 
 *  
  Implement a MapSum class with insert, and sum methods.

For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.

For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.

Example 1:

Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5

 */
