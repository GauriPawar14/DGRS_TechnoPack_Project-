package com.example.corrugatedbox.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="inventory_data")
public class Inventory {
	
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int ma_id;
        @Column(name="ma_name",nullable=false)
		private String ma_name;
        @Column(name="ma_description",nullable=false)
		private String ma_description;
        @Column(name="ma_quantity",nullable=false)
		private double ma_quantity;
        @Column(name="ma_price",nullable=false)
		private double ma_price;
		
		public Inventory(int ma_id, String ma_name, String ma_description, double ma_quantity, double ma_price) {
			super();
			this.ma_id = ma_id;
			this.ma_name = ma_name;
			this.ma_description = ma_description;
			this.ma_quantity = ma_quantity;
			this.ma_price = ma_price;
		}

		public int getMa_id() {
			return ma_id;
		}

		public void setMa_id(int ma_id) {
			this.ma_id = ma_id;
		}

		public String getMa_name() {
			return ma_name;
		}

		public void setMa_name(String ma_name) {
			this.ma_name = ma_name;
		}

		public String getMa_description() {
			return ma_description;
		}

		public void setMa_description(String ma_description) {
			this.ma_description = ma_description;
		}

		public double getMa_quantity() {
			return ma_quantity;
		}

		public void setMa_quantity(double ma_quantity) {
			this.ma_quantity = ma_quantity;
		}

		public double getMa_price() {
			return ma_price;
		}

		public void setMa_price(double ma_price) {
			this.ma_price = ma_price;
		}

		@Override
		public String toString() {
			return "Inventory [ma_id=" + ma_id + ", ma_name=" + ma_name + ", ma_description=" + ma_description
					+ ", ma_quantity=" + ma_quantity + ", ma_price=" + ma_price + "]";
		}
		
		
		
		

}
