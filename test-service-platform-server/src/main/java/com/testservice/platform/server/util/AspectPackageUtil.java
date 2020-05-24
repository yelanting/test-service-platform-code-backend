/**
 * @author : 孙留平
 * @since : 2020年3月12日 上午9:56:39
 * @see:
 */
package com.testservice.platform.server.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : Administrator
 * @since : 2020年3月12日 上午9:56:39
 * @see : 用来方便读取切面的时候的包信息
 */
public class AspectPackageUtil {

	private static final Logger LOGGER = LoggerFactory
	        .getLogger(AspectPackageUtil.class);

	public static final String THIS_PACKAGE_PREFIX = "com.testservice.platform.server";

	public static final String ASPECT_EXPRESSION_PREFIX = "execution(* ";
	public static final String ASPECT_EXPRESSION_SUFFIX = ".*.*(..))";

	/**
	 * @see :
	 */
	private AspectPackageUtil() {
	}

	public static String getPackageExepressionUnderRoot(String subPackageName) {
		String packageLevelAspectExpression = ASPECT_EXPRESSION_PREFIX
		        + THIS_PACKAGE_PREFIX + subPackageName
		        + ASPECT_EXPRESSION_SUFFIX;
		LOGGER.debug("包级别的切面表达式为:{}", packageLevelAspectExpression);
		return packageLevelAspectExpression;
	}

}
