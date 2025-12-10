package edu.mateo.back.Metroid.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mateo.back.Metroid.mapper.RegionEnemyMapper;
import edu.mateo.back.Metroid.model.dto.RegionEnemyDTO;
import edu.mateo.back.Metroid.service.RegionEnemyService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/regions-enemies")
public class RegionEnemyController {

    @Autowired
    private RegionEnemyService regionEnemyService;

    @Autowired
    private RegionEnemyMapper regionEnemyMapper;

    @GetMapping
    public List<RegionEnemyDTO> getAllRegionEnemies() {
        return regionEnemyService.getRegionsEnemies().stream().map(regionEnemyMapper::toDTO).toList();
    }
}
