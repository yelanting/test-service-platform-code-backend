package com.testservice.platform.server.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * HTTP工具类
 * 
 * @author Administrator
 * @date Jan 19, 2019
 */
public class HttpUtils {
	private static final Logger LOGGER = LoggerFactory
	        .getLogger(HttpUtils.class);

	private static final Pattern[] ICON_PATTERNS = new Pattern[] {
	        Pattern.compile(
	                "rel=[\"']shortcut icon[\"'][^\r\n>]+?((?<=href=[\"']).+?(?=[\"']))"),
	        Pattern.compile(
	                "((?<=href=[\"']).+?(?=[\"']))[^\r\n<]+?rel=[\"']shortcut icon[\"']"),
	        Pattern.compile(
	                "rel=[\"']icon[\"'][^\r\n>]+?((?<=href=[\"']).+?(?=[\"']))"),
	        Pattern.compile(
	                "rel=[\"\']icon[\"\'][^\r\n>]+?((?<=href=[\"\']).+?(?=[\"\']))") };
	private static final Pattern HEAD_END_PATTERN = Pattern.compile("</head>");

	private static final Pattern PATTERN_URL_PATTERN = Pattern.compile(
	        "(http|https)://www\\..+?\\.(aero|arpa|biz|com|coop|edu|gov|info|int|jobs|mil|museum|name|nato|net|org|pro|travel|[a-z]{2})");

	private static final String HTTP_OR_HTTPSSTART = "http";

	/**
	 * 获取HttpServletRequest对象
	 * 
	 * @return
	 */
	public static HttpServletRequest getHttpServletRequest() {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
		        .getRequestAttributes();

		if (null == servletRequestAttributes) {
			return null;
		}

		return servletRequestAttributes.getRequest();
	}

	/**
	 * 获取一个请求实例
	 * 
	 * @see :
	 * @param :
	 * @return : RestTemplate
	 * @return
	 */
	public static RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	/**
	 * 获取结果
	 * 
	 * @see :
	 * @param :
	 * @return : void
	 * @param url
	 */
	public static ResponseEntity<String> getResponseFromUrl(String url) {
		LOGGER.debug("获取url:{}的结果", url);
		ResponseEntity<String> resultEntity = getRestTemplate()
		        .getForEntity(url, String.class);
		LOGGER.debug("响应结果:{}", resultEntity);
		return resultEntity;
	}

	/**
	 * 获取某个网站的图标
	 * 
	 * @see :
	 * @param :
	 * @return : String
	 * @param url
	 * @return
	 */
	public static String getFavico(String url) {
		LOGGER.debug("获取网站图标:{}", url);
		try {
			String imageUrl = getIconUrlString(url);
			LOGGER.debug("获取到的图片地址为：{}", imageUrl);
			return imageUrl;
		} catch (Exception e) {
			LOGGER.error("获取网站的图标失败,错误信息：{}", e.getMessage());
			return null;
		}

	}

	/**
	 * 获取稳定url
	 * 
	 * @see :
	 * @param :
	 * @return : String
	 * @param urlString
	 * @return
	 */
	private static String getFinalUrl(String urlString) {
		HttpURLConnection connection = null;
		try {
			connection = getConnection(urlString);
			connection.connect();

			// 是否跳转，若跳转则跟踪到跳转页面
			if (connection
			        .getResponseCode() == HttpURLConnection.HTTP_MOVED_PERM
			        || connection
			                .getResponseCode() == HttpURLConnection.HTTP_MOVED_TEMP) {
				String location = connection.getHeaderField("Location");
				if (!location.contains(HTTP_OR_HTTPSSTART)) {
					location = urlString + "/" + location;
				}
				return location;
			}
		} catch (Exception e) {
			LOGGER.error("获取跳转链接超时，返回原链接:{}", urlString);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return urlString;
	}

	/**
	 * 获取Icon地址
	 * 
	 * @see :
	 * @param :
	 * @return : String
	 * @param urlString
	 * @return
	 * @throws MalformedURLException
	 */
	public static String getIconUrlString(String urlString)
	        throws MalformedURLException {

		urlString = getFinalUrl(urlString);
		URL url = new URL(urlString);
		String iconUrl = url.getProtocol() + "://" + url.getHost()
		        + "/favicon.ico";// 保证从域名根路径搜索
		if (hasRootIcon(iconUrl)) {
			return iconUrl;
		}

		return getIconUrlByXML(urlString);
	}

	/**
	 * 判断在根目录下是否有Icon
	 * 
	 * @see :
	 * @param :
	 * @return : boolean
	 * @param urlString
	 * @return
	 */
	private static boolean hasRootIcon(String urlString) {
		HttpURLConnection connection = null;

		try {
			connection = getConnection(urlString);
			connection.connect();
			boolean hasRootIcon = HttpURLConnection.HTTP_OK == connection
			        .getResponseCode() && connection.getContentLength() > 0;
			LOGGER.debug("判断是否有根icon的结果为:{}", hasRootIcon);
			return hasRootIcon;
		} catch (Exception e) {
			LOGGER.error("访问地址出错:{}", e.getMessage());
			return false;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	/**
	 * 从html中获取Icon地址
	 * 
	 * @see :
	 * @param :
	 * @return : String
	 * @param urlString
	 * @return
	 */
	private static String getIconUrlByRegex(String urlString) {

		try {
			String headString = getHead(urlString);

			for (Pattern iconPattern : ICON_PATTERNS) {
				Matcher matcher = iconPattern.matcher(headString);

				if (matcher.find()) {
					String iconUrl = matcher.group(1);
					if (iconUrl.contains("http")) {
						return iconUrl;
					}

					// 判断是否为相对路径或根路径
					if (iconUrl.charAt(0) == '/') {
						URL url = new URL(urlString);
						iconUrl = url.getProtocol() + "://" + url.getHost()
						        + iconUrl;
					} else {
						iconUrl = urlString + "/" + iconUrl;
					}
					return iconUrl;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 从html中获取Icon地址
	 * 
	 * @see :
	 * @param :
	 * @return : String
	 * @param urlString
	 * @return
	 */
	private static String getIconUrlByXML(String urlString) {
		String htmlContent = getHtml(urlString);
		String host = getSchemaAndHostAndPort(urlString);

		if (host.endsWith("/")) {
			host = host.substring(0, host.length());

			LOGGER.debug("host:{}", host);
		}
		Document document = Jsoup.parse(htmlContent);
		String finalResult = null;
		Elements links = document.getElementsByTag("link");
		for (int i = 0; i < links.size(); i++) {
			Element eachLink = (Element) links.get(i);
			LOGGER.debug("eachLink:{}", eachLink);

			String relType = eachLink.attr("rel");

			LOGGER.debug("link type:{}", relType);

			if (null != relType) {
				relType = relType.toLowerCase();
			} else {
				continue;
			}

			if (relType.contains("icon") || (relType.contains("shortcut")
			        && relType.contains("icon"))) {
				finalResult = eachLink.attr("href");
				break;
			}
		}

		if (null != finalResult) {
			if (!finalResult.startsWith(HTTP_OR_HTTPSSTART)) {
				if (!finalResult.startsWith("/")) {
					finalResult = "/" + finalResult;
				}

				finalResult = host + finalResult;
			}
		} else {
			finalResult = null;
		}
		LOGGER.debug("获取到的结果为:{}", finalResult);
		return finalResult;
	}

	/**
	 * 爬取一级域名
	 * 
	 * @see :
	 * @param :
	 * @return : Set<String>
	 * @param urlString
	 * @return
	 */
	private static Set<String> getUrls(String urlString) {

		Set<String> urlSet = new HashSet<String>();

		Matcher matcher = PATTERN_URL_PATTERN.matcher(getHtml(urlString));

		while (matcher.find()) {
			urlSet.add(matcher.group());
		}

		return urlSet;
	}

	/**
	 * 获取截止到head尾标签的文本
	 * 
	 * @see :
	 * @param :
	 * @return : String
	 * @param urlString
	 * @return
	 */
	private static final String getHead(String urlString) {
		HttpURLConnection connection = null;
		BufferedReader reader = null;

		try {
			connection = getConnection(urlString);
			connection.connect();
			reader = new BufferedReader(
			        new InputStreamReader(connection.getInputStream()));

			String line = null;
			StringBuilder headBuilder = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				LOGGER.debug("每行信息为：{}", line);
				// Matcher matcher = HEAD_END_PATTERN.matcher(line);
				headBuilder.append(line);
				// if (matcher.find()) {
				// break;
				// }
			}

			String headerString = headBuilder.toString();
			LOGGER.debug("头信息为:{}", headerString);
			return headerString;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (connection != null) {
					connection.disconnect();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取html页面文本
	 * 
	 * @see :
	 * @param :
	 * @return : String
	 * @param urlString
	 * @return
	 */
	private static final String getHtml(String urlString) {
		HttpURLConnection connection = null;
		BufferedReader reader = null;

		try {
			connection = getConnection(urlString);
			connection.connect();
			reader = new BufferedReader(
			        new InputStreamReader(connection.getInputStream()));

			String line = null;
			StringBuilder htmlBuilder = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				htmlBuilder.append(line);
			}
			LOGGER.debug("html页面内容为:{}", htmlBuilder.toString());
			return htmlBuilder.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (connection != null) {
					connection.disconnect();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取一个连接
	 * 
	 * @see :
	 * @param :
	 * @return : HttpURLConnection
	 * @param urlString
	 * @return
	 * @throws IOException
	 */
	private static HttpURLConnection getConnection(String urlString)
	        throws IOException {
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setInstanceFollowRedirects(false);
		connection.setConnectTimeout(3000);
		connection.setReadTimeout(3000);
		connection.setRequestProperty("User-Agent",
		        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.131 Safari/537.36");
		return connection;
	}

	/**
	 * 获取host
	 * 
	 * @see :
	 * @param :
	 * @return : String
	 * @return
	 */
	private static String getSchemaAndHostAndPort(String url) {
		URL realUrl;
		try {
			realUrl = new URL(url);
			int port = realUrl.getPort();

			String finalSchemaAndHostAndPort = "";

			finalSchemaAndHostAndPort = realUrl.getProtocol() + "://"
			        + realUrl.getHost();
			if (-1 != port) {
				finalSchemaAndHostAndPort = finalSchemaAndHostAndPort + ":"
				        + port;
			}

			return finalSchemaAndHostAndPort;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
