/**
 * @author : 孙留平
 * @since : 2020年3月17日 上午10:22:41
 * @see:
 */
package com.testservice.platform.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : Administrator
 * @since : 2020年3月17日 上午10:22:41
 * @see :
 */
@Controller
public class IndexController {
	@GetMapping("/index")
	public String index() {
		return "index";
	}
}
