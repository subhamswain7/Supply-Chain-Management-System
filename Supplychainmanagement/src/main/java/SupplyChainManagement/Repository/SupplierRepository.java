package SupplyChainManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import SupplyChainManagement.Entity.SuppliersEntity;

@Repository
public interface SupplierRepository extends JpaRepository<SuppliersEntity, Integer>{


}
