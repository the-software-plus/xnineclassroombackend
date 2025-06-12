package com.br.xnineclassroom.enums;

public enum ComplaintSeverity {
    LOW("LOW"),
    MEDIUM("MEDIUM"),
    HIGH("HIGH"),
    CRITICAL("CRITICAL");

    private final String severity;

    ComplaintSeverity(String severity) {
        this.severity = severity;
    }
}
