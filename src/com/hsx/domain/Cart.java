package com.hsx.domain;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车
 * 
 * @author hsx
 * 
 */
public class Cart {

	private double price;
	private Map<String, CartItem> map = new LinkedHashMap<String, CartItem>(); // key-bookId,value-Cartitem

	/**
	 * 计算总价格
	 * @return
	 */
	public double getPrice() {
		price = 0; // 清零
		for (Map.Entry<String, CartItem> me : map.entrySet()) {
			CartItem item = me.getValue();
			price += item.getPrice();
		}
		
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Map<String, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	
	/**
	 * 向购物车中添加书
	 * @param book
	 */
	public void addBook(Book book) {
		//先判断该书有没有对应的购物项
		String bookId = book.getId();
		boolean has = map.containsKey(bookId);
		if (has) { // 有：购物项加1
			CartItem item = map.get(bookId);
			item.setNum(item.getNum() + 1);
		}
		else {// 没有：创建一个购物项，把书放入
			CartItem item = new CartItem();
			item.setBook(book);
			item.setNum(1);
			map.put(bookId, item);
		}
	}
	
	/**
	 * 删除购物车中某项
	 * @param bookId
	 */
	public void deleteCartItem(String bookId) {
		
		map.remove(bookId);
	}
	
}
