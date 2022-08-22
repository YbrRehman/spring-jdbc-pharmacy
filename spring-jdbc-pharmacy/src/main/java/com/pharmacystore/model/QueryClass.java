package com.pharmacystore.model;

public class QueryClass {
	public static final String INSERTQUERY="insert into drugs(name,category,drug_id,type) values(?,?,?,?)";
	public static final String UPDATEQUERY="update drugs set category=? where drug_id=?";
	public static final String DELETEQuery="delete from drugs where drug_id=?";
	public static final String SELECTQUERY="select * from drugs";
	public static final String SELECTBYTYPE="select * from drugs where type=?";
	public static final String SELECTBYCATEGORY="select *from drugs where category=?";
	public static final String SELECTBYID="select * from drugs where drug_id=?";
	
	
}
