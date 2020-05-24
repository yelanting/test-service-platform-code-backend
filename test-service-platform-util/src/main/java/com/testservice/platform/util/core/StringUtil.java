/**
 * @author : 孙留平
 * @since : 2018年9月7日 下午2:21:00
 * @see:
 */
package com.testservice.platform.util.core;

import java.lang.Character.UnicodeBlock;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : Administrator
 * @since : 2018年9月7日 下午2:21:00
 * @see :
 */
public class StringUtil {
	private static final Logger LOGGER = LoggerFactory
	        .getLogger(StringUtil.class);
	/*****
	 * 英文逗号
	 */
	public final static String COMMASYMBOL = ",";

	/**
	 * @see 空字符
	 */
	public final static char EMPTY_CHAR = ' ';

	/**
	 * 数字格式
	 */
	private static final Pattern NUMBER_PATTERN = Pattern
	        .compile("[-+]?\\d+(\\.\\d+)?");

	/**
	 * 整数格式
	 */
	private static final Pattern INTEGER_PATTERN = Pattern.compile("[-+]?\\d+");

	/**
	 * @see :首字母大写
	 * @param :
	 * @return : String
	 * @param str
	 * @return
	 */

	public static String firstCharLowCase(String str) {
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}

	public static String firstCharUpCase(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public static String addPrefix(int num, String prefix, int length) {
		return String.format("%04d", num);
	}

	public static boolean isStringAvaliable(String string) {
		return string != null && !"".equals(string.trim());
	}

	public static Boolean notSame(String dest, String scre) {
		if (null == dest || null == scre) {
			return false;
		} else {
			return !dest.equals(scre);
		}
	}

	/**
	 * 去掉字符串前后空格
	 * 
	 * @param s
	 * @return
	 */
	public static String trim(String s) {
		int i = s.length();
		// 字符串第一个字符
		int j = 0;
		// 中间变量
		int k = 0;

		// 将字符串转换成字符数组
		char[] arrayOfChar = s.toCharArray();
		while ((j < i) && (arrayOfChar[(k + j)] <= EMPTY_CHAR)) {
			// 确定字符串前面的空格数
			++j;
		}
		while ((j < i) && (arrayOfChar[(k + i - 1)] <= EMPTY_CHAR)) {
			// 确定字符串后面的空格数
			--i;
		}

		// 返回去除空格后的字符串
		return (((j > 0) || (i < s.length())) ? s.substring(j, i) : s);
	}

	/**
	 * 删除input字符串中的html格式
	 * 
	 * @param input
	 * @param length
	 * @return
	 */
	public static String splitAndFilterString(String input) {
		if (input == null || input.trim().equals("")) {
			return "";
		}
		// 去掉所有html元素,
		String str = input.replaceAll("\\&[a-zA-Z]{1,10};", "")
		        .replaceAll("<[^>]*>", "");

		return str.replaceAll("[(/>)<]", "");
	}

	/**
	 * 将字符串中的英文单双引号替换是html用的
	 * 
	 * @param str
	 * @return
	 */
	public static String changeJavaToHtml(String str) {
		if (isEmpty(str)) {
			return "";
		}
		str = str.replace("'", "&#39;");
		str = str.replace("\"", "&quot;");
		return str;
	}

	public static boolean isEmpty(String str) {
		return !isStringAvaliable(str);
	}

	public static String enCodeExeclDownLoadName(String str) {
		if (isEmpty(str)) {
			return "";
		}
		try {
			return new String(str.getBytes("gbk"), "ISO8859-1");
		} catch (Exception e) {
			return "";
		}
	}

	public static String arrToString(Object[] arr) {
		return Arrays.toString(arr).replace("[", "").replace("]", "")
		        .replace(" ", "");
	}
	//
	// /***
	// * 截取orgCode 的市級別的orgCode
	// * 1.1.3.5.1.12. 返回1.1.3.
	// */
	// public static String subOrgCode(String text) {
	// if (!isStringAvaliable(text)) {
	// return "";
	// }
	//
	// String[] arr = text.split("\\.");
	// if (arr.length > 3) {
	// return arr[0] + "." + arr[1] + "." + arr[2] + ".";
	// } else {
	// return text;
	// }
	// }

	// /***
	// * 截取orgCode父级code
	// * 1.1.3.5.1.12. 返回1.1.3.5.1.
	// */
	// public static String parentOrgCode(String text) {
	// if (!isStringAvaliable(text)) {
	// return "";
	// }
	//
	// String[] arr = text.split("\\.");
	// StringBuffer sb = new StringBuffer();
	// for (int i = 0; i < arr.length - 1; i++) {
	// sb.append(arr[i]).append(".");
	// }
	// return sb.toString();
	// }

	public static String joinSortFieldOrder(String filed, String sord) {
		StringBuffer orderFiled = new StringBuffer();
		if (!StringUtil.isEmpty(filed)) {
			orderFiled.append(filed);
			if (!StringUtil.isEmpty(sord)) {
				orderFiled.append(" ").append(sord);
			}
		}
		return orderFiled.toString();
	}

	/**
	 * 字符串是否为空
	 * 
	 * @param origin
	 * @return
	 */
	public static boolean isEmpty(CharSequence origin) {
		if (origin == null || origin.length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 是否为数字字符串
	 * 
	 * @param origin
	 * @return
	 */
	public static boolean isNumeric(CharSequence origin) {
		if (origin == null || origin.length() == 0) {
			return false;
		}

		return NUMBER_PATTERN.matcher(origin).matches();
	}

	/**
	 * 是否为数字字符串
	 * 
	 * @param origin
	 * @return
	 */
	public static boolean isInteger(CharSequence origin) {
		if (origin == null || origin.length() == 0) {
			return false;
		}

		return INTEGER_PATTERN.matcher(origin).matches();
	}

	/**
	 * 获取非空字符串
	 * 
	 * @param origin
	 * @return
	 */
	public static String nonNullString(CharSequence origin) {
		if (origin == null) {
			return "";
		}

		if (origin instanceof String) {
			return (String) origin;
		}

		return origin.toString();
	}

	/**
	 * 查找是否包含
	 * 
	 * @param origin
	 * @param subString
	 * @return
	 */
	public static boolean contains(CharSequence origin,
	        CharSequence subString) {
		if (origin == null || origin.length() == 0) {
			return false;
		}
		return origin.toString().contains(subString);
	}

	/**
	 * 把字符串类型转换为MAP
	 * 
	 * @see :
	 * @param :
	 * @return : Map<String,Object>
	 * @param params
	 * @return
	 */
	public static Map<String, Object> changeStringParamsToMap(String params) {
		if (StringUtil.isEmpty(params)) {
			return null;
		}

		String[] paramsAfterSplit = params.split("&");

		Map<String, Object> paramsMap = new HashMap<>(16);
		/**
		 * 
		 */
		for (int i = 0; i < paramsAfterSplit.length; i++) {
			String[] eachPairAfterSplit = paramsAfterSplit[i].split("=");

			if (eachPairAfterSplit.length <= 0) {
				continue;
			}

			if (eachPairAfterSplit.length == 1) {
				paramsMap.put(eachPairAfterSplit[0], null);
			} else {
				paramsMap.put("" + eachPairAfterSplit[0],
				        eachPairAfterSplit[1]);
			}
		}

		LOGGER.debug("把字符串:{},转换为MAP。结果为:{}", params, paramsMap);

		return paramsMap;
	}

	/**
	 * 查找顺序
	 * 
	 * @param origin
	 * @param subString
	 * @return
	 */
	public static int indexOf(CharSequence origin, CharSequence subString) {
		if (isEmpty(origin) || isEmpty(subString)) {
			return -1;
		}

		return origin.toString().indexOf(subString.toString());
	}

	/**
	 * 查找顺序
	 * 
	 * @param origin
	 * @param subString
	 * @return
	 */
	public static int indexOf(CharSequence origin, char subString) {
		if (isEmpty(origin)) {
			return -1;
		}

		return origin.toString().indexOf(subString);
	}

	/**
	 * 拆分字符串
	 * 
	 * @param origin
	 * @param subString
	 * @return
	 */
	public static String[] split(CharSequence origin, CharSequence subString) {
		return split(origin, subString, 0);
	}

	/**
	 * 拆分字符串
	 * 
	 * @param origin
	 * @param subString
	 * @param maxCount
	 *            最大拆分次数
	 * @return
	 */
	public static String[] split(CharSequence origin, CharSequence subString,
	        int maxCount) {
		if (isEmpty(origin) || isEmpty(subString)) {
			return null;
		}

		return origin.toString().split(subString.toString(), maxCount);
	}

	/**
	 * 强制toString
	 * 
	 * @param item
	 * @return
	 */
	public static String toString(Object item) {
		if (item == null) {
			return null;
		}

		if (item.getClass().isArray()) {
			return Arrays.toString((Object[]) item);
		}

		if (item instanceof String) {
			return (String) item;
		}

		return item.toString();
	}

	/**
	 * 去除前后不可见符号
	 * 
	 * @param origin
	 * @return
	 */
	public static String trim(CharSequence origin) {
		return origin == null ? null : origin.toString().trim();
	}

	/**
	 * 判断origin是否以sub开始
	 * 
	 * @param origin
	 *            目标字段
	 * @param sub
	 *            查找字段
	 * @return
	 */
	public static boolean startWith(CharSequence origin, CharSequence sub) {
		if (isEmpty(origin) || isEmpty(sub) || origin.length() < sub.length()) {
			return false;
		}

		/**
		 * 比较前n个字符
		 */
		for (int i = 0; i < sub.length(); i++) {
			if (origin.charAt(i) != sub.charAt(i)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 比较字符串是否相等
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean equals(CharSequence a, CharSequence b) {
		// 两者都为空，相等
		if (a == null && b == null) {
			return true;
		}

		// 一个为空，不等
		if (a == null || b == null) {
			return false;
		}

		// 都不为空，直接比较
		return a.toString().equals(b.toString());
	}

	/**
	 * 比较字符串是否相等，忽略大小写
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean equalsIgnoreCase(CharSequence a, CharSequence b) {
		// 两者都为空，相等
		if (a == null && b == null) {
			return true;
		}

		// 一个为空，不等
		if (a == null || b == null) {
			return false;
		}

		// 都不为空，直接比较
		return a.toString().equalsIgnoreCase(b.toString());
	}

	/**
	 * 把字符串数组 转换成字符串，,连接
	 * 
	 * @see :
	 * @param :
	 * @return : String
	 * @param stringArray
	 * @return
	 */
	public static String changeStringArrayToString(String[] stringArray) {
		if (null == stringArray || stringArray.length == 0) {
			return "";
		}

		StringBuilder stringBuilder = new StringBuilder();
		for (String string : stringArray) {
			stringBuilder.append(string).append(",");
		}

		return stringBuilder.substring(0, stringBuilder.length() - 1);
	}

	/**
	 * 连接字符串
	 * 
	 * @param joiner
	 * @param contents
	 * @return
	 */
	public static String join(CharSequence joiner, List<String> contents) {
		if (contents == null || contents.size() == 0) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < contents.size() - 1; i++) {
			sb.append(contents.get(i)).append(joiner);
		}
		return sb.append(contents.get(contents.size() - 1)).toString();
	}

	/**
	 * 连接字符串
	 * 
	 * @param joiner
	 * @param contents
	 * @return
	 */
	public static String join(CharSequence joiner, CharSequence... contents) {
		if (contents == null || contents.length == 0) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < contents.length - 1; i++) {
			sb.append(contents[i]).append(joiner);
		}
		return sb.append(contents[contents.length - 1]).toString();
	}

	/**
	 * 比较字符串是否相等或者左侧为空
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean equalsOrLeftBlank(CharSequence a, CharSequence b) {
		// 两者都为空，相等
		if (a == null) {
			return true;
		}

		// 都不为空，直接比较
		return toString(a).equals(toString(b));
	}

	/**
	 * 正则替换
	 * 
	 * @param origin
	 * @param reg
	 * @param to
	 * @return
	 */
	public static String patternReplace(CharSequence origin, CharSequence reg,
	        CharSequence to) {
		if (origin == null) {
			return null;
		}

		if (reg == null) {
			return origin.toString();
		}

		if (to == null) {
			return origin.toString().replaceAll(reg.toString(), "null");
		} else {
			return origin.toString().replaceAll(reg.toString(), to.toString());
		}
	}

	/**
	 * 正则替换
	 * 
	 * @param origin
	 *            原始字段
	 * @param pattern
	 *            正则模板
	 * @param replace
	 *            替换方法
	 * @return
	 */
	public static String patternReplace(CharSequence origin, Pattern pattern,
	        PatternReplace replace) {
		if (origin == null || replace == null || pattern == null) {
			return null;
		}

		// 正则匹配下
		Matcher matcher = pattern.matcher(origin);
		StringBuilder sb = new StringBuilder();

		int currentIdx = 0;
		// 替换所有匹配到的字段
		while (matcher.find()) {
			// 添加之前的字段
			int start = matcher.start();
			sb.append(origin.subSequence(currentIdx, start));

			// 替换match字段
			String content = replace.replacePattern(matcher.group());
			sb.append(content);

			// 重置偏移量
			currentIdx = start + matcher.group().length();
		}

		// 如果还有其他字段
		if (currentIdx < origin.length()) {
			sb.append(origin.subSequence(currentIdx, origin.length()));
		}

		return sb.toString();
	}

	/**
	 * 字符替换接口
	 */
	public interface PatternReplace {
		String replacePattern(String origin);
	}

	/**
	 * 生成长度为<tt>length</tt>的随机字符串
	 * 
	 * @param length
	 *            生成长度
	 * @return 随机字符串
	 */
	public static String generateRandomString(int length) {
		StringBuilder builder = new StringBuilder(length);
		Random random = new Random(System.currentTimeMillis());
		for (int i = 0; i < length; i++) {
			int currentValue = random.nextInt(35);
			if (currentValue < 10) {
				builder.append(currentValue);
			} else {
				builder.append((char) ('a' + (currentValue - 10)));
			}
		}
		return builder.toString();
	}

	/**
	 * 判断是否包含中文
	 * 
	 * @param checkStr
	 * @return
	 */
	public static boolean containsChinese(CharSequence checkStr) {
		if (!isEmpty(checkStr)) {
			String checkChars = checkStr.toString();
			for (int i = 0; i < checkChars.length(); i++) {
				char checkChar = checkChars.charAt(i);
				if (checkCharContainChinese(checkChar)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean checkCharContainChinese(char checkChar) {
		UnicodeBlock ub = UnicodeBlock.of(checkChar);
		if (UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS == ub
		        || UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS == ub
		        || UnicodeBlock.CJK_COMPATIBILITY_FORMS == ub
		        || UnicodeBlock.CJK_RADICALS_SUPPLEMENT == ub
		        || UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A == ub
		        || UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B == ub) {
			return true;
		}
		return false;
	}

	/**
	 * 取hash
	 * 
	 * @param content
	 * @return
	 */
	public static String hash(Object content) {
		if (content == null) {
			return "FFFFFFFF##-1";
		} else {
			int length;
			if (content instanceof Collection) {
				length = ((Collection) content).size();
			} else if (content.getClass().isArray()) {
				length = Array.getLength(content);
			} else {
				String strVal = toString(content);
				length = strVal == null ? 0 : strVal.length();
			}

			return content.getClass().getSimpleName() + '@'
			        + Integer.toHexString(content.hashCode()) + "##" + length;
		}
	}

	/**
	 * 判空操作
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isBlank(String value) {
		return value == null || "".equals(value) || "null".equals(value)
		        || "undefined".equals(value);
	}

}
