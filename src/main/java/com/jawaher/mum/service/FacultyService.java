package com.jawaher.mum.service;


import java.util.List;
import java.util.Optional;

import com.jawaher.mum.domain.Course;
import com.jawaher.mum.domain.Faculty;

public interface FacultyService {
	
	public List<Faculty> findAll();
    public Optional<Faculty>  getById(Long id);
    public List<Course> getCourse();
    public void update(Faculty s);
    public void remove(Faculty s);
    public Faculty save(Faculty s);

}
