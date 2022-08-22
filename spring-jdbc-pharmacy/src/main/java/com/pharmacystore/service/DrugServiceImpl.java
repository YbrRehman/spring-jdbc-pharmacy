package com.pharmacystore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pharmacystore.dao.IDrugRepository;
import com.pharmacystore.exceptions.DrugIdNotFoundException;
import com.pharmacystore.exceptions.DrugNotFoundException;
import com.pharmacystore.model.Drugs;
@Service
public class DrugServiceImpl implements IDrugService {
	
	IDrugRepository istorage;
	@Autowired
	public void setIstorage(IDrugRepository istorage) {
		this.istorage = istorage;
	}

	@Override
	public List<Drugs> getall() {
		
		return istorage.findall().stream().sorted((p1,p2)->p1.getName().compareTo(p2.getName())).collect(Collectors.toList());
	}

	@Override
	public List<Drugs> getByCategory(String category)  {
		List<Drugs> drugs=istorage.findall().stream().sorted((p1,p2)->p1.getName()
				.compareTo(p2.getName())).collect(Collectors.toList());
		
		return drugs;
	}

	@Override
	public Drugs getById(int drugID)  {
		Drugs drugById=istorage.findById(drugID);
		
		return drugById;
	}

	@Override
	public void addDrug(Drugs drug) {
		istorage.addDrug(drug);
		
	}

	@Override
	public void updateDrug(String type, int drugId) {
		istorage.updateDrug(type, drugId);
		
	}

	@Override
	public void deleteDrug(int drugId) {
		istorage.deleteDrug(drugId);
	}

}
