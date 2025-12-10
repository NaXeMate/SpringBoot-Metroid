package edu.mateo.back.Metroid.controllers;

import java.util.List;
import edu.mateo.back.Metroid.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mateo.back.Metroid.mapper.RegionMapper;
import edu.mateo.back.Metroid.model.dto.RegionDTO;
import edu.mateo.back.Metroid.model.entities.Region;
import edu.mateo.back.Metroid.model.enumerated.Planet;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @Autowired
    private RegionMapper regionMapper;

    @GetMapping
    public List<RegionDTO> getAllRegions() {
        return regionService.getRegions().stream().map(regionMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public RegionDTO getEnemyById(@PathVariable("id") Long id) {
        return regionMapper.toDTO(regionService.getRegionById(id));
    }

    @PostMapping("/save")
    public RegionDTO saveRegion(@RequestBody RegionDTO regionDto) {
        Region region = regionMapper.toEntity(regionDto);

        region.setRegion_Id(null);

        Region saved = regionService.updateRegion(region);
        
        return regionMapper.toDTO(saved);
    }

    @PutMapping("/{id}")
    public RegionDTO updateRegion(@PathVariable("id") Long id, @RequestBody RegionDTO regionDto) {
        Region existingRegion = regionService.getRegionById(id);

        if (existingRegion == null) {
            throw new RuntimeException("Region with ID: " + id + "not founded in the logbook");
        }

        regionMapper.updateEntityFromDTO(regionDto, existingRegion);

        existingRegion.setRegion_Id(id);

        Region updatedRegion = regionService.updateRegion(existingRegion);
        
        return regionMapper.toDTO(updatedRegion);
    }

    @DeleteMapping("/delete/{id}")
    public RegionDTO deleteRegion(@PathVariable("id") Long id) {
        Region deleted = regionService.getRegionById(id);

        if (deleted == null) {
            throw new RuntimeException("Region with ID: " + id + "not founded in the logbook");
        }

        regionService.deleteRegion(id);

        return regionMapper.toDTO(deleted);
    }
    
    // ============
    // ENDPOINTS 
    // ============
    
    @GetMapping("/planet/{planet}")
    public List<RegionDTO> getRegionsByPlanet(@PathVariable("planet") String planet) {
        Planet stringPlanet = Planet.valueOf(planet.toUpperCase());

        List<Region> regions = regionService.getRegionsByPlanet(stringPlanet);
        
        return regions.stream().map(regionMapper::toDTO).toList();
    }
    
}
