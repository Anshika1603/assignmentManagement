package com.knoldus.assignmentmanagementsystem.service;

import com.knoldus.assignmentmanagementsystem.model.KipKupPlan;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public interface AdminService {

    public String createPlan(KipKupPlan kipKupPlan);

    public String updateKipKupPlan(KipKupPlan kipKupPlan, Integer sessionId);

}
