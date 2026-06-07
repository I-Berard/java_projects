package org.patient.school_management.controller;

import org.patient.school_management.services.ReportSchedulerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/system")
public class SystemController {

    private final ReportSchedulerService reportSchedulerService;

    public SystemController(ReportSchedulerService reportSchedulerService) {
        this.reportSchedulerService = reportSchedulerService;
    }

    @PostMapping("/report-schedule")
    public ResponseEntity<String> updateReportSchedule(@RequestParam String cronExpression) {
        try {
            reportSchedulerService.updateSchedule(cronExpression);
            return ResponseEntity.ok("Successfully updated report schedule to: " + cronExpression);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid cron expression: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error updating schedule: " + e.getMessage());
        }
    }
}
