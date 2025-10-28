package com.example.corrugatedbox.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="size")
public class Size {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int s_id;
	
	
	@Column(name="Depth",nullable=false)
	private  Double depth;
	
	@Column(name="Width",nullable=false)
	private Double width;
	
	@Column(name="Height",nullable=false)
	private Double height;
	
	public Size(int s_id, Double depth, Double width, Double height) {
		super();
		this.s_id = s_id;
		this.depth = depth;
		this.width = width;
		this.height = height;
	}

	public int gets_id() {
		return s_id;
	}

	public void sets_id(int s_id) {
		this.s_id = s_id;
	}

	public Double getDepth() {
		return depth;
	}

	public void setDepth(Double depth) {
		this.depth = depth;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Size [s_id=" + s_id + ", depth=" + depth + ", width=" + width + ", height=" + height + "]";
	}
	
	
	
	
	
	
}
