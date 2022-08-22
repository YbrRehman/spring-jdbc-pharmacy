package com.pharmacystore.dao;

import java.util.List;

import com.pharmacystore.exceptions.DrugIdNotFoundException;
import com.pharmacystore.exceptions.DrugNotFoundException;
import com.pharmacystore.model.Drugs;

public interface IDrugRepository {
	void addDrug(Drugs drug);
	void updateDrug(String type, int drugId);
	void deleteDrug(int drugId);
	public List<Drugs> findall();
	public List<Drugs> findByCategory(String category);
	public Drugs findById(int drugID);

}
