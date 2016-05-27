package com.mtit.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mtit.bean.Order;
import com.mtit.common.OrderConstant;

/**
 * Map result obtained from database with Order class object
 */
public class OrderMapper implements RowMapper<Order> {
	public Order mapRow(ResultSet rs, int rowNo) throws SQLException {

		Order order = new Order();
		order.setId(rs.getInt(OrderConstant.ID));
		order.setCusName(rs.getString(OrderConstant.NAME));
		order.setItemCode(rs.getString(OrderConstant.ITEM_CODE));
		order.setTp(rs.getString(OrderConstant.TP));
		order.setQuantity(rs.getInt(OrderConstant.QUANTITY));
		order.setOrderDate(rs.getString(OrderConstant.ORDER_DATE));
		order.setAmount(rs.getFloat(OrderConstant.AMOUNT));
		return order;
	}
}
