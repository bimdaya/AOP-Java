package com.mtit.service;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mtit.bean.Order;
import com.mtit.common.OrderConstant;
import com.mtit.common.OrderException;
import com.mtit.dataaccess.IDataAccess;

/**
 * Implementation of operations on IService class
 */
public class Service implements IService {

	private IDataAccess dataAccess;

	/**
	 * Method to connect data access layer with service layer
	 **/
	@Override
	public void getConnection() {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(OrderConstant.CONFIGURATION);
		this.dataAccess = (IDataAccess) context.getBean(OrderConstant.DATAACCESS);
		context.close();
	}

	/**
	 * Method to add a new order
	 * 
	 * @param Order
	 *            Order class object containing order details
	 * @exception OrderException
	 */
	@Override
	public void createOrder(Order order) throws OrderException {
		dataAccess.createOrder(order);
	}

	/**
	 * Method to retrieve order details relevant to an order id
	 * 
	 * @param id
	 *            Order id
	 * @exception OrderException
	 */
	@Override
	public void getOrderById(int id) throws OrderException {
		Order order = dataAccess.getOrderById(id);

		System.out.println("Order ID = " + id + " details retrieved");
		System.out.println("Order ID : " + order.getId());
		System.out.println("Customer Name : " + order.getCusName());
		System.out.println("Item Code : " + order.getItemCode());
		System.out.println("Ordered Date : " + order.getOrderDate());
		System.out.println("Contact Number : " + order.getTp());
		System.out.println("Item quantity : " + order.getQuantity());
		System.out.println("Total Price : " + order.getAmount());

	}

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
	@Override
	public void updateOrder(int id, int quantity, float amount) throws OrderException {
		dataAccess.updateOrder(id, quantity, amount);

	}

	/**
	 * Method to delete order details relevant to an order id
	 * 
	 * @param id
	 *            Order id
	 * @exception OrderException
	 */
	@Override
	public void deleteOrder(int id) throws OrderException {
		dataAccess.deleteOrder(id);
	}

	/**
	 * Method to retrieve all order details
	 * 
	 * @exception OrderException
	 */
	@Override
	public void getAllOrders() throws OrderException {

		List<Order> orders = dataAccess.getAllOrders();

		System.out.println(
				"Order_ID\t Customer_Name\t Item_Code\t Ordered_Date\t Contact_Number\t Quantity\t Total_Price");
		for (Order order : orders) {
			System.out.print(order.getId() + "\t\t");
			System.out.print(order.getCusName() + "\t\t");
			System.out.print(order.getItemCode() + "\t\t");
			System.out.print(order.getOrderDate() + "\t");
			System.out.print(order.getTp() + "\t\t");
			System.out.print(order.getQuantity() + "\t\t");
			System.out.print(order.getAmount());
			System.out.println();
		}
	}

}
