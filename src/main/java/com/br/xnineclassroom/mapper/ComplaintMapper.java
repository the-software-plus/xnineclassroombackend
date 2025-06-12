package com.br.xnineclassroom.mapper;

import com.br.xnineclassroom.dto.ComplaintResponseDTO;
import com.br.xnineclassroom.dto.StudentComplaintResponseDTO;
import com.br.xnineclassroom.entities.Complaint;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ComplaintMapper {
    public ComplaintResponseDTO toResponse(Complaint complaint) {
        if (complaint == null) return null;

        return new ComplaintResponseDTO(
                complaint.getTitle(),
                complaint.getContent(),
                complaint.getCreatedDate(),
                complaint.getLastUpdated(),
                complaint.getStatus(),
                complaint.getSeverity(),
                complaint.getStudent()
        );
    }

    public List<ComplaintResponseDTO> toResponseList(List<Complaint> complaintList) {
        if ( complaintList == null ) {
            return null;
        }

        List<ComplaintResponseDTO> list = new ArrayList<ComplaintResponseDTO>( complaintList.size() );
        for ( Complaint complaint : complaintList ) {
            list.add( toResponse( complaint ) );
        }

        return list;
    }

    public StudentComplaintResponseDTO toUserResponse(Complaint complaint) {
        if (complaint == null) return null;

        return new StudentComplaintResponseDTO(
                complaint.getTitle(),
                complaint.getContent(),
                complaint.getCreatedDate(),
                complaint.getLastUpdated(),
                complaint.getStatus(),
                complaint.getSeverity()
        );
    }

    public List<StudentComplaintResponseDTO> toUserResponseList(List<Complaint> complaintList) {
        if ( complaintList == null ) {
            return null;
        }

        List<StudentComplaintResponseDTO> list = new ArrayList<StudentComplaintResponseDTO>( complaintList.size() );
        for ( Complaint complaint : complaintList ) {
            list.add( toUserResponse( complaint ) );
        }

        return list;
    }
}
