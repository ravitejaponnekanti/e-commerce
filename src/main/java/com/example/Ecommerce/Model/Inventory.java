package com.example.Ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="inventory")
@Data
public class Inventory {
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "id", nullable = false)
	 @JsonIgnore
	  private Long id;
	  /** The product this inventory is of. */
	  @OneToOne(optional = false, orphanRemoval = true)
	  @JoinColumn(name = "product_id", nullable = false, unique = true)
	  @JsonIgnore
	  private Product product;
	  /** The quantity in stock. */
	  @Column(name = "quantity", nullable = false)
	  private Integer quantity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
