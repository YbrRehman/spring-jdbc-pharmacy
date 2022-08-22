package com.pharmacystore.service;

import java.util.List;



import com.pharmacystore.model.Drugs;
public interface IDrugService {
	void addDrug(Drugs drug);
	void updateDrug(String type, int drugId);
	void deleteDrug(int drugId);
	public List<Drugs> getall();
	public List<Drugs> getByCategory(String category);
	public Drugs getById(int drugID);
}
