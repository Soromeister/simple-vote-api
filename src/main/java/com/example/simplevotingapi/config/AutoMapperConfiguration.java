package com.example.simplevotingapi.config;


import io.github.linpeilie.annotations.MapperConfig;
import org.mapstruct.Builder;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperConfig(builder = @Builder)
//@MapperConfig(builder = @Builder(disableBuilder = true))
public class AutoMapperConfiguration {

}
