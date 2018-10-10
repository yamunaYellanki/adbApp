package com.verizon.sjdbc.dao;

import java.util.List;

import com.verizon.sjdbc.model.Item;

public interface ItemDAO {
	public void addItem(Item item);
	
	public void removeItem(int iCode);
	
	public void updateItem(Item item);
	
	public Item getItem(int iCode);
	public List<Item> getItems();
	
	
	

}
