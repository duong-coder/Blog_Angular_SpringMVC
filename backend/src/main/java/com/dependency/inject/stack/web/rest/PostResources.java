package com.dependency.inject.stack.web.rest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dependency.inject.stack.domain.Account;
import com.dependency.inject.stack.service.AccountService;
import com.dependency.inject.stack.service.PostService;
import com.dependency.inject.stack.service.dto.AccountDTO;
import com.dependency.inject.stack.service.dto.PostDTO;

@RestController
@RequestMapping(path = "/post")
public class PostResources {
	
	@Autowired
	private PostService postService;
	
	@GetMapping(path = "/{id}")
	public PostDTO getPostExist(@PathVariable("id") int id) {
		System.out.println("ID:" + id);
		PostDTO postDTO = postService.findById(id);
		
		return postDTO;
	}
	
	@PostMapping
	public ResponseEntity<PostDTO> insertNewPost(@RequestBody PostDTO postDTO) {
		Date date = new Date();
		System.out.println("TIme" + + date.getTime());
		try {
			postDTO.setDateCreate(date);
			postService.insert(postDTO);
			System.out.println("new post" + postDTO.getContent());
			
			return ResponseEntity.status(201).body(postDTO);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Loi them");
		}
		
		return null;
	}
	
	@PutMapping
	public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO) {
		try {
			postService.update(postDTO);
			System.out.println("PUT - UPDATE" + postDTO.toString());
			
			return ResponseEntity.status(201).body(postDTO);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Loi them");
		}
		
		return null;
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<PostDTO> deletePost(@PathVariable("id") int id) {
		try {
			PostDTO dto = postService.findById(id);
			postService.delete(id);
			System.out.println("DELETE - DELETE");
			
			return ResponseEntity.ok(dto);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Loi them");
		}
		
		return ResponseEntity.status(500).build();
	}
	
}
