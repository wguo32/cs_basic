package com.thinktwice.cs.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeDecodeTinyURL_535 {

    private final static int SHORTURL_LENGTH = 6;

    private Map<String, String> shortURLMap = new HashMap<String, String>();
    private Map<String, String> longURLMap = new HashMap<String, String>();
    private Random rand = new Random();

    String randomGeneratgor() {
        //size = 10 + 26 * 2
        StringBuilder shortURL = new StringBuilder();
        for(int i = 0;i < SHORTURL_LENGTH;++i) {
            int r = rand.nextInt(62);
            if(r < 10) {
                shortURL.append(r);
            } else if(r < 36) {
                shortURL.append((char)(r - 10 + 'a'));
            } else {
                shortURL.append((char)(r - 36 + 'A'));
            }
        }
        return shortURL.toString();
    }

    String generateShortURL() {
        String shortURL = randomGeneratgor();
        while(shortURLMap.containsKey(shortURL)) {
            shortURL = randomGeneratgor();
        }
        return shortURL;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(longURLMap.containsKey(longUrl)) {
            return longURLMap.get(longUrl);
        }

        String shortURL = generateShortURL();
        shortURLMap.put(shortURL, longUrl);
        longURLMap.put(longUrl, shortURL);
        return shortURL;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(!shortURLMap.containsKey(shortUrl)) {
            throw new RuntimeException("No such short URL");
        }
        return shortURLMap.get(shortUrl);
    }

    public static void main(String[] args) {
        EncodeDecodeTinyURL_535 a = new EncodeDecodeTinyURL_535();
        String s = a.encode("https://leetcode.com/problems/design-tinyurl");
        a.encode("https://leetcode.com/problems/design-tinyurl1");
        a.encode("https://leetcode.com/problems/design-tinyurl2");
        a.encode("https://leetcode.com/problems/design-tinyurl3");
        a.encode("https://leetcode.com/problems/design-tinyurl4");
        a.encode("https://leetcode.com/problems/design-tinyurl5");
        a.encode("https://leetcode.com/problems/design-tinyurl6");
        a.encode("https://leetcode.com/problems/design-tinyurl7");
        a.encode("https://leetcode.com/problems/design-tinyurl8");
        String z = a.decode(s);
        System.out.println(z);
    }
}
