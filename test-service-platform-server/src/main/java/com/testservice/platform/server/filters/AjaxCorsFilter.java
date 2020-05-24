package com.testservice.platform.server.filters;
/// **
// * @author : 孙留平
// * @since : 2020年3月17日 上午10:50:52
// * @see:
// */
// package com.testservice.platform.server.filters;
//
// import java.util.Arrays;
// import java.util.List;
//
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.Ordered;
// import org.springframework.core.annotation.Order;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
// import org.springframework.web.filter.CorsFilter;
//
/// **
// * @author : Administrator
// * @since : 2020年3月17日 上午10:50:52
// * @see :
// */
//
// @Configuration
// @Order(Ordered.HIGHEST_PRECEDENCE)
// public class AjaxCorsFilter extends CorsFilter {
//
// /**
// * @see :
// * @param configSource
// */
// public AjaxCorsFilter(CorsConfigurationSource configSource) {
// super(configSource);
// }
//
// private static UrlBasedCorsConfigurationSource configurationSource() {
// CorsConfiguration corsConfig = new CorsConfiguration();
// List<String> allowedHeaders = Arrays.asList("x-auth-token",
// "content-type", "X-Requested-With", "XMLHttpRequest");
// List<String> exposedHeaders = Arrays.asList("x-auth-token",
// "content-type", "X-Requested-With", "XMLHttpRequest");
// List<String> allowedMethods = Arrays.asList("POST", "GET", "DELETE",
// "PUT", "OPTIONS");
// List<String> allowedOrigins = Arrays.asList("*");
// corsConfig.setAllowedHeaders(allowedHeaders);
// corsConfig.setAllowedMethods(allowedMethods);
// corsConfig.setAllowedOrigins(allowedOrigins);
// corsConfig.setExposedHeaders(exposedHeaders);
// corsConfig.setMaxAge(36000L);
// corsConfig.setAllowCredentials(true);
//
// UrlBasedCorsConfigurationSource source = new
/// UrlBasedCorsConfigurationSource();
// source.registerCorsConfiguration("/**", corsConfig);
// return source;
// }
// }
