package com.br.xnineclassroom.entities;

import com.br.xnineclassroom.entities.user.Student;
import com.br.xnineclassroom.enums.ComplaintSeverity;
import com.br.xnineclassroom.enums.ComplaintStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "complaint")
@EntityListeners(AuditingEntityListener.class)
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    public Instant createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    public Instant lastUpdated;

    @Column(nullable = false)
    public String title;

    @Column(nullable = false)
    public String content;

    @Enumerated(EnumType.STRING)
    public ComplaintStatus status = ComplaintStatus.OPEN;

    @Enumerated(EnumType.STRING)
    public ComplaintSeverity severity = ComplaintSeverity.MEDIUM;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    public Student student;
}
