package com.icloud.config.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @filename      : MyBatisScan.java
 * @description   : 
 * @author        : zdh
 * @create        : 2017年7月27日 上午9:26:19   
 * @copyright     : zhumeng.com@send-msg-project
 *
 * Modification History:
 * Date             Author       Version
 * --------------------------------------
 */
@Configuration
@MapperScan(basePackages = {"com.icloud.dao2.*"}, sqlSessionFactoryRef = "oracleSqlSessionFactory")
public class MyBatisScanOracle {

	@Autowired
    @Qualifier("oracleDataSource")
    private DataSource oracleDataSource;

    @Bean(name = "oracleSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(oracleDataSource);
    	PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    	sessionFactory.setMapperLocations(resolver.getResources("classpath:/com/icloud/dao2/*/mapping/*.xml")); // "**"代表多个文件夹下
      	return sessionFactory.getObject();
    }

    /** 事物管理 **/
	@Bean(name = "oraclePlatformTransactionManager")
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(oracleDataSource);
	}
}
