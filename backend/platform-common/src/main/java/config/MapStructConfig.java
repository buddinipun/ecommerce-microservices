package config;


import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import mapper.MapperConstants;

@MapperConfig(

        componentModel = MapperConstants.COMPONENT_MODEL,

        injectionStrategy = InjectionStrategy.CONSTRUCTOR,

        unmappedTargetPolicy = ReportingPolicy.ERROR,

        unmappedSourcePolicy = ReportingPolicy.IGNORE,

        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,

        nullValuePropertyMappingStrategy =
                NullValuePropertyMappingStrategy.IGNORE,

        nullValueMappingStrategy =
                NullValueMappingStrategy.RETURN_NULL,

        mappingInheritanceStrategy =
                MappingInheritanceStrategy.AUTO_INHERIT_ALL_FROM_CONFIG,

        collectionMappingStrategy =
                CollectionMappingStrategy.ACCESSOR_ONLY

)
public interface MapStructConfig {

}
