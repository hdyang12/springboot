package com.yh.applet.inoutputtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.junit.Test;


public class InOutputTest {
	
	@Test
	@SuppressWarnings("resource")
	public void outputTest() throws Exception {
		//最后一个boolean参数代表append;为true会追加信息;为false重写文件
		OutputStream out = new FileOutputStream(new File("." + File.separator
				+ "InOutput.txt"), false);
		OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
		PrintWriter pw = new PrintWriter(osw, true);// true代表能自动刷新
		pw.println("output");
	}
	
	@Test
	@SuppressWarnings("resource")
	public void inputTest() throws Exception {
		InputStream in = new FileInputStream(new File("." + File.separator
				+ "InOutput.txt"));
		InputStreamReader isr = new InputStreamReader(in, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		
		String s = null;
		while ((s = br.readLine()) != null) {
			System.out.println(s);
		}
	}
}
