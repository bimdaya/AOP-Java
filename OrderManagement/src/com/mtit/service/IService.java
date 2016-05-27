package com.mtit.service;

import com.mtit.bean.Order;
import com.mtit.common.OrderException;

/**
 * Service interface defines operations related to oder handling
 */
public interface IService {

	/**
	 * Method to connect data access layer with service layer
	 **/
	public void getConnection();

	/**
	 * Method to add a new order
	 * 
	 * @param Order
	 *            Order class object containing order details
	 * @exception OrderException
	 */
	public void createOrder(Order order) throws OrderException;

	/**
	 * Method to retrieve order details relevant to an order id
	 * 
	 * @param id
	 *            Order id
	 * @exception OrderException
	 */
	public void getOrderById(int id) throws OrderException;

	/**
	 * Method to update quantity and amount of an order
	 * 
	 * @param id
	 *            Order id
	 * @param quantity
	 *            number of items
	 * @param amount
	 *            total price
	 * @exception OrderException
	 */
	public void updateOrder(int id, int quantity, float amount) throws OrderException;

	/**
	 * Method to delete order details relevant to an order id
	 * 
	 * @param id
	 *            Order id
	 * @exception OrderException
	 */
	public void deleteOrder(int id) throws OrderException;

	/**
	 * Method to retrieve all order details
	 * 
	 * @exception OrderException
	 */
	public void getAllOrders() throws OrderException;

}
