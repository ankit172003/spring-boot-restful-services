package com.hcl.youtube.LearningRESTAPIs.Service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.youtube.LearningRESTAPIs.DTO.AddStudentRequestDto;
import com.hcl.youtube.LearningRESTAPIs.DTO.StudentDTO;
import com.hcl.youtube.LearningRESTAPIs.Entity.Student;
import com.hcl.youtube.LearningRESTAPIs.Repository.StudentRepository;
import com.hcl.youtube.LearningRESTAPIs.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<StudentDTO> getAllStudents() {
		List<Student> students = studentRepo.findAll(); // this gets student not studentDTO 
		List<StudentDTO> studentDtoList = students
				.stream()
				.map(student -> new StudentDTO(student.getId(),student.getName(),student.getEmail()))
				.toList();
		return studentDtoList;
	}



	// Simple way to convert Student -> StudentDto
//	@Override
//	public StudentDTO getStudentById(Long id) {
//		Optional<Student> student = studentRepo.findById(id);
//		if(student.isPresent()) {
//			Student s = student.get();
//			StudentDTO studentD = new StudentDTO(s.getId(), s.getName(),s.getEmail());
//			return studentD;
//		}
//		
//		throw new IllegalArgumentException("No Student for this id");
//	}
	
	@Override
	public StudentDTO getStudentById(Long id) {
		Optional<Student> student = studentRepo.findById(id);
		if(student.isEmpty()) {
			throw new IllegalArgumentException("No Student with this id");
		}
		return modelMapper.map(student, StudentDTO.class);
	}



	@Override
	public StudentDTO createNewStudent(AddStudentRequestDto addStudentRequestDto) {
		Student newStudent = modelMapper.map(addStudentRequestDto,Student.class);
		Student student = studentRepo.save(newStudent);
		return modelMapper.map(student, StudentDTO.class);
	}

	@Override
	public void deleteStudentById(Long id) {
		Optional<Student> student = studentRepo.findById(id);
		if(student.isEmpty()) {
			throw new IllegalArgumentException("No Student exist with this id");
		}
		studentRepo.deleteById(id);
	}



	@Override
	public StudentDTO updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
		Student student = studentRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No such student"));
		modelMapper.map(addStudentRequestDto, student);
		
		student = studentRepo.save(student);
		return modelMapper.map(student, StudentDTO.class);
	}



	@Override
	public StudentDTO updatePartialStudent(Long id, Map<String, Object> updates) {
		Student student = studentRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No such studnet"));
		
		updates.forEach((field,value) -> {
			switch (field) {
			case "name" :
				student.setName((String) value);
				break;
			case "email":
				student.setEmail((String) value);
				break;
			default: 
				throw new IllegalArgumentException("Feild is not supported");
			}
		});
		
		Student saveStudent = studentRepo.save(student);
		return modelMapper.map(saveStudent, StudentDTO.class);
	}
	
	

}
