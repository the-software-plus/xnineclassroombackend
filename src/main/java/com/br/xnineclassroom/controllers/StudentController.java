package com.br.xnineclassroom.controllers;

import com.br.xnineclassroom.dto.CreateStudentRequestDTO;
import com.br.xnineclassroom.dto.StudentComplaintResponseDTO;
import com.br.xnineclassroom.entities.Complaint;
import com.br.xnineclassroom.entities.user.Student;
import com.br.xnineclassroom.mapper.ComplaintMapper;
import com.br.xnineclassroom.repository.ComplaintRepository;
import com.br.xnineclassroom.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    public final StudentRepository studentRepository;
    public final ComplaintRepository complaintRepository;
    public final ComplaintMapper complaintMapper;

    StudentController(StudentRepository studentRepository, ComplaintRepository complaintRepository, ComplaintMapper complaintMapper) {
        this.studentRepository = studentRepository;
        this.complaintRepository = complaintRepository;
        this.complaintMapper = complaintMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody CreateStudentRequestDTO requestBody) {
        Optional<Student> student = studentRepository.findByEmail(requestBody.email());

        if (student.isPresent()) throw new RuntimeException("Student already exists.");

        Student newStudent = new Student();
        newStudent.setEmail(requestBody.email());

        studentRepository.save(newStudent);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/complaints")
    public ResponseEntity<List<StudentComplaintResponseDTO>> list(@PathVariable Long id) {
        List<Complaint> complaintList = complaintRepository.findAllByStudentId(id);

        return ResponseEntity.ok().body(complaintMapper.toUserResponseList(complaintList));
    }
}
