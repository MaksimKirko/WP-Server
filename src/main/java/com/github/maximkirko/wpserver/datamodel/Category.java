package com.github.maximkirko.wpserver.datamodel;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category implements java.io.Serializable {

	private Integer id;
	private String name;
	private String description;
	private Set<Stock> stocks = new HashSet<Stock>(0);

	public Category() {
	}

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Category(String name, String description, Set<Stock> stocks) {
		this.name = name;
		this.description = description;
		this.stocks = stocks;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getCategoryId() {
		return this.id;
	}

	public void setCategoryId(Integer categoryId) {
		this.id = categoryId;
	}

	@Column(name = "name", nullable = false, length = 10)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description", nullable = false)
	public String getDesc() {
		return this.description;
	}

	public void setDesc(String desc) {
		this.description = desc;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	public Set<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}

}