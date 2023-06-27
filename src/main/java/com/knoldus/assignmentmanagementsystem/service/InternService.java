package com.knoldus.assignmentmanagementsystem.service;

import com.knoldus.assignmentmanagementsystem.model.Intern;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface InternService {
    public List<Intern> getAll();

    public Intern addIntern(Intern intern);

    public String updateIntern(Intern intern, Integer internId);

    public String deleteIntern(Integer integerId);

    public Optional<Intern> getDetails(Integer internId);
}
