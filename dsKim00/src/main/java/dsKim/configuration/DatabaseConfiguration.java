package dsKim.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration// @springBootApplication안에 직접포함된건 아니지만 @springBootConfiguration에 포함되어있음
@PropertySource("classpath:/application.properties") //application.properties를 사용할 수 있도록 설정파일 위치를 지정해줌
public class DatabaseConfiguration {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() { //spring.datasource.hikari 로 시작하는 설정을 이용해 히카리CP의 설정파일을 만듬
		
		return new HikariConfig();
	}
	
	@Bean
	public DataSource dataSource() throws Exception{ //히카리 CP설정파일을 이용해 데이터베이스와 연결하는 데이터 소스를 생성한다.
		DataSource dataSource = new HikariDataSource(hikariConfig());
		System.out.println(dataSource.toString());
		
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{ //스프링-마이바티스에 sqlSessionFactory를 생선하기위해
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource); // 앞에 만들어진 dataSource를 설정
		sqlSessionFactoryBean.setMapperLocations(applicationContext
				.getResources("classpath:/mapper/**/sql-*.xml")); //마이바티스 매퍼 파일의 위치를 설정
		
		return sqlSessionFactoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
