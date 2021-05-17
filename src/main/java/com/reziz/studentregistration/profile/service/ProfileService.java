package com.reziz.studentregistration.profile.service;

import com.reziz.studentregistration.profile.domain.Profile;
import com.reziz.studentregistration.profile.domain.ProfileDTO;
import com.reziz.studentregistration.profile.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
@AllArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    public Profile save(@Valid ProfileDTO p) {
        var profile = new Profile(p.getUsername(), p.getSpecializationArea(), p.getBlockToTeach(),
                p.getBlockIntervalStart(), p.getBlockIntervalEnd(), p.getDescription());
        return profileRepository.save(profile);
    }

    public Profile findById(Long id) {
        return profileRepository.findById(id).orElseGet(Profile::new);
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Profile findByUsername(String username) {
        return profileRepository.findProfileByUsername(username);
    }
}
