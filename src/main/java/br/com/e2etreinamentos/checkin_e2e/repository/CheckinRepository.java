package br.com.e2etreinamentos.checkin_e2e.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.e2etreinamentos.checkin_e2e.model.CheckinModel;

public interface CheckinRepository extends JpaRepository<CheckinModel, Long> {
    boolean existsByStudentEmailAndLessonDate(String studentEmail, LocalDate lessonDate);
    List<CheckinModel> findByStatusOrderByCreatedAtAsc(CheckinModel.Status status);
}
