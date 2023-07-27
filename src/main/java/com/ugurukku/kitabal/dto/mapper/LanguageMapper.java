package com.ugurukku.kitabal.dto.mapper;

import com.ugurukku.kitabal.dto.LanguageRequest;
import com.ugurukku.kitabal.entities.Language;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LanguageMapper {

   Language toEntity(LanguageRequest languageRequest);

}
