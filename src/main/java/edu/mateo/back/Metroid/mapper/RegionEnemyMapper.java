package edu.mateo.back.Metroid.mapper;

import java.util.HashSet;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import edu.mateo.back.Metroid.model.dto.RegionEnemyDTO;
import edu.mateo.back.Metroid.model.entities.RegionEnemy;
import edu.mateo.back.Metroid.repository.RegionEnemyRepository;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class RegionEnemyMapper {

    @Autowired
    protected RegionEnemyRepository regionEnemyRepo;

    public abstract RegionEnemy toEntity(RegionEnemyDTO regionEnemyDTO);

    public abstract RegionEnemyDTO toDTO(RegionEnemy regionEnemy);

    public abstract void updateEntityFromDTO(RegionEnemyDTO regionEnemyDTO, @MappingTarget RegionEnemy regionEnemy);

    protected Set<RegionEnemy> mapRegionEnemies(Long[] regionEnemyIds) {
        Set<RegionEnemy> regionEnemies = new HashSet<>();
        if (regionEnemyIds != null) {
            for (Long id : regionEnemyIds) {
                if (id != null) {
                    regionEnemyRepo.findById(id).ifPresent(regionEnemies::add);
                }
            }
        }
        return regionEnemies;
    }

    protected Long[] mapRegionsEnemiesIds(Set<RegionEnemy> regionEnemies) {
        if (regionEnemies == null || regionEnemies.isEmpty()) {
            return new Long[0];
        }
        
        return regionEnemies.stream()
                .map(RegionEnemy::getRegionEnemyId)
                .toArray(Long[]::new);
    }
}
