package com.kafkaconsumer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	private Long id;
	
	@Column
	private String name;
	
	
	public Long getId() {
		return id;
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
	public User() {
		
	}

	public User(Long id, String name) {
		this.id = id;
		this.name = name;
	}


	@Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id= '").append(id).append('\'');
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
