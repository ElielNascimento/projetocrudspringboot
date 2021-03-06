package br.com.bnback.food.order;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.bnback.food.product.Product;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String addres;
	private Double latitude;
	private Double longitude;
	private Instant moment;
	private OrderStatus orderStatus;

	@ManyToMany
	@JoinTable(name = "tb_order_product", joinColumns = @JoinColumn(name = "order_id"), 
	 inverseJoinColumns = @JoinColumn (name = "product_id"))
	private Set<Product> products = new HashSet<>();

	public Order() {
	}

	public Order(Long id, String addres, Double latitude, Double longitude, Instant moment, OrderStatus orderStatus,
			Set<Product> products) {
		super();
		this.id = id;
		this.addres = addres;
		this.latitude = latitude;
		this.longitude = longitude;
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Set<Product> getProducts() {
		return products;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

}
