package edu.mateo.back.Metroid.service.interfaces;

import java.util.List;

import edu.mateo.back.Metroid.model.entities.Upgrade;
import edu.mateo.back.Metroid.model.enumerated.UpgradeClass;

public interface IUpgradeService {
    public List<Upgrade> getUpgrades();
    public Upgrade getUpgradeById(Long id);
    public Upgrade updateUpgrade(Upgrade upgrade);
    public void deleteUpgrade(Long id);
    public List<Upgrade> getUpgradesByClass(UpgradeClass upgradeClass);
}
