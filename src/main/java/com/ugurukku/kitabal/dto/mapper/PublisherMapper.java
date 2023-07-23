package com.ugurukku.kitabal.dto.mapper;

import com.ugurukku.kitabal.dto.PublisherRequest;
import com.ugurukku.kitabal.entities.Publisher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    Publisher toEntity(PublisherRequest publisherRequest);

}
