package edu.mateo.back.Metroid.service.interfaces;

import java.util.List;

import edu.mateo.back.Metroid.model.entities.Region;
import edu.mateo.back.Metroid.model.enumerated.Planet;

public interface IRegionService {
    public List<Region> getRegions();
    public Region getRegionById(Long id);
    public Region updateRegion(Region region);
    public void deleteRegion(Long id);
    public List<Region> getRegionsByPlanet(Planet planet);
}
