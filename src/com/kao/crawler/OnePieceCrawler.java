package com.kao.crawler;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public abstract class OnePieceCrawler {
	private ArrayList<Chapter> getAllChaptersInPage(String urls) throws IOException {
		ArrayList<Chapter> chapters = new ArrayList<>();
		Document document = Jsoup.connect(urls).get();
		Elements elements = document.getElementsByClass("wp-manga-chapter  ");
		
		for (int i = 0; i < elements.size(); i++) {
			Elements elementsInClass = elements.get(i).getElementsByTag("a");
			for (int j = 0; j < elementsInClass.size(); j++) {
				String chapterLink = elementsInClass.first().absUrl("href");
				chapters.add(new Chapter(chapterLink));
			}
		}
		
		return chapters;
	}
	
	private ArrayList<String> getAllImageLinksInPage(String pageURL) throws IOException {
		Document document = Jsoup.connect(pageURL).get();
		ArrayList<String> links = new ArrayList<>();
		Elements elements = document.getElementsByClass("text-left");
		Elements elementsInClass = document.getElementsByTag("img");
		
		for (int i = 0; i < elementsInClass.size(); i++ ) {
			String url = elementsInClass.get(i).absUrl("src");
			if (url.equals("")) {
				continue;
			}
			links.add(url);
		}
		
		return links;
	}
}
