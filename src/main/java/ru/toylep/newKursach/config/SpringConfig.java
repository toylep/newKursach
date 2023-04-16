package ru.toylep.newKursach.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.toylep.newKursach.DAO.CommentDAO;
import ru.toylep.newKursach.DAO.DescriptionDAO;
import ru.toylep.newKursach.DAO.UserDAO;

import javax.sql.DataSource;

    @Configuration
    @ComponentScan("ru.toylep.MeetApp1")
    @EnableWebMvc
    public class SpringConfig {
        @Autowired
        private final ApplicationContext context;

        public SpringConfig(ApplicationContext context) {
            this.context = context;
        }
        @Bean
        public DataSource dataSource(){
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("org.postgresql.Driver");
            dataSource.setUrl("jdbc:postgresql://localhost:5432/KursachDB1");
            dataSource.setUsername("postgres");
            dataSource.setPassword("228322");
            return dataSource;
        }
        @Bean
        public JdbcTemplate jdbcTemplate(){
            return new JdbcTemplate(dataSource());
        }

        @Bean
        public UserDAO userDAO(){return new UserDAO(jdbcTemplate());}
        @Bean
        public DescriptionDAO descriptionDAO(){return new DescriptionDAO(jdbcTemplate());}
        @Bean
        public CommentDAO commentDAO(){return new CommentDAO(jdbcTemplate());}

    }


