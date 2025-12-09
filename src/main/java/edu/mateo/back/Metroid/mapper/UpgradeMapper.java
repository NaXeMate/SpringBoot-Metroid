package edu.mateo.back.Metroid.mapper;

import java.util.HashSet;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import edu.mateo.back.Metroid.model.dto.UpgradeDTO;
import edu.mateo.back.Metroid.model.entities.Upgrade;
import edu.mateo.back.Metroid.repository.UpgradeRepository;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UpgradeMapper {

    @Autowired
    protected UpgradeRepository upgradeRepo;

    public abstract Upgrade toEntity(UpgradeDTO upgradeDTO);

    @Mapping(target = "requiredUpgradeId", source = "requiredUpgrade.upgrade_id")
    public abstract UpgradeDTO toDTO(Upgrade upgrade);

    public abstract void updateEntityFromDTO(UpgradeDTO upgradeDTO, @MappingTarget Upgrade upgrade);

    protected Set<Upgrade> mapUpgrades(Long[] upgradeIds) {
        Set<Upgrade> upgrades = new HashSet<>();
        if (upgradeIds != null) {
            for (Long id : upgradeIds) {
                if (id != null) {
                    upgradeRepo.findById(id).ifPresent(upgrades::add);
                }
            }
        }
        return upgrades;
    }

    protected Long[] mapUpgradeIds(Set<Upgrade> upgrades) {
        if (upgrades == null || upgrades.isEmpty()) {
            return new Long[0];
        }
        return upgrades.stream()
                .map(Upgrade::getUpgrade_id)
                .toArray(Long[]::new);
    }

}
