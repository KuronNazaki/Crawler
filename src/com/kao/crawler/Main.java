package com.kao.crawler;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	private static String getContentFrom(String link) throws IOException {
	        
		URL url = new URL(link);
		Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
		scanner.useDelimiter("sdfgsdfg");
		String content = scanner.next();
		scanner.close();
		content = content.replaceAll("\n", "");
		return content;
		}
	public static void main(String[] args) throws IOException {
		String content = getContentFrom("https://docs.oracle.com/javase/7/docs/api/java/net/URL.html");
        // Regex
//        Pattern p = Pattern.compile("<span class=\"strong\">(.*?)</span>");
//        Matcher m = p.matcher(content);
//        while (m.find()) {
//            System.out.println(m.group(1));
//        }
		System.out.println(content);
	}
}
