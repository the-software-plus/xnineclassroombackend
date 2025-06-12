package com.br.xnineclassroom.dto;

import com.br.xnineclassroom.entities.user.Student;

public record CreateComplaintRequest(String title, String content, String email) {
}
