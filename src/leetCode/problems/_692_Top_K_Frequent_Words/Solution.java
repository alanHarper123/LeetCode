package leetCode.problems._692_Top_K_Frequent_Words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Solution {
	Random random = new Random(System.currentTimeMillis());
    public List<String> topKFrequent(String[] words, int k) {
    	ArrayList<String> allWords = new ArrayList<>(words.length);
    	HashMap<String, Integer> wordsToIndexs = new HashMap<>(words.length);
        ArrayList<Integer> frs = new ArrayList<>(words.length);
        for (String word:words) {
			Integer index = wordsToIndexs.get(word);
			if(index==null) {
				index =  frs.size();
				frs.add(0);
				allWords.add(word);
				wordsToIndexs.put(word, index);
			}
			frs.set(index, frs.get(index)+1);
		}
        quickSort(frs, 0, allWords.size(), allWords);
        return allWords.subList(0, k);
    }
    private void quickSortFindKthElement(ArrayList<Integer> frs,int k,int start,
    		int end,ArrayList<String> allWords) {
    	int randIndex = start+random.nextInt(end-start);
    	int pivot = frs.get(randIndex);
    	String pivotString = allWords.get(randIndex);
    	int right = end-1;
    	int i = start;
    	for (; i <= right;) {
			if(frs.get(i)<pivot||(frs.get(i)==pivot&&String.CASE_INSENSITIVE_ORDER.compare(
					pivotString, allWords.get(i))>0)) {
				int temp = frs.get(i);
				frs.set(i, frs.get(right));
				frs.set(right, temp);
				String tempS = allWords.get(i);
				allWords.set(i, allWords.get(right));
				allWords.set(right--, tempS);
			}else {
				i++;
			}
		}
    	if(i<k) {
    		quickSortFindKthElement(frs, k-(i-start), i, end, allWords);
    	}else if(i>k) {
    		quickSortFindKthElement(frs, k, start, i, allWords);
    	}	
    }
    private void quickSort(ArrayList<Integer> frs,int start,
    		int end,ArrayList<String> allWords) {
    	if(start>=end)
    		return;
    	int randIndex = start+random.nextInt(end-start);
    	int pivot = frs.get(randIndex);
    	String pivotString = allWords.get(randIndex);
    	int right = end-1;
    	int left = start;
    	int i = start;
    	for (; i <= right;) {
			if(frs.get(i)<pivot||(frs.get(i)==pivot&&String.CASE_INSENSITIVE_ORDER.compare(
					pivotString, allWords.get(i))<0)) {
				int temp = frs.get(i);
				frs.set(i, frs.get(right));
				frs.set(right, temp);
				String tempS = allWords.get(i);
				allWords.set(i, allWords.get(right));
				allWords.set(right--, tempS);
			}else if(frs.get(i)>pivot||(frs.get(i)==pivot&&String.CASE_INSENSITIVE_ORDER.compare(
					pivotString, allWords.get(i))>0)){
				int temp = frs.get(i);
				frs.set(i, frs.get(left));
				frs.set(left, temp);
				String tempS = allWords.get(i);
				allWords.set(i, allWords.get(left));
				allWords.set(left++, tempS);
				i++;
			}else {
				i++;
			}
		}
    	frs.set(right, pivot);
    	allWords.set(right, pivotString);
    	quickSort(frs,i, end, allWords);
    	quickSort(frs,start, right, allWords);
    }
}
