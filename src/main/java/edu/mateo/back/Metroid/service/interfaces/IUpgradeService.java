package edu.mateo.back.Metroid.service.interfaces;

import java.util.List;

import edu.mateo.back.Metroid.model.entities.Upgrade;

public interface IUpgradeService {
    public List<Upgrade> getUpgrades();
    public Upgrade getUpgradeById(Long id);
    public Upgrade updateUpgrade(Upgrade upgrade);
    public void deleteUpgrade(Long id);
}
