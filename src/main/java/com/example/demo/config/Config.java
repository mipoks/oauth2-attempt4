package com.example.demo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.example.demo.converter.StringToOnwerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan({"com.example.demo.controller", "com.example.demo.config", "com.example.demo.service", "com.example.demo.converter", "com.example.demo.security"})
@EnableWebMvc
@EnableJpaRepositories(basePackages = "com.example.demo.repository")
@PropertySource("classpath:application.properties")
public class Config extends WebMvcConfigurerAdapter {

  @Bean
  public PasswordEncoder passwordEncoder() {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    return passwordEncoder;
  }

  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(new StringToOnwerConverter());
    super.addFormatters(registry);
  }

  @Autowired
  private Environment environment;

  @Bean
  public DataSource dataSource() {
    return new HikariDataSource(hikariConfig());
  }

  @Bean
  public HikariConfig hikariConfig() {
    HikariConfig hikariConfig = new HikariConfig();
    hikariConfig.setJdbcUrl(environment.getProperty("db.url"));
    hikariConfig.setMaximumPoolSize(Integer.parseInt(environment.getProperty("db.hikari.max-pool-size")));
    hikariConfig.setUsername(environment.getProperty("db.username"));
    hikariConfig.setPassword(environment.getProperty("db.password"));
    hikariConfig.setDriverClassName(environment.getProperty("db.driver.classname"));
    return hikariConfig;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    // создаем адаптер, который позволит Hibernate работать с Spring Data Jpa
    HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
    hibernateJpaVendorAdapter.setDatabase(Database.POSTGRESQL);
    // создали фабрику EntityManager как Spring-бин
    LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactory.setDataSource(dataSource());
    entityManagerFactory.setPackagesToScan("com.example.demo.model");
    entityManagerFactory.setJpaVendorAdapter(hibernateJpaVendorAdapter);
    entityManagerFactory.setJpaProperties(additionalProperties());
    return entityManagerFactory;
  }

  private Properties additionalProperties() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.hbm2ddl.auto", "update");
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
    properties.setProperty("hibernate.show_sql", "true");
    return properties;
  }

  @Bean
  public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory);

    return transactionManager;
  }

//  @Bean
//  public ViewResolver viewResolver() {
//    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//    resolver.setPrefix("/WEB-INF/jsp/");
//    resolver.setSuffix(".jsp");
//    resolver.setViewClass(JstlView.class);
//    resolver.setRedirectContextRelative(false);
//    return resolver;
//  }

//  @Bean
//  public ViewResolver jspViewResolver() {
//    InternalResourceViewResolver bean = new InternalResourceViewResolver();
//    bean.setPrefix("/WEB-INF/templates/jsp/");
//    bean.setSuffix(".jsp");
//    return bean;
//  }

  @Bean
  public ResourceBundleMessageSource resourceBundleMessageSource() {
    ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
    resourceBundleMessageSource.setBasename("messages");
    return resourceBundleMessageSource;
  }

  @Bean
  public CookieLocaleResolver localeResolver() {
    CookieLocaleResolver localeResolver = new CookieLocaleResolver();
    localeResolver.setCookieName("lang");
    return localeResolver;
  }

  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
    res.setBasenames("classpath:i18n/messages", "classpath:i18n/validation");
    res.setCacheSeconds(0);
    res.setDefaultEncoding("UTF-8");
    res.setUseCodeAsDefaultMessage(false);
    return res;
  }

}
