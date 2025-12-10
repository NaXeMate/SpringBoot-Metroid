package edu.mateo.back.Metroid.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mateo.back.Metroid.model.entities.Upgrade;
import edu.mateo.back.Metroid.model.enumerated.UpgradeClass;
import edu.mateo.back.Metroid.repository.UpgradeRepository;
import edu.mateo.back.Metroid.service.interfaces.IUpgradeService;

@Service
public class UpgradeService implements IUpgradeService {

    @Autowired
    private UpgradeRepository upgradeRepo;

    @Override
    public List<Upgrade> getUpgrades() {
        return upgradeRepo.findAll();
    }

    @Override
    public Upgrade getUpgradeById(Long id) {
        Optional<Upgrade> op = upgradeRepo.findById(id);

        if (op.isPresent()) {
            return op.get();
        }

        return null;
    }

    @Override
    public Upgrade updateUpgrade(Upgrade upgrade) {
        if (upgrade.getUpgrade_id() == null) {
            System.out.println("Upgrade " + upgrade.getName() + " added to the logbook.");
            return upgradeRepo.save(upgrade);
        } else {
            if (upgradeRepo.existsById(upgrade.getUpgrade_id())) {
                System.out.println("Upgrade " + upgrade.getName() + " logbook record updated.");
                return upgradeRepo.save(upgrade);
            } else {
                System.out.println("Upgrade " + upgrade.getName() + " is not saved into the logbook.");
                return null;
            }
        }
    }

    @Override
    public void deleteUpgrade(Long id) {
        Upgrade upgradeToDelete = upgradeRepo.findById(id).orElseThrow();
        upgradeRepo.deleteById(id);
        System.out.println("Upgrade " + upgradeToDelete.getName() + " deleted from the logbook.");
    }

    @Override
    public List<Upgrade> getUpgradesByClass(UpgradeClass upgradeClass) {
        return upgradeRepo.findByUpgradeClass(upgradeClass);
    }

}
