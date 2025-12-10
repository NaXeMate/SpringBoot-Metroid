package edu.mateo.back.Metroid.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mateo.back.Metroid.mapper.UpgradeMapper;
import edu.mateo.back.Metroid.model.dto.UpgradeDTO;
import edu.mateo.back.Metroid.model.entities.Upgrade;
import edu.mateo.back.Metroid.model.enumerated.UpgradeClass;
import edu.mateo.back.Metroid.service.UpgradeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/upgrades")
public class UpgradeController {

    @Autowired
    private UpgradeService upgradeService;

    @Autowired
    private UpgradeMapper upgradeMapper;

    @GetMapping
    public List<UpgradeDTO> getAllUpgrades() {
        return upgradeService.getUpgrades().stream().map(upgradeMapper::toDTO).toList();
    }
    
    @GetMapping("/{id}")
    public UpgradeDTO getUpgradeById(@PathVariable("id") Long id) {
        return upgradeMapper.toDTO(upgradeService.getUpgradeById(id));
    }

    @PostMapping("/save")
    public UpgradeDTO saveUpgrade(@RequestBody UpgradeDTO upgradeDto) {
        Upgrade upgrade = upgradeMapper.toEntity(upgradeDto);

        upgrade.setUpgrade_id(null);

        Upgrade saved = upgradeService.updateUpgrade(upgrade);
        
        return upgradeMapper.toDTO(saved);
    }

    @PutMapping("/{id}")
    public UpgradeDTO updateUpgrade(@PathVariable("id") Long id, @RequestBody UpgradeDTO upgradeDto) {
        Upgrade existingUpgrade = upgradeService.getUpgradeById(id);

        if (existingUpgrade == null) {
            throw new RuntimeException("Upgrade with ID: " + id + "not founded in the logbook");
        }

        upgradeMapper.updateEntityFromDTO(upgradeDto, existingUpgrade);
    
        existingUpgrade.setUpgrade_id(id);

        Upgrade updatedUpgrade = upgradeService.updateUpgrade(existingUpgrade);
        
        return upgradeMapper.toDTO(updatedUpgrade);
    }

    @DeleteMapping("/delete/{id}")
    public UpgradeDTO deleteUpgrade(@PathVariable("id") Long id) {
        Upgrade deleted = upgradeService.getUpgradeById(id);

        if (deleted == null) {
           throw new RuntimeException("Upgrade with ID: " + id + "not founded in the logbook");
        }

        upgradeService.deleteUpgrade(id);

        return upgradeMapper.toDTO(deleted);
    }
    
    // ============
    // ENDPOINT
    // ============

    @GetMapping("/class/{upgradeClass}")
    public List<UpgradeDTO> getUpgradesByClass(@PathVariable("upgradeClass") String upgradeClass) {
        UpgradeClass stringClass = UpgradeClass.valueOf(upgradeClass.toUpperCase());

        return upgradeService.getUpgradesByClass(stringClass).stream().map(upgradeMapper::toDTO).toList();
    }
    
}
