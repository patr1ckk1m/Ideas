package com.patrick.belt1.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;



@Entity
@Table(name="users")
public class User {
	
    @Id
    @GeneratedValue
    private Long id;
    @Size(min=1, message="Name must be at least 1 character")
    private String name;
    @Size(min=1, message="Alias must be at least 1 character")
    private String alias;
    private String email;
    @Size(min=9, message = "Pass must be greater than 9")
    private String password;
    @Transient
    private String passwordConfirmation;
    private Date createdAt;
    private Date updatedAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_ideas", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "idea_id"))
    private List<Idea> ideas;
    
    
    @OneToMany(mappedBy="poster", fetch = FetchType.LAZY)
    private List<Idea> postedIdeas;
    
    public List<Idea> getIdeas() {
        return ideas;
    }

    public void setIdea(List<Idea> ideas) {
        this.ideas = ideas;
    }
    
	public List<Idea> getPostedIdeas() {
		return postedIdeas;
	}

	public void setPostedIdeas(List<Idea> postedIdeas) {
		this.postedIdeas = postedIdeas;
	}
    
    public User() {
    }

    public Long getId() {
        return id;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

   
    
    @PrePersist
    protected void onCreate(){
    this.setCreatedAt(new Date());
    }

    @PreUpdate
    protected void onUpdate(){
    this.setUpdatedAt(new Date());
    }
}
