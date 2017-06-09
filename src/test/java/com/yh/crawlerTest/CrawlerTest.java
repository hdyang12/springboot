package com.yh.crawlerTest;

import org.junit.Test;

import com.yh.util.CrawlerUtils;

/**
 * 爬虫测试
 * @author yh
 *
 */
public class CrawlerTest {
	
	@Test
	public void baiduResultTest(){
		String url = "http://www.baidu.com";
		System.out.println(CrawlerUtils.getUrlContent(url, false));
	}
	
	@Test
	public void literatureTest(){
		String url = "http://apps.webofknowledge.com/Search.do?product=WOS&SID=2BjWTNP68uIp9OmNVg5&search_mode=GeneralSearch&prID=657a67dd-d723-4bdc-9e98-b1e2c93985ff";
		System.out.println(CrawlerUtils.getUrlContent(url, false));
	}
	
}
