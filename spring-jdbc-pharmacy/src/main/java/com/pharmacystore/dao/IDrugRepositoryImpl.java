package com.pharmacystore.dao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pharmacystore.exceptions.DrugIdNotFoundException;
import com.pharmacystore.exceptions.DrugNotFoundException;
import com.pharmacystore.model.Drugs;
import com.pharmacystore.model.QueryClass;
@Repository
public class IDrugRepositoryImpl implements IDrugRepository{
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public List<Drugs> findall() {
		
		return jdbcTemplate.query(QueryClass.SELECTQUERY, new DrugRowMapper());
	}
	@Override
	public List<Drugs> findByCategory(String category)  {
		
		return jdbcTemplate.query(QueryClass.SELECTBYCATEGORY,new DrugRowMapper(),category );
	}

	@Override
	public Drugs findById(int drugID)  {
		return jdbcTemplate.query(QueryClass.SELECTBYID, new DrugRowMapper(),drugID).stream().findFirst().get();
		
	}
		public void addDrug(Drugs drug) {
			Object[] array= { drug.getName(),drug.getCategory(),drug.getDrugId(),drug.getType()};
			jdbcTemplate.update(QueryClass.INSERTQUERY,array);
			
		}
		@Override
		public void updateDrug(String type, int drugId) {
			jdbcTemplate.update(QueryClass.UPDATEQUERY, type,drugId);
			
		}
		@Override
		public void deleteDrug(int drugId) {
			jdbcTemplate.update(QueryClass.DELETEQuery,drugId);
			
		}
}
