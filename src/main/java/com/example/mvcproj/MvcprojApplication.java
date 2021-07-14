package com.example.mvcproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MvcprojApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(mvcprojApplicationClass, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(mvcprojApplicationClass);
  }

  private static Class<MvcprojApplication> mvcprojApplicationClass = MvcprojApplication.class;
}
