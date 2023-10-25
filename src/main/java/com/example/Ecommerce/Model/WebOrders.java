package com.example.Ecommerce.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.*;

@Entity
@Table(name="web_orders")
@Data
public class WebOrders {
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "id", nullable = false)
	  private Long id;
	  /** The user of the order. */
	  @ManyToOne(optional = false)
	  @JoinColumn(name = "user_id", nullable = false)
	  private LocalUser user;
	  /** The shipping address of the order. */
	  @ManyToOne(optional = false)
	  @JoinColumn(name = "address_id", nullable = false)
	  private Address address;
	  /** The quantities ordered. */
	  @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE, orphanRemoval = true)
	  private List<WebOrderQuantities> quantities = new ArrayList<>();
	
	

}
