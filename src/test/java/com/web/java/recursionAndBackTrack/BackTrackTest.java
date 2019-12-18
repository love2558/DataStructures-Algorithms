package com.web.java.recursionAndBackTrack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 描述：回溯算法<br>
 * 版权：Copyright (c) 2011-2019<br>
 * 公司：北京活力天汇<br>
 * 作者：李浩<br>
 * 版本：1.0<br>
 * 创建日期：2019/12/17<br>
 */
public class BackTrackTest {
	/**
	 * <br>
	 * 1.给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合<br/>
	 * <br>
	 * 示例: 输入: S = "a1b2"<br/>
	 * <br>
	 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]<br/>
	 */
	@Test
	public void test1(){
		String S = "a1b3";
		List<String> res = new LinkedList<>();
		answer1("", S, res, 0);
		System.out.println(res);
	}

	private static void answer1(String pre, String S, List<String> res, int index) {
		if (index == S.length())
			res.add(pre);
		else {
			char ch = S.charAt(index);
			if (!Character.isLetter(ch))
				answer1(pre + ch, S, res, index + 1);
			else {
				// 小写字符分支
				ch = Character.toLowerCase(ch);
				answer1(pre + ch, S, res, index + 1);
				// 大写字符分支
				ch = Character.toUpperCase(ch);
				answer1(pre + ch, S, res, index + 1);
			}
		}
	}
}
