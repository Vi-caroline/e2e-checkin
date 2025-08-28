package br.com.e2etreinamentos.checkin_e2e.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

//br/com/e2etreinamentos/checkin/CheckinModel.java
@Entity @Table(name = "checkins")
@Getter
@Setter
public class CheckinModel {

 public enum Status { PENDING, APPROVED, REJECTED }

 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(nullable = false, length = 160)
 private String studentEmail;

 @Column(nullable = false)
 private LocalDate lessonDate;

 @Enumerated(EnumType.STRING)
 @Column(nullable = false, length = 10)
 private Status status = Status.PENDING;

 @Column(nullable = false, updatable = false)
 private Instant createdAt = Instant.now();

 public CheckinModel() {}
 public CheckinModel(String email, LocalDate date) {
     this.studentEmail = email; this.lessonDate = date;
 }

 // getters/setters
 
 
}
