package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Store;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.StoreService;

@CrossOrigin(value = "http://localhost:3000/")
@RestController
public class StoreController {

	@Autowired
	private StoreRepository repository;
	
	@Autowired
	private StoreService service;
	
	@GetMapping("/getStore")
	public List<Store> getStore() {
		return repository.findAll();
	}
	
	@GetMapping("/getStoreById/{id}")
	public Optional<Store> getStore(@PathVariable int id) {
		return repository.findById(id);
	}
	
	@PostMapping("/addStore")
	public Store saveStore(@RequestBody Store store) {
		store.setProductId(service.getSequenceNumber(Store.SEQUENCE_NAME));
		return repository.save(store);	
	}
	
	@DeleteMapping("/deleteStore/{id}")
	public String deleteStore(@PathVariable int id) {
		repository.deleteById(id);
		return "Data deleted with id : " +id;
	}
	
	@PutMapping("/updateStore/{id}")
	public Store updateDataById(@PathVariable int id, @RequestBody Store store) throws Exception {
		Store oldData = repository.findById(id).orElseThrow(() -> new Exception("Data doesn't exist"));
		oldData.setProductName(store.getProductName());
		oldData.setAvailablePkgs(store.getAvailablePkgs());
		oldData.setManufactoringDate(store.getManufactoringDate());
		oldData.setPrice(store.getPrice());
		oldData.setProductType(store.getProductType());
		oldData.setQuantity(store.getQuantity());
		oldData.setValidityPeriod(store.getValidityPeriod());
		return repository.save(oldData);
		
	}
	
}
