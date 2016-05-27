package com.mtit.dataaccess;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import com.mtit.bean.Order;
import com.mtit.common.OrderException;

/**
 * Implementation of CRUD operations on IDataAccess class
 */
public class DataAccess implements IDataAccess {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * Method to add a new order to database
	 * 
	 * @param Order
	 *            Order class object containing order details
	 * @exception OrderException
	 */
	@Override
	public void createOrder(Order order) throws OrderException {
		int result = 0;
		String query = "INSERT INTO OrderDetails (cusName,itemCode,quantity,amount,tp,orderDate)"
				+ " values (?, ?, ?, ?, ?, ?)";
		result = jdbcTemplateObject.update(query, order.getCusName(), order.getItemCode(), order.getQuantity(),
				order.getAmount(), order.getTp(), order.getOrderDate());

		if (result <= 0) {
			throw new OrderException(
					"Order creation process of Customer : " + order.getCusName() + " failed. Please try again.");
		}

		System.out.println("Order details: ID = " + result + " Amount = " + order.getAmount() + " ItemCode = "
				+ order.getItemCode() + " Quantity = " + order.getQuantity());
		System.out.println("Order is added to the queue sucessfully...");

	}

	/**
	 * Method to retrieve order details relevant to an order id from database
	 * 
	 * @param id
	 *            Order id
	 * @return Order class object containing order details
	 * @exception OrderException
	 */
	@Override
	public Order getOrderById(int id) throws OrderException {
		Order order = null;

		String SQL = "SELECT * FROM OrderDetails where id = ?";
		try {

			order = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new OrderMapper());

		} catch (EmptyResultDataAccessException e) {
			throw new OrderException("Order details of ID : " + id + " can not be found.");
		}

		return order;
	}

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
	@Override
	public void updateOrder(int id, int quantity, float amount) throws OrderException {
		int result = 0;
		String SQL = "UPDATE OrderDetails set quantity = ?, amount = ? where id = ?";

		result = jdbcTemplateObject.update(SQL, quantity, amount, id);

		if (result <= 0) {
			throw new OrderException("Order modification process of Customer : " + id + " failed. Please try again.");
		}

		System.out.println("Order details: ID = " + id + " Total Price = " + amount + " Quantity = " + quantity);
		System.out.println("Order has modified sucessfully...");

	}

	/**
	 * Method to delete order details relevant to an order id from database
	 * 
	 * @param id
	 *            Order id
	 * @exception OrderException
	 */
	@Override
	public void deleteOrder(int id) throws OrderException {
		int result = 0;
		String SQL = "DELETE FROM OrderDetails where id = ?";

		result = jdbcTemplateObject.update(SQL, id);

		if (result <= 0) {
			throw new OrderException("Order modification process of Customer : " + id + " failed. Please try again.");
		}

		System.out.println("Order details: ID = " + id);
		System.out.println("Order has deleted sucessfully...");
	}

	/**
	 * Method to retrieve all order details from database
	 * 
	 * @return list of Order class objects containing order details
	 * @exception OrderException
	 */
	@Override
	public List<Order> getAllOrders() throws OrderException {
		String SQL = "SELECT * FROM OrderDetails ";
		List<Order> orders = null;
		try {
			orders = jdbcTemplateObject.query(SQL, new OrderMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new OrderException("Order details can not be found.");
		}
		return orders;
	}

	/**
	 * Method to initialize the database connection 
	 * 
	 * @param Datasource datasource 
	 */
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);

	}

}
