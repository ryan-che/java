package com.github.hualuomoli.config.app;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.hualuomoli.config.WebConfig;

@Configuration
// @PropertySource(value = { //
// "classpath:prop/jdbc.properties", //
// "file:path/to/test", // 测试环境绝对路径
// "file:path/to/publish", // 生产环境绝对路径
// }, ignoreResourceNotFound = true)
public class DataSourceConfig {

	private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

	private String driverClassName = WebConfig.getValue("jdbc", "driverClassName");
	private String url = WebConfig.getValue("jdbc", "url");
	private String username = WebConfig.getValue("jdbc", "username");
	private String password = WebConfig.getValue("jdbc", "password");

	@Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
	public DataSource dataSource() {
		logger.info("instance dataSource.");
		if (logger.isDebugEnabled()) {
			logger.debug("driverClassName {}", driverClassName);
			logger.debug("url {}", url);
			logger.debug("username {}", username);
			logger.debug("password {}", password);
		}

		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);

		return dataSource;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer placehodlerConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}