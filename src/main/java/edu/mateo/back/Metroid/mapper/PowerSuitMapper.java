package edu.mateo.back.Metroid.mapper;

import java.util.HashSet;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import edu.mateo.back.Metroid.model.dto.PowerSuitDTO;
import edu.mateo.back.Metroid.model.entities.PowerSuit;
import edu.mateo.back.Metroid.repository.PowerSuitRepository;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class PowerSuitMapper {

    @Autowired
    protected PowerSuitRepository suitRepo;

    @Mapping(target = "energyStatus", expression = "java(new edu.mateo.back.Metroid.model.valueobjetcs.EnergyStatus(dto.energyTanks(), dto.reserveTanks()))")
    @Mapping(target = "defenseRating", expression = "java(new edu.mateo.back.Metroid.model.valueobjetcs.DefenseRating(dto.damageReduction(), dto.heatResistance(), dto.radiationResistance()))")
    public abstract PowerSuit toEntity(PowerSuitDTO suitDTO);

    @Mapping(source = "energyStatus.energyTanks", target = "energyTanks")
    @Mapping(source = "energyStatus.reserveTanks", target = "reserveTanks")
    @Mapping(source = "defenseRating.damageReduction", target = "damageReduction")
    @Mapping(source = "defenseRating.heatResistance", target = "heatResistance")
    @Mapping(source = "defenseRating.radiationResistance", target = "radiationResistance")
    public abstract PowerSuitDTO toDTO(PowerSuit powerSuit);

    @Mapping(target = "energyStatus", expression = "java(new edu.mateo.back.Metroid.model.valueobjetcs.EnergyStatus(dto.energyTanks(), dto.reserveTanks()))")
    @Mapping(target = "defenseRating", expression = "java(new edu.mateo.back.Metroid.model.valueobjetcs.DefenseRating(dto.damageReduction(), dto.heatResistance(), dto.radiationResistance()))")
    public abstract void updateEntityFromDTO(PowerSuitDTO suitDTO, @MappingTarget PowerSuit suit);

    protected Set<PowerSuit> mapSuits(Long[] suitIds) {
        Set<PowerSuit> suits = new HashSet<>();
        if (suitIds != null) {
            for (Long id : suitIds) {
                if (id != null) {
                    suitRepo.findById(id).ifPresent(suits::add);
                }
            }
        }
        return suits;
    }

    protected Long[] mapsuitsIds(Set<PowerSuit> suits) {
        if (suits == null || suits.isEmpty()) {
            return new Long[0];
        }
        return suits.stream()
                .map(PowerSuit::getPowerSuit_Id)
                .toArray(Long[]::new);
    }
}
