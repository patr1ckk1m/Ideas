package com.patrick.belt1.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.patrick.belt1.models.Idea;
import com.patrick.belt1.models.User;
import com.patrick.belt1.repositories.IdeaRepo;
import com.patrick.belt1.repositories.UserRepo;

@Service
public class UserService {
	private UserRepo userRepo;
	private IdeaRepo ideaRepo;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
		
	public UserService(UserRepo userRepo, IdeaRepo ideaRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepo = userRepo;
		this.ideaRepo = ideaRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepo.save(user);
	}
	
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	public List<User> allUsers(){
		return (List<User>) userRepo.findAll();
	}
	
	public List<Idea> allIdeas(){
		return (List<Idea>) ideaRepo.findAll();
	}
	
	public void saveIdea(Idea idea) {
		ideaRepo.save(idea);
	}
	
	public User findOneUser(Long id) {
		return userRepo.findOne(id);
	}
	
	public Idea findOneIdea(Long id) {
		return ideaRepo.findOne(id);
	}
	
	public void deleteIdea(Long id) {
		ideaRepo.delete(id);
	}
	
	public void likeIdea(Long id, Long userid) {
		Idea idea = ideaRepo.findOne(id);
		User user = userRepo.findOne(userid);
		idea.getUsers().add(user);
		ideaRepo.save(idea);
	}
	
	public void makeIdea(Long id, Long ideaid) {
		User user = userRepo.findOne(id);
		Idea idea = ideaRepo.findOne(ideaid);
		user.getIdeas().add(idea);
		userRepo.save(user);
	}
}
