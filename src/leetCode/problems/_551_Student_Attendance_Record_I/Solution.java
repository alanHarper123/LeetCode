package leetCode.problems._551_Student_Attendance_Record_I;

public class Solution {
    public boolean checkRecord(String s) {
        int ahsentDayC = 0;
        int continuousLC = 0;
        for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case 'L':
				if(continuousLC==2)
					return false;
				continuousLC++;
				break;
			case 'A':
				if(ahsentDayC==1)
					return false;
				ahsentDayC++;
			default:
				continuousLC=0;
				break;
			}
		}
        return true;
    }
}
