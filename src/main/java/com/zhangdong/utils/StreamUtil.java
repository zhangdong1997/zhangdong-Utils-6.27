package com.zhangdong.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class StreamUtil {

	/*
	 * 方法1：批量关闭流，参数能传入无限个。(10分)
	 * 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭，并且参数个数不限。
	 */
	public static void closeAll(Closeable... io) {
		
		for (Closeable temp : io) {
			try {
				if (temp!=null) {
					temp.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/*
	* 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容(10分)，要求方法内部调用上面第1个方法关闭流(5分)
	*/
	public static String readTextFile(InputStream src) throws IOException{
     
	   BufferedInputStream bis = new BufferedInputStream(src);
	    ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    byte [] buffer = new byte[1024];
	    int len = 0;
	    while((len=bis.read(buffer))!=-1) {
	    	bos.write(buffer,0,len);
	    }
	    byte [] data = bos.toByteArray();
	    closeAll(bos,bis);
		return new String(data);
	}
	
	/*
	* 方法3：传入文本文件对象，返回该文件内容(10分)，并且要求内部调用上面第2个方法(5分)。* 这是典型的方法重载，记住了吗？少年…
	*/
	public static String readTextFile(File txtFile) throws IOException{
		String result="";
		FileInputStream src = new FileInputStream(txtFile);
		
		//調用第二個
		String string = readTextFile(src);
	   return string;
	}
	
	
	
}
