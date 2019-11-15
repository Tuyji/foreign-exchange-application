package com.openpayd.conversion;

import java.io.FileReader;
import java.io.IOException;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.openpayd.client.feign"})
@EnableSwagger2
public class ConversionApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ConversionApiApplication.class, args);
	}

    @Bean
    public Docket api() throws IOException, XmlPullParserException {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = reader.read(new FileReader("pom.xml"));
		ApiInfo apiInfo = new ApiInfoBuilder()
			.title("Conversions Api Documentation")
			.description("Documentation automatically generated")
			.contact(new Contact("Volkan Tuyji", null, "tjwolkan@gmail.com"))
			.version(model.getParent().getVersion())
			.build();
        
		return new Docket(DocumentationType.SWAGGER_2)  
          .select() 
          .apis(RequestHandlerSelectors.basePackage("com.openpayd.conversion.controller"))
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiInfo);                                           
    }

}
