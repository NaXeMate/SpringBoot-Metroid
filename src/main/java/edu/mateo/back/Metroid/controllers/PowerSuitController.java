package edu.mateo.back.Metroid.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mateo.back.Metroid.mapper.PowerSuitMapper;
import edu.mateo.back.Metroid.model.dto.PowerSuitDTO;
import edu.mateo.back.Metroid.model.entities.PowerSuit;
import edu.mateo.back.Metroid.service.PowerSuitService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/suits")
public class PowerSuitController {

    @Autowired
    private PowerSuitService suitService;

    @Autowired
    private PowerSuitMapper suitMapper;

    @GetMapping()
    public List<PowerSuitDTO> getAllSuits() {
        return suitService.getSuits().stream().map(suitMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public PowerSuitDTO getSuitById(@PathVariable("id") Long id) {
        return suitMapper.toDTO(suitService.getSuitById(id));
    }

    @PostMapping("/save")
    public PowerSuitDTO saveSuit(@RequestBody PowerSuitDTO suitDto) {
        PowerSuit suit = suitMapper.toEntity(suitDto);

        suit.setPowerSuit_Id(null);

        PowerSuit saved = suitService.updateSuit(suit);
        
        return suitMapper.toDTO(saved);
    }

    @PutMapping("/{id}")
    public PowerSuitDTO updateSuit(@PathVariable("id") Long id, @RequestBody PowerSuitDTO suitDto) {
        PowerSuit existingSuit = suitService.getSuitById(id);

        if (existingSuit == null) {
            throw new RuntimeException("Suit with ID: " + id + "not founded in the logbook");
        }
        
        suitMapper.updateEntityFromDTO(suitDto, existingSuit);

        existingSuit.setPowerSuit_Id(id);

        PowerSuit updatedSuit = suitService.updateSuit(existingSuit);

        return suitMapper.toDTO(updatedSuit);
    }    
    
    @DeleteMapping("/delete/{id}")
    public PowerSuitDTO deleteSuit(@PathVariable("id") Long id) {
        PowerSuit deleted = suitService.getSuitById(id);

        if (deleted == null) {
            throw new RuntimeException("Suit with ID: " + id + "not founded in the logbook");            
        }

        suitService.deleteSuit(id);

        return suitMapper.toDTO(deleted);
    }

    // ============
    // ENDPOINT
    // ============

    /**
     * Returns the remaining energy of a Power Suit as a percentage based on its current and maximum energy.
     */

    @GetMapping("/{id}/energy-percentage")
    public int getEnergyPercentage(@PathVariable("id") Long id) {
        PowerSuit suit = suitService.getSuitById(id);

        if (suit == null) {
            throw new RuntimeException("Suit with ID: " + id + "not founded in the logbook");            
        }

        int current_energy = suit.getEnergyStatus().getCurrentEnergy();

        int max_energy = suit.getEnergyStatus().getMaxEnergy();

        if (max_energy <= 0) {
            return 0;
        }
        
        return (int) Math.round((current_energy * 100.0)/max_energy);
    }
}
