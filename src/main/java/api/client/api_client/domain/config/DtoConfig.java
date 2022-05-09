package api.client.api_client.domain.config;

import api.client.api_client.domain.dto.ResponseDto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DtoConfig {
    
    @Bean
    public ResponseDto responseDto(){
        return new ResponseDto();
    }
}
