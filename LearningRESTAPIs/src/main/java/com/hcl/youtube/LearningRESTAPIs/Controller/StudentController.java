package com.hcl.youtube.LearningRESTAPIs.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.youtube.LearningRESTAPIs.DTO.AddStudentRequestDto;
import com.hcl.youtube.LearningRESTAPIs.DTO.StudentDTO;
import com.hcl.youtube.LearningRESTAPIs.Service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<StudentDTO>> getStudents() {
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(studentService.getAllStudents());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(studentService.getStudentById(id));
	}
	
	@PostMapping
	public ResponseEntity<StudentDTO> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
		
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(studentService.createNewStudent(addStudentRequestDto));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteStudentById(@PathVariable Long id){
		studentService.deleteStudentById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
		return ResponseEntity.ok(studentService.updateStudent(id,addStudentRequestDto));
	}
	
	@PatchMapping("{id}")
	public ResponseEntity<StudentDTO> updatePartialStudent(@PathVariable Long id, @RequestBody @Valid Map<String, Object> updates){
		return ResponseEntity.ok(studentService.updatePartialStudent(id, updates));
	}

}
