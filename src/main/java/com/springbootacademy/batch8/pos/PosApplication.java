package com.springbootacademy.batch8.pos;

import com.springbootacademy.batch8.pos.config.SwaggerConfig;
import com.springbootacademy.batch8.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch8.pos.entity.Item;
import com.springbootacademy.batch8.pos.util.mappers.ItemMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class PosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosApplication.class, args);
	}

}
