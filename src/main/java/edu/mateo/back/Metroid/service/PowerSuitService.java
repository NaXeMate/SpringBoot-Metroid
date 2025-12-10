package edu.mateo.back.Metroid.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mateo.back.Metroid.model.entities.PowerSuit;
import edu.mateo.back.Metroid.repository.PowerSuitRepository;
import edu.mateo.back.Metroid.service.interfaces.IPowerSuitService;

@Service
public class PowerSuitService implements IPowerSuitService {

    @Autowired
    private PowerSuitRepository suitRepo;

    @Override
    public List<PowerSuit> getSuits() {
        return suitRepo.findAll();
    }

    @Override
    public PowerSuit getSuitById(Long id) {
        Optional<PowerSuit> op = suitRepo.findById(id);

        if (op.isPresent()) {
            return op.get();
        }

        return null;
    }

    @Override
    public PowerSuit updateSuit(PowerSuit powerSuit) {
        if (powerSuit.getPowerSuit_Id() == null) {
            System.out.println("Suit " + powerSuit.getName() + " added to the logbook.");
            return suitRepo.save(powerSuit);
        } else {
            if (suitRepo.existsById(powerSuit.getPowerSuit_Id())) {
                System.out.println("Suit " + powerSuit.getName() + " added to the logbook.");
                return suitRepo.save(powerSuit);
            } else {
                System.out.println("Suit " + powerSuit.getName() + " is not saved into the logbook.");
                return null;
            }
        }
    }

    @Override
    public void deleteSuit(Long id) {
        PowerSuit suitToDelete = suitRepo.findById(id).orElseThrow();
        suitRepo.deleteById(id);
        System.out.println("Suit " + suitToDelete.getName() + " deleted from the logbook.");
    }
}
