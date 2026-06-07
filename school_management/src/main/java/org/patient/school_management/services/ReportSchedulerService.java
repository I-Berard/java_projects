package org.patient.school_management.services;

import jakarta.annotation.PostConstruct;
import org.patient.school_management.repository.CourseRepository;
import org.patient.school_management.repository.EnrollmentRepository;
import org.patient.school_management.repository.StudentRepository;
import org.patient.school_management.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ScheduledFuture;

@Service
public class ReportSchedulerService {

    private final TaskScheduler taskScheduler;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    private ScheduledFuture<?> scheduledFuture;
    
    // Default to running at 8 AM daily
    private String cronExpression = "0 0 8 * * ?";

    public ReportSchedulerService(@Qualifier("taskScheduler") TaskScheduler taskScheduler,
                                  StudentRepository studentRepository,
                                  TeacherRepository teacherRepository,
                                  CourseRepository courseRepository,
                                  EnrollmentRepository enrollmentRepository) {
        this.taskScheduler = taskScheduler;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    @PostConstruct
    public void init() {
        scheduleTask(cronExpression);
    }

    public synchronized void updateSchedule(String newCronExpression) {
        this.cronExpression = newCronExpression;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        scheduleTask(newCronExpression);
        System.out.println("System report schedule updated to: " + newCronExpression);
    }

    private void scheduleTask(String cron) {
        scheduledFuture = taskScheduler.schedule(this::generateReport, new CronTrigger(cron));
    }

    private void generateReport() {
        System.out.println("========== DAILY SYSTEM REPORT ==========");
        System.out.println("Generated at: " + LocalDateTime.now());
        System.out.println("Total Students: " + studentRepository.count());
        System.out.println("Total Teachers: " + teacherRepository.count());
        System.out.println("Total Courses: " + courseRepository.count());
        System.out.println("Total Enrollments: " + enrollmentRepository.count());
        System.out.println("=========================================");
    }
}
