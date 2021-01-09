package com.neusoft.util;


import java.util.Random;

/**
 * 生成一串随机数
 * @author 戴顺
 * @date 2015-08-14
 */


public class RandomUtil {
	
	/*
	 * @param count :需要产生随机数的个数
	 */
	public static String radmonkey(int count){
		StringBuffer sbf=new StringBuffer();
		for (int i = 0; i <count; i++) {
			int num=(int)(Math.random()*10);
			sbf.append(num);
		}
		
		return sbf.toString();
	}

	/**
	 * 司机随机编码 4位字母加三位数字
	 * @return
	 */
	public static String randomDriverCode(){
		char charr[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		for (int x = 0; x < 4; ++x) {
			sb.append(charr[r.nextInt(charr.length)]);
		}
		int num = (int)(Math.random()*1000);
		String a = Integer.toString(num);
		return sb.toString()+a;
	}


	
	public static void main(String[] args) {
		System.err.println(radmonkey(32));
	}

}
