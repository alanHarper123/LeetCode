package leetCode.problems._468_Validate_IP_Address;

public class Solution {
	private static String neither = "Neither";
	private static String IPv4 = "IPv4";
	private static String IPv6 = "IPv6";
	public String validIPAddress(String IP) {
		if(IP==null||IP.length()==0)
			return neither;
		if(IP.indexOf('.')!=-1&&!(IP.indexOf('.')==0)&&!(IP.lastIndexOf('.')==IP.length()-1)) {
			String[] iPv4Bytes = IP.split("\\.");
			if(iPv4Bytes.length==4) {
				for (String iPv4Byte:iPv4Bytes) {

					if(iPv4Byte.length()==0||
							(iPv4Byte.startsWith("0")&&iPv4Byte.length()!=1))
						return neither;
					int val = 0 ; 
					for (int i = 0; i < iPv4Byte.length(); i++) {
						char c = iPv4Byte.charAt(i);
						if(c>='0'&&c<='9') {
							val*=10;
							val+=c-'0';
						}else {
							return neither;
						}
					}
					if(val>255||val<0)
						return neither;
				}
				return IPv4;
			}
		}else if(IP.indexOf(':')!=-1&&!IP.startsWith(":")&&!IP.endsWith(":")) {
			if(IP.startsWith(":")||IP.endsWith(":"))
				return neither;
			String[] iPv6_2Bytes = IP.split(":");
			if(iPv6_2Bytes.length==8) {
				for (String iPv6_2Byte:iPv6_2Bytes) {

					if(iPv6_2Byte.length()==0||
							iPv6_2Byte.length()>4)
						return neither;

					for (int i = 0; i < iPv6_2Byte.length(); i++) {
						char c = Character.toLowerCase(iPv6_2Byte.charAt(i));
						if(c>='0'&&c<='9') {

						}else if (c>='a'&&c<='f') {

						}else {
							return neither;
						}
					}

				}
				return IPv6;
			}
		}

		return neither;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.validIPAddress("20EE:Fb8:85a3:0:0:8A2E:0370:7334"));
	}
}
