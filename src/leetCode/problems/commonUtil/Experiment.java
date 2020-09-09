package leetCode.problems.commonUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Experiment {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("F:\\virtualbox\\sharefolder\\computer systems\\code\\labs\\bomb\\phase2.txt")));
			StringBuilder stringBuilder = new StringBuilder();
			String line = br.readLine();
			while (line!=null) {
				for(String s : line.split("[ \t]")) {
					if(s.length()!=0) {
						stringBuilder.append((char)Integer.parseInt(s, 16));
					}
				}
				line = br.readLine();
			}
			System.out.println(stringBuilder.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
