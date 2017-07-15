package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator
 * on 2017/7/14 9:10.
 */
public class P7EncodeandDecodeTinyURL {

    private static List<String> urls = new ArrayList<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urls.add(longUrl);
        return String.valueOf(urls.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int i = Integer.valueOf(shortUrl);
        return (i < urls.size()) ? urls.get(i) : "";
    }

}
