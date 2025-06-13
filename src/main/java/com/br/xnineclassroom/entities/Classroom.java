package com.br.xnineclassroom.entities;

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
@Table(name = "classroom")
@EntityListeners(AuditingEntityListener.class)
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer period;

    @Column(nullable = false)
    private String course;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant lastUpdated;

    @Column(nullable = false)
    private Integer classNumber;

    @Column(nullable = false)
    private Integer rowQuantity = 3;

    @Column(nullable = false)
    private Integer columnQuantity = 3;
}
