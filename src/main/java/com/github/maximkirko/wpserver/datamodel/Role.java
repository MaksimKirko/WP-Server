package com.github.maximkirko.wpserver.datamodel;

import javax.persistence.*;

@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="type", length=15, unique=true, nullable=false)
	private RoleEnum type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleEnum getType() {
		return type;
	}

	public void setType(RoleEnum type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ",  type=" + type	+ "]";
	}
	

}
