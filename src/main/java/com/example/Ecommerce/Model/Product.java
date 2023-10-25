package com.example.Ecommerce.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="product")
@Data
public class Product {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "id", nullable = false)
	  private Long id;
	  /** The name of the product. */
	  @Column(name = "name", nullable = false, unique = true)
	  private String name;
	  /** The short description of the product. */
	  @Column(name = "short_description", nullable = false)
	  private String shortDescription;
	  /** The long description of the product. */
	  @Column(name = "long_description")
	  private String longDescription;
	  /** The price of the product. */
	  @Column(name = "price", nullable = false)
	  private Double price;
	  /** The inventory of the product. */
	  @OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE, optional = false, orphanRemoval = true)
	  private Inventory inventory;

}
