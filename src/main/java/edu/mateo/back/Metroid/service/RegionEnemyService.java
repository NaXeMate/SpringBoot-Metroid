package edu.mateo.back.Metroid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mateo.back.Metroid.model.entities.RegionEnemy;
import edu.mateo.back.Metroid.repository.RegionEnemyRepository;
import edu.mateo.back.Metroid.service.interfaces.IRegionEnemyService;

@Service
public class RegionEnemyService implements IRegionEnemyService {

    @Autowired
    private RegionEnemyRepository regionEnemyRepo;

    @Override
    public List<RegionEnemy> getRegionsEnemies() {
        return regionEnemyRepo.findAll();
    }
}
