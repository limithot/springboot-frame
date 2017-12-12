package kr.softwarearchitect.springboot.frame.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Controller
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class, XADataSourceAutoConfiguration.class})
@ComponentScan(value= {"com.haii.frame.configuration.datasource"
        ,"com.haii.frame.configuration.filter"
        ,"com.haii.frame.configuration.prop"
        ,"com.haii.frame.configuration.react"

        ,"com.haii.hmt.modules.sensors.loguploader.component.async.actor"
        ,"com.haii.modules.external.amazon.aws.s3"})

@EnableTransactionManagement
//@EnableJpaRepositories(basePackages= {"com.haii.hmt.api.component.business.dao.rdb"})
@EnableScheduling
@EnableAsync
public class RootSpringConfig
{

}
