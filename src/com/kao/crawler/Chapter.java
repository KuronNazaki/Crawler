package com.kao.crawler;

public class Chapter {
	private String url;
	private String chapterNumber;
	
	public Chapter(String url) {
		this.url = url;
		chapterNumber = analyzeChapterNumber(url);
	}

	public String getUrl() {
		return url;
	}

	public String getChapterNumber() {
		return chapterNumber;
	}
	
	private String analyzeChapterNumber(String url) {
		int index = 0;
		
		for (int i = 0; i < url.length(); i++) {
			if (Character.isDigit(url.charAt(i))) {
				index = i;
				break;
			}
		}
		
		return url.substring(index, url.length() - 1);
	}
}
