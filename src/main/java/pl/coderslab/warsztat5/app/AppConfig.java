package pl.coderslab.warsztat5.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.Filter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"pl.coderslab.warsztat5"})
public class AppConfig {
}
