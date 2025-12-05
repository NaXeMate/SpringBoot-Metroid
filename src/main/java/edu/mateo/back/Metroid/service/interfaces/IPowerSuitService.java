package edu.mateo.back.Metroid.service.interfaces;

import java.util.List;

import edu.mateo.back.Metroid.model.entities.PowerSuit;

public interface IPowerSuitService {
    public List<PowerSuit> getSuits();
    public PowerSuit getSuitById(Long id);
    public PowerSuit updateSuit(PowerSuit powerSuit);
    public void deleteSuit(Long id);

}
