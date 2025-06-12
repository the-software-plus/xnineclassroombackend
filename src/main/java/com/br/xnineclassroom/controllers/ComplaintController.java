package com.br.xnineclassroom.controllers;

import com.br.xnineclassroom.dto.ComplaintResponseDTO;
import com.br.xnineclassroom.dto.CreateComplaintRequest;
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
@RequestMapping("/complaints")
public class ComplaintController {

    public final ComplaintRepository complaintRepository;
    public final StudentRepository studentRepository;
    public final ComplaintMapper complaintMapper;

    ComplaintController(ComplaintRepository complaintRepository, StudentRepository studentRepository, ComplaintMapper complaintMapper) {
        this.complaintRepository = complaintRepository;
        this.studentRepository = studentRepository;
        this.complaintMapper = complaintMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody CreateComplaintRequest requestBody) {
        Optional<Student> student = studentRepository.findByEmail(requestBody.email());

        if (student.isEmpty()) throw new RuntimeException("Student not found.");

        Complaint complaint = new Complaint();

        complaint.setTitle(requestBody.title());
        complaint.setContent(requestBody.content());
        complaint.setStudent(student.get());

        Complaint newComplaint = complaintRepository.save(complaint);

        if (newComplaint.getId() == null) throw new RuntimeException("Error creating the new complaint");

        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<ComplaintResponseDTO>> listComplaints() {
        List<Complaint> complaintsList = complaintRepository.findAll();

        return ResponseEntity.ok().body(complaintMapper.toResponseList(complaintsList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComplaintResponseDTO> fetchComplaintById(@PathVariable Long id) {
        Optional<Complaint> complaint = complaintRepository.findById(id);

        if (complaint.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(complaintMapper.toResponse(complaint.get()));
    }
}
