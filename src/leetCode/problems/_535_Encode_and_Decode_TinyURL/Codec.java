package leetCode.problems._535_Encode_and_Decode_TinyURL;

import java.util.Random;

class Charboard{
	String decodedS;
	Charboard[] charboards = new Charboard['z'-'0'+1];
}
public class Codec {
	private Random random = new Random(System.currentTimeMillis());
    private Charboard head;
    private static String prefix = "http://tinyurl.com/";
    public Codec() {
		head = new Charboard();
		head.decodedS = "";
	}
    public String encode(String longUrl) {
        StringBuilder stringBuilder = new StringBuilder(prefix);
        Charboard runner = head;
        while (runner.decodedS!=null) {
			char rand = nextRandomChar();
			stringBuilder.append(rand);
			if(runner.charboards[rand-'0']==null) {
				runner.charboards[rand-'0'] = new Charboard();
			}
			runner = runner.charboards[rand-'0'];
		}
        runner.decodedS = longUrl;
        return stringBuilder.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String encodedStr = shortUrl.substring(prefix.length());
        Charboard runner = head;
        for (int i = 0; i < encodedStr.length(); i++) {
			runner = runner.charboards[encodedStr.charAt(i)-'0'];
		}
        return runner.decodedS;
    }
    private char nextRandomChar() {
    	char pick = (char) ('0'+random.nextInt('z'-'0'+1));
    	if((pick>'9'&&pick<'A')||(pick>'Z'&&pick<'a'))
    		return nextRandomChar();
    	return pick;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
