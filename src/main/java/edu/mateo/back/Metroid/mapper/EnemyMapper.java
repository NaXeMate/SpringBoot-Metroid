package edu.mateo.back.Metroid.mapper;

import java.util.HashSet;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import edu.mateo.back.Metroid.model.dto.EnemyDTO;
import edu.mateo.back.Metroid.model.entities.Enemy;
import edu.mateo.back.Metroid.repository.EnemyRepository;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class EnemyMapper {

    @Autowired
    protected EnemyRepository enemyRepo;

    @Mapping(target = "stats", expression = "java(new edu.mateo.back.Metroid.model.valueobjetcs.CombatStats(dto.healthPoints(), dto.attackPower(), dto.speed(), dto.dangerLevel()))")
    public abstract Enemy toEntity(EnemyDTO enemyDTO);
    
    @Mapping(source = "stats.healthPoints", target = "healthPoints")
    @Mapping(source = "stats.attackPower", target = "attackPower")
    @Mapping(source = "stats.speed", target = "speed")
    @Mapping(source = "stats.dangerLevel", target = "dangerLevel")
    public abstract EnemyDTO toDTO(Enemy enemy);
    
    @Mapping(target = "stats", expression = "java(new edu.mateo.back.Metroid.model.valueobjetcs.CombatStats(dto.healthPoints(), dto.attackPower(), dto.speed(), dto.dangerLevel()))")
    public abstract void updateEntityFromDTO(EnemyDTO enemyDTO, @MappingTarget Enemy enemy);

    protected Set<Enemy> mapEnemies(Long[] enemyIds) {
        Set<Enemy> enemies = new HashSet<>();
        if (enemyIds != null) {
            for (Long id : enemyIds) {
                if (id != null) {
                    enemyRepo.findById(id).ifPresent(enemies::add);
                }
            }
        }
        return enemies;
    }

    protected Long[] mapEnemiesIds(Set<Enemy> enemies) {
        if (enemies == null || enemies.isEmpty()) {
            return new Long[0];
        }
        return enemies.stream()
                .map(Enemy::getEnemy_Id)
                .toArray(Long[]::new);
    }
}
