package edu.mateo.back.Metroid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mateo.back.Metroid.model.entities.Upgrade;
import edu.mateo.back.Metroid.model.enumerated.UpgradeClass;

public interface UpgradeRepository extends JpaRepository<Upgrade, Long> {
    List<Upgrade> findByUpgradeClass(UpgradeClass upgradeClass);
}
