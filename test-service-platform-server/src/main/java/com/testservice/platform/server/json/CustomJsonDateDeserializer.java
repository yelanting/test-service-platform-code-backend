/**
 * @author : 孙留平
 * @since : 2020年3月20日 上午10:52:56
 * @see:
 */
package com.testservice.platform.server.json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import com.testservice.platform.util.core.CalendarUtil;
import com.testservice.platform.util.core.StringUtil;

/**
 * @author : Administrator
 * @since : 2020年3月20日 上午10:52:56
 * @see :
 */
public class CustomJsonDateDeserializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt)
	        throws IOException, JsonProcessingException {
		SimpleDateFormat format = new SimpleDateFormat(
		        CalendarUtil.DEFAULT_FORMAT_WHOLE);

		SimpleDateFormat dateFormat = new SimpleDateFormat(
		        CalendarUtil.DEFAULT_FORMAT);
		String date = jp.getText();
		try {
			if (StringUtil.isBlank(date)) {// 防止空数据错误
				return null;
			}

			if (date.equals("0000-00-00")) {
				return null;
			}

			if (date.contains(" ")) {
				return format.parse(date);
			} else {
				return dateFormat.parse(date);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
