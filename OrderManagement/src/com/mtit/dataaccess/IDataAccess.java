package com.mtit.dataaccess;

import java.util.List;

import javax.sql.DataSource;
import com.mtit.bean.Order;
import com.mtit.common.OrderException;

/**
 * Data Access interface defines CURD operations related to oder handling
 */
public interface IDataAccess {
	/**
	 * Method to add a new order to database
	 * 
	 * @param Order
	 *            Order class object containing order details
	 * @exception OrderException
	 */
	public void createOrder(Order order) throws OrderException;

	/**
	 * Method to retrieve order details relevant to an order id from database
	 * 
	 * @param id
	 *            Order id
	 * @return Order class object containing order details
	 * @exception OrderException
	 */
	public Order getOrderById(int id) throws OrderException;

	/**
	 * Method to update quantity and amount of an order of the database
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
	 * Method to delete order details relevant to an order id from database
	 * 
	 * @param id
	 *            Order id
	 * @exception OrderException
	 */
	public void deleteOrder(int id) throws OrderException;

	/**
	 * Method to retrieve all order details from database
	 * 
	 * @return list of Order class objects containing order details
	 * @exception OrderException
	 */
	public List<Order> getAllOrders() throws OrderException;

	/**
	 * Method to initialize the database connection
	 * 
	 * @param Datasource
	 *            datasource
	 */
	void setDataSource(DataSource ds);
}
