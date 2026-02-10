package SupplyChainManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SupplyChainManagement.Dto.ResponseStructure;
import SupplyChainManagement.Entity.SuppliersEntity;
import SupplyChainManagement.Service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	
	@PostMapping("/savesupplier")
	public ResponseEntity<ResponseStructure<SuppliersEntity>> saveSupplier(@RequestBody SuppliersEntity supplier){
		return supplierService.saveSupplier(supplier);
	}
	
	@GetMapping("/getallsupplier")
	public ResponseEntity<ResponseStructure<List<SuppliersEntity>>> getAllSupplier(){
		return supplierService.getAllSupplier();
	}
	
	@GetMapping("/getByid/{id}")
	public ResponseEntity<ResponseStructure<SuppliersEntity>> findById(@PathVariable Integer id){
		return supplierService.getSupplierById(id);
	}
	
	@PatchMapping("/updatesupplier/{id}")
	public ResponseEntity<ResponseStructure<SuppliersEntity>> updateSupplier(@PathVariable Integer id,@RequestBody SuppliersEntity supplier){
		return supplierService.patchSupplier(id, supplier);
	}
	
	@DeleteMapping("/deletesupplier/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteSupplier(@PathVariable Integer id){
		return supplierService.deleteSupplier(id);
	}
}