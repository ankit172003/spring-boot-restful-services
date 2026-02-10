package com.hcl.youtube.LearningRESTAPIs.Service;

import java.util.List;
import java.util.Map;


import com.hcl.youtube.LearningRESTAPIs.DTO.AddStudentRequestDto;
import com.hcl.youtube.LearningRESTAPIs.DTO.StudentDTO;

public interface StudentService {
	
	List<StudentDTO> getAllStudents();
	
	StudentDTO getStudentById(Long id);

	StudentDTO createNewStudent(AddStudentRequestDto addStudentRequestDto);

	void deleteStudentById(Long id);

	StudentDTO updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

	StudentDTO updatePartialStudent(Long id, Map<String, Object> updates);

}
