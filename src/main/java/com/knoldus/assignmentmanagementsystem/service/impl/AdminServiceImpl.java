package com.knoldus.assignmentmanagementsystem.service.impl;

import com.knoldus.assignmentmanagementsystem.exception.ResourceNotFoundException;
import com.knoldus.assignmentmanagementsystem.model.KipKupPlan;
import com.knoldus.assignmentmanagementsystem.repository.KipKupRepository;
import com.knoldus.assignmentmanagementsystem.service.AdminService;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalTime;


@Component
public class AdminServiceImpl implements AdminService {

    @Autowired
    private KipKupRepository kipKupRepository;

    @Override
    public String createPlan(KipKupPlan kipKupPlan) {
        kipKupRepository.save(kipKupPlan);
        return "Created Plan";
    }

    @Override
    public String updateKipKupPlan(KipKupPlan kipKupPlan, Integer sessionId) {
        KipKupPlan existingPlan=kipKupRepository.findById(sessionId).orElseThrow(() -> new ResourceNotFoundException("Plan not found with SessionID "+sessionId));
        existingPlan.setDate(kipKupPlan.getDate());
        existingPlan.setTopic(kipKupPlan.getTopic());
        existingPlan.setTime(kipKupPlan.getTime());
        existingPlan.setPlanType(kipKupPlan.getPlanType());
        existingPlan.setSessionId(kipKupPlan.getSessionId());
        existingPlan.setMentorName(kipKupPlan.getMentorName());
        return "Updated Plan";
    }

}
