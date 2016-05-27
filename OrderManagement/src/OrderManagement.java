import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mtit.bean.Order;
import com.mtit.common.OrderConstant;
import com.mtit.common.OrderException;
import com.mtit.service.IService;

/**
 * Main class of the application
 */
public class OrderManagement {
	private static AbstractApplicationContext context;
	private static Scanner scanner;

	public static void main(String[] args) throws OrderException {
		System.out.println("Starting Order Management Application....... ");
		context = new ClassPathXmlApplicationContext(OrderConstant.CONFIGURATION);

		// Connect with service class
		IService service = (IService) context.getBean(OrderConstant.SERVICE);
		service.getConnection();

		scanner = new Scanner(System.in);
		int response = 0;

		while (true) {
			System.out.println(
					"select the modifications you want to do:  \n Place an Order = 1  \n Modify an Order = 2 \n Remove an Order = 3 \n View Order Details = 4 \n Exit = 5");

			try {
				// get user input to perform operation
				response = Integer.parseInt(scanner.nextLine());
			} catch (InputMismatchException e) {
				String message = "Please enter numerical values...";
				throw new OrderException(message);
			}
			// add a new customer
			if (response == 1) {

				System.out.println(
						"Place a new order... \n Remember after placing an order you can only change quantity and price of the ordered item.");

				System.out.println("Enter Customer Name: ");
				String cusName = scanner.nextLine();
				// validate customer name (should only include letters)
				String regex = "[a-zA-Z]+";
				if (!cusName.matches(regex)) {
					String message = "Please enter a numerical values...";
					throw new OrderException(message);
				}

				System.out.println("Enter Item Code (ex: XXX-999): ");
				String itemCode = scanner.nextLine();
				// validate item code
				regex = "[a-zA-Z]{3}-\\d{3}";
				if (!itemCode.matches(regex)) {
					String message = "Please enter a valid Item Code...";
					throw new OrderException(message);
				}

				System.out.println("Enter Contact Number (ex: 0123456789): ");
				String tp = scanner.nextLine();
				// validate contact number (should include 10 digits)
				regex = "\\d{10}";
				if (!tp.matches(regex)) {
					String message = "Please enter a valid contact number...";
					throw new OrderException(message);
				}

				int quantity = 0;
				float amount = 0.0f;

				try {
					// user input values should be integer else throw exception
					System.out.println("Enter Item Quantity: ");
					quantity = scanner.nextInt();
					scanner.nextLine();

					// user input values should be float else throw exception
					System.out.println("Enter Total Price (Rs/=): ");
					amount = scanner.nextFloat();
					scanner.nextLine();

				} catch (InputMismatchException e) {
					String message = "Please enter numerical values...";
					throw new OrderException(message);
				}

				System.out.println("Enter Ordered Date (YYYY-MM-dd): ");
				String orderDate = scanner.nextLine();

				// validate date format
				regex = "\\d{4}-\\d{2}-\\d{2}";
				if (!orderDate.matches(regex)) {
					String message = "Please enter a valid contact date...";
					throw new OrderException(message);
				}

				// create Order object and call createOrder service layer method
				Order order = new Order();
				order.setCusName(cusName);
				order.setItemCode(itemCode);
				order.setAmount(amount);
				order.setQuantity(quantity);
				order.setTp(tp);
				order.setOrderDate(orderDate);

				service.createOrder(order);

			}

			else if (response == 2) {

				System.out.println("Update an order...\n You can only change quantity and price of the ordered item.");

				service.getAllOrders();

				int orderID = 0;
				int quantity = 0;
				float amount = 0.0f;

				try {

					// user input values should be integer else throw exception
					System.out.println("Enter Customer ID : ");
					orderID = scanner.nextInt();
					scanner.nextLine();

					// user input values should be integer else throw exception
					System.out.println("Enter Item Quantity: ");
					quantity = scanner.nextInt();
					scanner.nextLine();

					// user input values should be float else throw exception
					System.out.println("Enter Total Price: ");
					amount = scanner.nextFloat();
					scanner.nextLine();

				} catch (InputMismatchException e) {
					String message = "Please enter numerical values...";
					throw new OrderException(message);
				}

				// call updateOrder service layer method
				service.updateOrder(orderID, quantity, amount);

			} else if (response == 3) {

				System.out.println("Remove an order...");

				service.getAllOrders();
				int orderID = 0;

				try {

					// user input values should be integer else throw exception
					System.out.println("Enter Customer ID : ");
					orderID = scanner.nextInt();
					scanner.nextLine();

				} catch (InputMismatchException e) {
					String message = "Please enter numerical values...";
					throw new OrderException(message);
				}

				// call deleteOrder service layer method
				service.deleteOrder(orderID);

			} else if (response == 4) {

				System.out.println("Details of the order...");

				int orderID = 0;

				try {

					// user input values should be integer else throw exception
					System.out.println("Enter Customer ID : ");
					orderID = scanner.nextInt();
					scanner.nextLine();

				} catch (InputMismatchException e) {
					String message = "Please enter valid information...";
					throw new OrderException(message);
				}

				service.getOrderById(orderID);

			} else if (response == 5) {

				// exit from the application
				System.out.println("Terminating the application... ");
				break;

			} else {

				System.out.println("Please enter a valid number. ");

			}

		}
		scanner.close();
		context.close();
	}

}
