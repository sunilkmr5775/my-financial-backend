package com.exam.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.BankMaster;
import com.exam.model.Category;
import com.exam.model.Emi;
import com.exam.service.BankMasterService;

@RestController
@Component
@RequestMapping("/bank")
@CrossOrigin("*")
public class BankMasterController {

	@Autowired
	private BankMasterService bankMasterService;


//	 GET ALL CATEGORIES
	@GetMapping("/")
	public Set<BankMaster> getCategories() {
		return new HashSet<>(this.bankMasterService.getAllBanks());

	}

//	 GET SINGLE Bank BY ID
	@GetMapping("/{bankId}")
	public BankMaster getBankById(@PathVariable("bankId") Long bankId) {
		return this.bankMasterService.getBank(bankId);

	}

//	 DELETE CATEGORY BY ID
	@DeleteMapping("/{bankId}")
	public void deleteBank(@PathVariable Long bankId) {
		this.bankMasterService.deleteBank(bankId);

	}
	
	@GetMapping("/{direction}")
//	public List<Category> getByDescription(@PathVariable String direction){
	public String getByDescription(@PathVariable String direction){
		System.out.println("Inside getByDescription in Question controller");
		List<Category> list = new ArrayList<>();
		list.add(new Category("Sample Category", "This is a sample category", LocalDateTime.now(), "sunilkmr5775"));
		return "direction";
		//return this.categoryService.findAllByDescription(direction);
	}

}
