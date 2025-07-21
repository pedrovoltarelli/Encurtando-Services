package com.pxthedev.shorter_url.mapper;

import com.pxthedev.shorter_url.dto.URLResponseDto;
import com.pxthedev.shorter_url.entity.URL;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
public class URLMapper {

    private final ModelMapper mapper;

    public URLMapper(ModelMapper mapper) {
        this.mapper = mapper;
        configureMappings();
    }

    private void configureMappings(){
        TypeMap<URL, URLResponseDto> tm = mapper.createTypeMap(URL.class, URLResponseDto.class);
        tm.setProvider(request -> {URL source = (URL) request.getSource();
        return new URLResponseDto(source.getShortURL());});
    }

    public URLResponseDto toResponseDto(URL url){
        return mapper.map(url, URLResponseDto.class);
    }
}
