package leetCode.problems._609_Find_Duplicate_File_in_System;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        LinkedList<List<String>> duplicates = new LinkedList<>();
        HashMap<String, List<String>> contentsToPaths = new HashMap<>();
        for(String path:paths) {
        	String[] pathAndContents = path.split(" ");
        	String filePath = pathAndContents[0];
        	for (int i = 1; i < pathAndContents.length; i++) {
				String[] fileNameAndCon = pathAndContents[i].split("\\(",2);
				List<String> contentsToPath = contentsToPaths.get(fileNameAndCon[1]);
				if(contentsToPath==null) {
					contentsToPath = new LinkedList<>();
					contentsToPaths.put(fileNameAndCon[1], contentsToPath);
				}
				else if(contentsToPath.size()==1){
					duplicates.add(contentsToPath);
				}
				contentsToPath.add(filePath+"/"+fileNameAndCon[0]);
			}
        }
        return duplicates;
    }
}
