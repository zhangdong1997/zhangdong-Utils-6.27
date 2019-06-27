package com.zhangdong.main;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.zhangdong.utils.DateUtil;
import com.zhangdong.utils.FileUtil;
import com.zhangdong.utils.StreamUtil;

public class Test {
	public static void main(String[] args) {
		Date date = DateUtil.getDateByInitMonth(new Date());
		Date date2 = DateUtil.getDateByFullMonth(new Date());
		//System.out.println(date);
		//String string = FileUtil.getExtendName("aaa.jpg");
		//System.out.println(string);
		//String sql = "select * from t_order where create_time>='"+date+"' and create_time<='"+date2+"' ";
		File file = new File("D:\\bbb.txt");
		try {
			String string = StreamUtil.readTextFile(file);
			System.out.println(string);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
