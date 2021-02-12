//package com.f1soft.springdemo.config;
//
//
//import org.hibernate.jpa.HibernatePersistenceProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//public class HibernateConfig {
//
//    @Autowired
//    private Environment env;
//
//
//
//    @Bean
//    public DataSource dataSource() {
//
//        String username = env.getProperty("spring.datasource.username");
//        String password = env.getProperty("spring.datasource.password");
//        String driverClass = env.getProperty("spring.datasource.driver-class-name");
//        String url = env.getProperty("spring.datasource.url");
//
//        return DataSourceBuilder.create().username(username).password(password).url(url).driverClassName(driverClass)
//                .build();
//    }
//    @Bean
//    public JpaTransactionManager jpaTransactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//        return transactionManager;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
//        entityManagerFactoryBean.setDataSource(dataSource());
//        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//        entityManagerFactoryBean.setPackagesToScan("com.f1soft.springdemo.transactionmanagement.profile");
//        entityManagerFactoryBean.setJpaProperties(addProperties());
//        return entityManagerFactoryBean;
//    }
//    private HibernateJpaVendorAdapter vendorAdaptor() {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        return vendorAdapter;
//    }
//    private Properties addProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
//        properties.setProperty("hibernate.dialect", env.getProperty("spring.jpa.hibernate.dialect"));
//        properties.setProperty("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
//        properties.setProperty("hibernate.format_sql", env.getProperty("spring.jpa.hibernate.format_sql"));
//        // we can add
//        return properties;
//    }
//}
//
//
