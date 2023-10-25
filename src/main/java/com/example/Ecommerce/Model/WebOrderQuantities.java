package com.example.Ecommerce.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="web_order_quantities")
@Data
public class WebOrderQuantities {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "id", nullable = false)
	  private Long id;
	  /** The product being ordered. */
	  @ManyToOne(optional = false)
	  @JoinColumn(name = "product_id", nullable = false)
	  private Product product;
	  /** The quantity being ordered. */
	  @Column(name = "quantity", nullable = false)
	  private Integer quantity;
	  /** The order itself. */
	  @ManyToOne(optional = false)
	  @JoinColumn(name = "order_id", nullable = false)
	  private WebOrders order;

}
