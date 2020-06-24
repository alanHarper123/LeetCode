package leetCode.problems._721_Accounts_Merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        ArrayList<List<String>> mergedAccounts = new ArrayList<>(accounts.size());
        HashMap<String, Integer> emailsToIndex = new HashMap<>();
        for (List<String> account:accounts) {
        	Collections.sort(account);
        	LinkedList<String> newAcount = new LinkedList<>();
			for(String info:account) {
				addNewE(newAcount,info);
			}
        	Iterator<String> iter = newAcount.listIterator();
        	iter.next();
			Integer index = null;
			LinkedList<Integer> indexs = new LinkedList<>();
			while (iter.hasNext()) {
				index=emailsToIndex.get(iter.next());
				if(index!=null)
					indexs.add(index);
			}
			if(!indexs.isEmpty()) {
				Collections.sort(indexs);
				Integer pre = null;
				while (!indexs.isEmpty()) {
					index = indexs.pollLast();
					if(pre==null||!index.equals(pre))
						newAcount = mergerCountUtil(newAcount, mergedAccounts.get(index));
					mergedAccounts.set(index, null);
					pre = index;
				}
			}
			index = mergedAccounts.size();
			mergedAccounts.add(newAcount);
			iter = newAcount.listIterator();
			iter.next();
			while (iter.hasNext()) {
				emailsToIndex.put(iter.next(),index);
			}
		}
        LinkedList<List<String>> mergedAccountsR = new LinkedList<>();
        for (List<String> list:mergedAccounts) {
        	if(list!=null)
        		mergedAccountsR.add(list);
		}
        return mergedAccountsR;
    }
    private LinkedList<String> mergerCountUtil(List<String> account,List<String> accountTobeMerged){
    	LinkedList<String> mergedAccount = new LinkedList<>();
    	Iterator<String> iter1 = account.iterator();
    	Iterator<String> iter2 = accountTobeMerged.iterator();
    	mergedAccount.add(iter1.next());
    	iter2.next();
    	String s1 = null;
    	String s2 = null;
    	while ((s1!=null||iter1.hasNext())&&(s2!=null||iter2.hasNext())) {
			if(s1==null)
				s1 = iter1.next();
			if(s2==null)
				s2 = iter2.next();
			int comR = s1.compareTo(s2);
			if(comR<=0) {
				addNewE(mergedAccount, s1);
				s1=null;
				if(comR==0)
					s2=null;
			}else {
				addNewE(mergedAccount, s2);
				s2=null;
			}
		}
    	if (s1!=null) {
    		addNewE(mergedAccount, s1);
		}
    	if (s2!=null) {
    		addNewE(mergedAccount, s2);
		}
    	while (iter1.hasNext()) {
    		addNewE(mergedAccount, iter1.next());
		}
    	while (iter2.hasNext()) {
    		addNewE(mergedAccount, iter2.next());
		}
    	return mergedAccount;
    }
    private void addNewE(LinkedList<String> mergedAccount, String newE) {
    	if(mergedAccount.isEmpty()||!mergedAccount.peekLast().equals(newE))
			mergedAccount.add(newE);
    }
    public static void main(String[] args) {
		String[][] datas = new String[][] {{"Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"},
			{"Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"},
			{"Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"},
			{"Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"},
			{"Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"}
			};
		LinkedList<List<String>> testData = new LinkedList<>();
		for(String[] data:datas) {
			LinkedList<String> newData = new LinkedList<>(Arrays.asList(data));
			testData.add(newData);
		}
		Solution solution = new Solution();
		solution.accountsMerge(testData);
	}
}
