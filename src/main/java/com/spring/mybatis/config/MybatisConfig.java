package com.spring.mybatis.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/**
 * The Class MybatisConfig.
 */
@Configuration
@EnableAutoConfiguration
@MapperScan("com.spring.*.mapper")
public class MybatisConfig {
	/**
	 * Data source.
	 *
	 * @return the data source
	 * @throws Exception
	 *             - the Exception
	 */
	@Bean
	public DataSource dataSource() throws Exception {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost:3306/hibernate?user=root&password=mysql&useSSL=true");
		
		// create a table and populate some data
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        System.out.println("Creating tables");
        jdbcTemplate.execute("drop table if exists hotel");
        jdbcTemplate.execute("create table hotel (city int, name varchar, address varchar, zip varchar)");
        jdbcTemplate.update("insert into hotel(city, name, address, zip) values (1, 'Taj Vivant', 'White Field', '560060')");

		return dataSource;
	}

	/**
	 * Transaction manager.
	 *
	 * @return the data source transaction manager
	 * @throws Exception
	 *             - the Exception
	 */
	@Bean
	public DataSourceTransactionManager transactionManager() throws Exception {
		return new DataSourceTransactionManager(dataSource());
	}

	/**
	 * Sql session factory.
	 *
	 * @return the sql session factory
	 * @throws Exception
	 *             the exception
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		// TypeHandler<?>[] typeHandlers = {
		// new UUIDTypeHandler(),
		// new JodaDateTimeTypeHandler(),
		// new BitTypeHandler()
		// };
		// sessionFactory.setTypeHandlers(typeHandlers);
		// sessionFactory.setTypeAliasesPackage("com.nextgen.framework.data.typehandlers");
		// Interceptor[] plugins = {mybatisExecutorPlugin};
		// sessionFactory.setPlugins(plugins);
		return sessionFactory.getObject();
	}
}
