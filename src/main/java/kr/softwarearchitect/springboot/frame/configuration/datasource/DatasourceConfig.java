package kr.softwarearchitect.springboot.frame.configuration.datasource;

import kr.softwarearchitect.springboot.frame.configuration.prop.DataSouceProp;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DatasourceConfig
{

    @Inject
    private DataSouceProp dataSouceProp;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();

        String[] entityPackages = this.dataSouceProp.getJpa()
                .getEntityPackages()
                .toArray(new String[this.dataSouceProp.getJpa().getEntityPackages().size()]);

        em.setDataSource(dataSource());
        em.setPackagesToScan( entityPackages );
        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", this.dataSouceProp.getJpa().getHibernateSdlAuto());
        properties.put("hibernate.dialect", this.dataSouceProp.getJpa().getHibernateDialect());
        properties.put("hibernate.show_sql", this.dataSouceProp.getJpa().getHibernateShowSql());
        properties.put("hibernate.implicit_naming_strategy", this.dataSouceProp.getJpa().getHibernateImplicitStrategy() );
        properties.put("hibernate.physical_naming_strategy", this.dataSouceProp.getJpa().getHibernatePysicalNameStrategy());
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Primary
    @Bean
    public DataSource dataSource() {
        HikariDataSource ds = new HikariDataSource( this.getHikariProperties());
        ds.setMaximumPoolSize( this.dataSouceProp.getHikari().getMaximumPoolSize());
        ds.setMinimumIdle( this.dataSouceProp.getHikari().getInitActive());
        return ds;
    }

    private HikariConfig getHikariProperties()
    {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl( "jdbc:mysql://" + this.dataSouceProp.getConnection().getHost() + ":"  + this.dataSouceProp.getConnection().getPort() + "/" + this.dataSouceProp.getConnection().getDatabase() );
        config.setUsername( this.dataSouceProp.getConnection().getUsername() );
        config.setPassword( this.dataSouceProp.getConnection().getPassword() );
        config.setPoolName( this.dataSouceProp.getHikari().getPoolName());
        config.setConnectionTestQuery( this.dataSouceProp.getConnection().getValidationQuery());
        config.setConnectionInitSql( this.dataSouceProp.getConnection().getValidationQuery() );

        config.addDataSourceProperty("dataSource.cachePrepStmts", "true");
        config.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
        config.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit" , "2048");
        config.addDataSourceProperty("dataSource.useServerPrepStmts","true");
        config.addDataSourceProperty("dataSource.useLocalSessionState","true");
        config.addDataSourceProperty("dataSource.useLocalTransactionState","true");
        config.addDataSourceProperty("dataSource.rewriteBatchedStatements","true");
        config.addDataSourceProperty("dataSource.cacheResultSetMetadata","true");
        config.addDataSourceProperty("dataSource.cacheServerConfiguration","true");
        config.addDataSourceProperty("dataSource.elideSetAutoCommits","true");
        config.addDataSourceProperty("dataSource.maintainTimeStats","false");
        config.addDataSourceProperty("dataSource.encoding" ,"UTF-8");
        return config;
    }
}
