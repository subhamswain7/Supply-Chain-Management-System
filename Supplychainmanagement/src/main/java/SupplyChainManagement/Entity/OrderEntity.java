package SupplyChainManagement.Entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;

@Data
@Entity
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	private LocalDate orderDate;
	private Double totalAmount;
	private Boolean status;
	@Column(unique = true, nullable = false, updatable = false)
	private String trackingNumber;
	
	@PrePersist
	public void generateTrackingNumber() {
		  this.trackingNumber = "TRK-" + System.currentTimeMillis();
	}
}
