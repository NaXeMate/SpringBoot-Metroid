package edu.mateo.back.Metroid.mapper;

import java.util.HashSet;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import edu.mateo.back.Metroid.model.dto.RegionDTO;
import edu.mateo.back.Metroid.model.entities.Region;
import edu.mateo.back.Metroid.repository.RegionRepository;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class RegionMapper {

    @Autowired
    protected RegionRepository regionRepo;
    
    @Mapping(target = "coordinates", expression = "java(new edu.mateo.back.Metroid.model.valueobjetcs.Coordinates(dto.latitude(), dto.altitude(), dto.longitude()))")
    public abstract Region toEntity(RegionDTO regionDTO);
    
    @Mapping(source = "coordinates.latitude", target = "latitude")
    @Mapping(source = "coordinates.altitude", target = "altitude")
    @Mapping(source = "coordinates.longitude", target = "longitude")
    public abstract RegionDTO toDTO(Region region);
    
    @Mapping(target = "coordinates", expression = "java(new edu.mateo.back.Metroid.model.valueobjetcs.Coordinates(dto.latitude(), dto.altitude(), dto.longitude()))")
    public abstract void updateEntityFromDTO(RegionDTO regionDTO, @MappingTarget Region region);

   protected Set<Region> mapRegions(Long[] regionIds) {
        Set<Region> regions = new HashSet<>();
        if (regionIds != null) {
            for (Long id : regionIds) {
                if (id != null) {
                    regionRepo.findById(id).ifPresent(regions::add);
                }
            }
        }
        return regions;
    }

    protected Long[] mapRegionIds(Set<Region> regions) {
        if (regions == null || regions.isEmpty()) {
            return new Long[0];
        }
        return regions.stream()
                .map(Region::getRegion_id)
                .toArray(Long[]::new);
    }
}
