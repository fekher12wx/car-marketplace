package com.example.freelance.services;

import com.example.freelance.entities.LienProfessionnel;
import com.example.freelance.repository.LienProfessionnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LienProfessionnelService {

    @Autowired
    private LienProfessionnelRepository lienRepository;

    public List<LienProfessionnel> getAllLiens() {
        return lienRepository.findAll();
    }

    public Optional<LienProfessionnel> getLienById(Long id) {
        return lienRepository.findById(id);
    }

    public List<LienProfessionnel> getLiensByFreelance(Long freelanceId) {
        return lienRepository.findByFreelanceId(freelanceId);
    }

    public LienProfessionnel createLien(LienProfessionnel lien) {
        return lienRepository.save(lien);
    }

    public LienProfessionnel updateLien(LienProfessionnel lien) {
        return lienRepository.save(lien);
    }

    public void deleteLien(Long id) {
        lienRepository.deleteById(id);
    }
}
