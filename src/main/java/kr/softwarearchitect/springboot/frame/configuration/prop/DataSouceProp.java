package kr.softwarearchitect.springboot.frame.configuration.prop;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@ConfigurationProperties("datasource")
public class DataSouceProp
{
    private Connection connection;
    private Hikari hikari;
    private Jpa jpa;

    public Connection getConnection()
    {
        return connection;
    }

    public void setConnection(Connection connection)
    {
        this.connection = connection;
    }

    public Hikari getHikari()
    {
        return hikari;
    }

    public void setHikari(Hikari hikari)
    {
        this.hikari = hikari;
    }

    public Jpa getJpa()
    {
        return jpa;
    }

    public void setJpa(Jpa jpa)
    {
        this.jpa = jpa;
    }

    public static class Connection implements Serializable
    {
        private String host;
        private String port;
        private String database;
        private String username;
        private String password;
        private String driverClassName;
        private String type;
        private String validationQuery;

        public String getHost()
        {
            return host;
        }

        public void setHost(String host)
        {
            this.host = host;
        }

        public String getPort()
        {
            return port;
        }

        public void setPort(String port)
        {
            this.port = port;
        }

        public String getDatabase()
        {
            return database;
        }

        public void setDatabase(String database)
        {
            this.database = database;
        }

        public String getUsername()
        {
            return username;
        }

        public void setUsername(String username)
        {
            this.username = username;
        }

        public String getPassword()
        {
            return password;
        }

        public void setPassword(String password)
        {
            this.password = password;
        }

        public String getDriverClassName()
        {
            return driverClassName;
        }

        public void setDriverClassName(String driverClassName)
        {
            this.driverClassName = driverClassName;
        }

        public String getType()
        {
            return type;
        }

        public void setType(String type)
        {
            this.type = type;
        }

        public String getValidationQuery()
        {
            return validationQuery;
        }

        public void setValidationQuery(String validationQuery)
        {
            this.validationQuery = validationQuery;
        }
    }

    public static  class Hikari implements Serializable
    {
        private String poolName;
        private long connectionTimeout;
        private int initActive;
        private long maxLifetime;
        private int maximumPoolSize;

        public int getInitActive()
        {
            return initActive;
        }

        public void setInitActive(int initActive)
        {
            this.initActive = initActive;
        }

        public String getPoolName()
        {
            return poolName;
        }

        public void setPoolName(String poolName)
        {
            this.poolName = poolName;
        }

        public long getConnectionTimeout()
        {
            return connectionTimeout;
        }

        public void setConnectionTimeout(long connectionTimeout)
        {
            this.connectionTimeout = connectionTimeout;
        }



        public long getMaxLifetime()
        {
            return maxLifetime;
        }

        public void setMaxLifetime(long maxLifetime)
        {
            this.maxLifetime = maxLifetime;
        }

        public int getMaximumPoolSize()
        {
            return maximumPoolSize;
        }

        public void setMaximumPoolSize(int maximumPoolSize)
        {
            this.maximumPoolSize = maximumPoolSize;
        }
    }

    public static class Jpa implements Serializable
    {
        private String hibernateSdlAuto;
        private String hibernateDialect;
        private String hibernateFormatSql;
        private String hibernateShowSql;
        private String hibernateImplicitStrategy;
        private String hibernatePysicalNameStrategy;
        private List<String> entityPackages;

        public List<String> getEntityPackages()
        {
            return entityPackages;
        }

        public void setEntityPackages(List<String> entityPackages)
        {
            this.entityPackages = entityPackages;
        }

        public String getHibernateSdlAuto()
        {
            return hibernateSdlAuto;
        }

        public void setHibernateSdlAuto(String hibernateSdlAuto)
        {
            this.hibernateSdlAuto = hibernateSdlAuto;
        }

        public String getHibernateDialect()
        {
            return hibernateDialect;
        }

        public void setHibernateDialect(String hibernateDialect)
        {
            this.hibernateDialect = hibernateDialect;
        }

        public String getHibernateFormatSql()
        {
            return hibernateFormatSql;
        }

        public void setHibernateFormatSql(String hibernateFormatSql)
        {
            this.hibernateFormatSql = hibernateFormatSql;
        }

        public String getHibernateShowSql()
        {
            return hibernateShowSql;
        }

        public void setHibernateShowSql(String hibernateShowSql)
        {
            this.hibernateShowSql = hibernateShowSql;
        }

        public String getHibernateImplicitStrategy()
        {
            return hibernateImplicitStrategy;
        }

        public void setHibernateImplicitStrategy(String hibernateImplicitStrategy)
        {
            this.hibernateImplicitStrategy = hibernateImplicitStrategy;
        }

        public String getHibernatePysicalNameStrategy()
        {
            return hibernatePysicalNameStrategy;
        }

        public void setHibernatePysicalNameStrategy(String hibernatePysicalNameStrategy)
        {
            this.hibernatePysicalNameStrategy = hibernatePysicalNameStrategy;
        }
    }
}
