/**
 * @author : 孙留平
 * @since : 2020年4月28日 上午5:35:30
 * @see:
 */
package com.testservice.platform.server.controller.reactive;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testservice.platform.server.model.SysUser;
import com.testservice.platform.util.vo.ResponseData;

import reactor.core.publisher.Mono;

/**
 * @author : Administrator
 * @since : 2020年4月28日 上午5:35:30
 * @see :
 */
@RestController
@RequestMapping("testReact")
public class ReactiveHelloController {
	@GetMapping("/helloReactive")
	public Mono<ResponseData> helloReact() {
		return Mono.just(ResponseData.getSuccessResult(new SysUser()));
	}
}
