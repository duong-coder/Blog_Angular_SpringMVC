package com.dependency.inject.stack.web.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.dependency.inject.stack.service.PostService;
import com.dependency.inject.stack.service.dto.PostDTO;
import com.dependency.inject.stack.web.response.Response;

@RestController
@RequestMapping(path = "/api/post")
public class PostResources {

	@Autowired
	private PostService postService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response> getPostExist(@PathVariable("id") int id) {
		Response response = null;
		try {
			PostDTO postDTO = postService.findById(id);
			if(postDTO != null) {
				response = new Response("Get post success", 200, postDTO);
			}else {
				response = new Response("No post was found", 200, postDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response("System error", 500, null);
		}

		return ResponseEntity.ok(response);
	}

	@GetMapping(path = "/all/{username}")
	public ResponseEntity<Response> getAllPostByAccount(@PathVariable("username") String username) {
		List<PostDTO> postDTOs = new ArrayList<PostDTO>();
		Response response = null;
		try {
			postDTOs = postService.findAllByAccountId(username);
			if (postDTOs != null && !postDTOs.isEmpty()) {
				response = new Response("Get all post success", 200, postDTOs);
			}else {
				response = new Response("No posts were found", 200, postDTOs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new Response("System error", 500, postDTOs);
		}
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<Response> insertNewPost(@RequestBody PostDTO postDTO) {
		Date date = new Date();
		System.out.println("Time" + date.getTime());
		try {
			postDTO.setDateCreate(date);
			postService.insert(postDTO);
			System.out.println("new post" + postDTO.getContent());
			Response response = new Response("Create", 201, postDTO);

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Loi them");
		}

		return ResponseEntity.ok(new Response("Can not insert post", 500, postDTO));
	}

	@PutMapping
	public ResponseEntity<Response> updatePost(@RequestBody PostDTO postDTO) {
		try {
			postService.update(postDTO);
			System.out.println("PUT - UPDATE" + postDTO.toString());
			Response response = new Response("Update", 201, postDTO);

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Loi them");
		}

		return ResponseEntity.ok(new Response("Can not update post", 500, postDTO));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response> deletePost(@PathVariable("id") int id) {
		try {
			PostDTO dto = postService.findById(id);
			postService.delete(id);
			System.out.println("DELETE - DELETE");
			Response response = new Response("Delete", 201, dto);

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Loi them");
		}

		return ResponseEntity.ok(new Response("Post not found", 500, null));
	}

}
