package com.verizon.sdmd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.sdmd.dao.ItemMongoRepository;

import com.verizon.sdmd.model.Item;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemMongoRepository itemDao;
	
	@Override
	public void addItem(Item item) {
	itemDao.insert(item);

	}

	@Override
	public void removeItem(int iCode) {
	itemDao.deleteById(iCode);
	}

	@Override
	public void updateItem(Item item) {
	itemDao.save(item);

	}

	@Override
	public Item getItem(int iCode) {
		Optional<Item> opt = itemDao.findById(iCode);
		return opt.isPresent()?opt.get():null;
	}

	@Override
	public List<Item> getItems() {
		
		return itemDao.findAll();
	}

	@Override
	public boolean exists(int icode) {
	
		return itemDao.existsById(icode);
	}

}


