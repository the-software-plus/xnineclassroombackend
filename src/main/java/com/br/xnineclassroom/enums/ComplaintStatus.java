package com.br.xnineclassroom.enums;

import lombok.Getter;

@Getter
public enum ComplaintStatus {

    OPEN("OPEN"),
    VIEWED("VIEWED"),
    FINALIZED("FINALIZED"),
    CLOSED("CLOSED");

    public final String value;

    ComplaintStatus(String value) {
        this.value = value;
    }
}
