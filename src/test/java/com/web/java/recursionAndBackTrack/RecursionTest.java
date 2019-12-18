package com.web.java.recursionAndBackTrack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 描述：递归算法<br>
 * 版权：Copyright (c) 2011-2019<br>
 * 公司：北京活力天汇<br>
 * 作者：李浩<br>
 * 版本：1.0<br>
 * 创建日期：2019/12/17<br>
 */
public class RecursionTest {

	/**
	 * 1.计算 1+2+3+4+5+...+100
	 */
	@Test
	public void test1(){
		System.out.println(answer1(100));
	}

	private static int answer1(int n){
		if(n <= 1){
			return 1;
		}
		return n + answer1(n -1);
	}

	/**
	 * 2.
	 */

}
