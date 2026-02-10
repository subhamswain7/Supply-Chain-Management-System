package SupplyChainManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import SupplyChainManagement.Dto.ResponseStructure;
import SupplyChainManagement.Entity.SuppliersEntity;
import SupplyChainManagement.Exception.idNotFoundException;
import SupplyChainManagement.Repository.SupplierRepository;

@Service
public class SupplierService {
	
	//@Autowired
//	public SupplierDao supplierDao;
	@Autowired
	private SupplierRepository supplyRepository;
	
	//save Supplier
//	 public SuppliersEntity saveSupplier(SuppliersEntity supplier) {
//	        return supplierRepository.save(supplier);
//	    }
	public ResponseEntity<ResponseStructure<SuppliersEntity>> saveSupplier(SuppliersEntity supplier){
		ResponseStructure<SuppliersEntity> response=new ResponseStructure<>();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("record saved successfully");
		response.setData(supplyRepository.save(supplier));
		return new ResponseEntity<ResponseStructure<SuppliersEntity>>(response, HttpStatus.CREATED);
	}
	
	//get all supplier
//	 public List<SuppliersEntity> getAllSuppliers() {
//	        return supplierRepository.findAll();
//	    }
	public ResponseEntity<ResponseStructure<List<SuppliersEntity>>> getAllSupplier(){
		List<SuppliersEntity> opt= supplyRepository.findAll();
		if(!opt.isEmpty()) {
			ResponseStructure<List<SuppliersEntity>> response = new ResponseStructure<>();
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("all record fetched successfully");
			response.setData(opt);
			return new ResponseEntity<> (response, HttpStatus.OK);
		}
		else {
			return null;
		}
	}
	
	//get supplier by id
	public ResponseEntity<ResponseStructure<SuppliersEntity>> getSupplierById(Integer id){
		Optional<SuppliersEntity> opt= supplyRepository.findById(id);
		if(!opt.isEmpty()) {
			ResponseStructure<SuppliersEntity> response= new ResponseStructure<>();
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("Id fetched Successfully");
			response.setData(opt.get());
			return new ResponseEntity<>(response, HttpStatus.OK);
		}else {
			throw new idNotFoundException("id not found");
		}
	}	
		
	//update supplier
		public ResponseEntity<ResponseStructure<SuppliersEntity>> patchSupplier(Integer id ,SuppliersEntity supplier){
			Optional<SuppliersEntity> opt = supplyRepository.findById(id);
			if(opt.isEmpty()) {
				throw new idNotFoundException("enter a valid id");
			}
			
			SuppliersEntity exist= opt.get();
			
			if(supplier.getName()!=null) {
				exist.setName(supplier.getName());
			}
			if(supplier.getContact()!=null) {
				exist.setContact(supplier.getContact());
			}
			if(supplier.getEmail()!=null) {
				exist.setEmail(supplier.getEmail());
			}
			if(supplier.getCompanyName()!=null) {
				exist.setCompanyName(supplier.getCompanyName());
			}
			
			SuppliersEntity updated= supplyRepository.save(exist);
			
			ResponseStructure<SuppliersEntity> response= new ResponseStructure<>();
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("supplier details updated successfully");
			response.setData(updated);
			 return new ResponseEntity<>(response, HttpStatus.OK); 
		}
		
		
		//delete supplier
		public ResponseEntity<ResponseStructure<String>> deleteSupplier(Integer id){
			Optional<SuppliersEntity> opt = supplyRepository.findById(id);
			if(opt.isEmpty()) {
				throw new idNotFoundException("enter the valid id for delete"); 
			}
			else {
				supplyRepository.deleteById(id);
				ResponseStructure<String> response = new ResponseStructure<>();
				response.setStatusCode(HttpStatus.OK.value());
				response.setMessage("Supplier details deleted successfully");
				 response.setData("Supplier id " + id + " deleted");
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		
			
			
		}
	
}





