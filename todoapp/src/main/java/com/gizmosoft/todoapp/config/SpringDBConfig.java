package com.gizmosoft.todoapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement //<tx:annotation-driven>
@EnableJpaRepositories(basePackages="com.gizmosoft.todoapp.dao",transactionManagerRef="txManager")  //<jpa:repositories base-package="com.accenture.lkm.dao" transaction-manager-ref="txManager"
public class SpringDBConfig {
    // reading value from properties file and giving to the datasource
    @Value("${db_driver}")
    private String driverName;

    @Value("${db_url}")
    private String url;

    @Value("${user}")
    private String userName;

    @Value("${password}")
    private String password;
    //To resolve ${} in @Value
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "dataSource")
    public DriverManagerDataSource getDataSource() {
        System.out.println(driverName);
        System.out.println(url);
        System.out.println(userName);
        System.out.println(password);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        return dataSource;
    }

    public HibernateJpaVendorAdapter getVendorAdaptor(){
        HibernateJpaVendorAdapter adapter = new  HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        return adapter;
    }


    @Autowired
    // for wiring the DataSource
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(DriverManagerDataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factoryBuilder = new LocalContainerEntityManagerFactoryBean();
        factoryBuilder.setDataSource(dataSource);
        factoryBuilder.setJpaVendorAdapter(getVendorAdaptor());
        factoryBuilder.setPackagesToScan("com.gizmosoft.todoapp.entity");
        return factoryBuilder;
    }



    @Autowired
    // for injecting the session factory inside
    @Bean(name = "txManager")
    public JpaTransactionManager getTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory);
        return transactionManager;
    }

}
