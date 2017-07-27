package com.icloud.config.datasource;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidConfig2 {

	/** 数据源 **/
	 @Value("${oracle.driverClass}")
	    private String driverClass;

	    @Value("${oracle.url}")
	    private String url;

	    @Value("${oracle.username}")
	    private String username;

	    @Value("${oracle.password}")
	    private String password;

	    @Value("${oracle.initialSize}")
	    private int initialSize;
	    
	    @Value("${oracle.minIdle}")
	    private int minIdle;
	    
	    @Value("${oracle.maxActive}")
	    private int maxActive;
	    
	    @Value("${oracle.maxWait}")
	    private int maxWait;
	    
	    @Value("${oracle.timeBetweenEvictionRunsMillis}")
	    private int timeBetweenEvictionRunsMillis;
	    
	    @Value("${oracle.minEvictableIdleTimeMillis}")
	    private int minEvictableIdleTimeMillis;
	    
	    @Value("${oracle.validationQuery}")
	    private String validationQuery;
	    
	    @Value("${oracle.testWhileIdle}")
	    private boolean testWhileIdle;
	    
	    @Value("${oracle.testOnBorrow}")
	    private boolean testOnBorrow;
	    
	    @Value("${oracle.testOnReturn}")
	    private boolean testOnReturn;
	    
	    @Value("${oracle.poolPreparedStatements}")
	    private boolean poolPreparedStatements;
	    
	    @Value("${oracle.maxPoolPreparedStatementPerConnectionSize}")
	    private int maxPoolPreparedStatementPerConnectionSize;
	    
	    @Value("${oracle.filters}")
	    private String filters;
	    
	    @Value("{oracle.connectionProperties}")
	    private String connectionProperties;
	    
	    @Bean(name = "oracleDataSource")
	    public DataSource dataSource(){
	    	//
	    	DruidDataSource dataSource = new DruidDataSource();
//	        OracleDataSource dataSource = new OracleDataSource();
//	        dataSource.setUser(username);
//	        dataSource.setPassword(password);
//	        dataSource.setURL(url);
	    	dataSource.setUrl(url);
	    	dataSource.setUsername(username);
	    	dataSource.setPassword(password);
	    	dataSource.setDriverClassName(driverClass);
	      //configuration
	        dataSource.setInitialSize(initialSize);
	        dataSource.setMinIdle(minIdle);
	        dataSource.setMaxActive(maxActive);
	        dataSource.setMaxWait(maxWait);
	        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
	        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
	        dataSource.setValidationQuery(validationQuery);
	        dataSource.setTestWhileIdle(testWhileIdle);
	        dataSource.setTestOnBorrow(testOnBorrow);
	        dataSource.setTestOnReturn(testOnReturn);
	        dataSource.setPoolPreparedStatements(poolPreparedStatements);
	        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
	    	try {
	    		dataSource.setFilters(filters);
			} catch (SQLException e) {
				System.out.println("druid configuration initialization filter"+e);
			}
	    	dataSource.setConnectionProperties(connectionProperties);
	    	
	        return dataSource;
	    }

		
}
