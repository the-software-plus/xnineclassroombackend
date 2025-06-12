package com.br.xnineclassroom.dto;

import com.br.xnineclassroom.entities.user.Student;
import com.br.xnineclassroom.enums.ComplaintSeverity;
import com.br.xnineclassroom.enums.ComplaintStatus;

import java.time.Instant;

public record StudentComplaintResponseDTO(
        String title,
        String content,
        Instant createdDate,
        Instant lastUpdated,
        ComplaintStatus status,
        ComplaintSeverity severity
) {
}
