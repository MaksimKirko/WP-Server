package com.github.maximkirko.wpserver.datamodel;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "stock", uniqueConstraints = { @UniqueConstraint(columnNames = "name"),
		@UniqueConstraint(columnNames = "code") })
public class Stock implements java.io.Serializable {

	private Integer id;
	private String code;
	private String name;
	private Set<Category> categories = new HashSet<Category>(0);

	public Stock() {
	}

	public Stock(String stockCode, String stockName) {
		this.code = stockCode;
		this.name = stockName;
	}

	public Stock(String stockCode, String stockName, Set<Category> categories) {
		this.code = stockCode;
		this.name = stockName;
		this.categories = categories;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getStockId() {
		return this.id;
	}

	public void setStockId(Integer id) {
		this.id = id;
	}

	@Column(name = "code", unique = true, nullable = false, length = 10)
	public String getStockCode() {
		return this.code;
	}

	public void setStockCode(String code) {
		this.code = code;
	}

	@Column(name = "name", unique = true, nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "stock_2_category", joinColumns = {
			@JoinColumn(name = "stock_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "category_id", nullable = false, updatable = false) })
	public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

}