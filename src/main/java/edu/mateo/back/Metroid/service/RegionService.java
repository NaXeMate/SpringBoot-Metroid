package edu.mateo.back.Metroid.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mateo.back.Metroid.model.entities.Region;
import edu.mateo.back.Metroid.repository.RegionRepository;
import edu.mateo.back.Metroid.service.interfaces.IRegionService;

@Service
public class RegionService implements IRegionService {

    @Autowired
    private RegionRepository regionRepo;

    @Override
    public List<Region> getRegions() {
        return regionRepo.findAll();
    }

    @Override
    public Region getRegionById(Long id) {
        Optional<Region> op = regionRepo.findById(id);

        if (op.isPresent()) {
            return op.get();
        }

        return null;
    }

    @Override
    public Region updateRegion(Region region) {
        if (region.getRegion_id() == null) {
            System.out.println("Region " + region.getName() + " added to the logbook.");
            return regionRepo.save(region);
        } else {
            if (regionRepo.existsById(region.getRegion_id())) {
                System.out.println("Region " + region.getName() + " logbook record updated.");
                return regionRepo.save(region);
            } else {
                System.out.println("Region " + region.getName() + " is not saved into the logbook.");
                return null;
            }
        }
    }

    @Override
    public void deleteRegion(Long id) {
        Region regionToDelete = regionRepo.findById(id).orElseThrow();
        regionRepo.deleteById(id);
        System.out.println("Region " + regionToDelete.getName() + " deleted from the logbook.");
    }

}
