package com.reziz.studentregistration.profile.repository;

import com.reziz.studentregistration.profile.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Profile findProfileByUsername(String entryName);
}

