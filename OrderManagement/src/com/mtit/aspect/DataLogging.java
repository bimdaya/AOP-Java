package com.mtit.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.mtit.common.OrderException;

/**
 * Logging details of data access layer
 */
@Aspect
public class DataLogging {
	@Pointcut("execution(* com.mtit.dataaccess.DataAccess.createOrder(..))")
	private void dataCreateOrder() {
	}

	@Before("dataCreateOrder()")
	public void dataCreateOrderBeforeAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " data accessing has started...");
	}

	@After("dataCreateOrder()")
	public void dataCreateOrderAfterAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " data accessing has stopped...");
	}

	@AfterThrowing(pointcut = "dataCreateOrder()", throwing = "e")
	public void dataCreateOrderAfterThrowing(JoinPoint joinPoint, OrderException e) {
		System.out.println(joinPoint.getSignature().getName() + " data access layer exception...");
		System.out.println("An exception is thrown at " + joinPoint.getSignature().getName() + "at data access layer");
		System.out.println("OrderException : " + e);
	}

	@Pointcut("execution(* com.mtit.dataaccess.DataAccess.updateOrder(..))")
	private void dataUpdateOrder() {
	}

	@Before("dataUpdateOrder()")
	public void dataUpdateOrderBeforeAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " data accessing has started...");
	}

	@After("dataUpdateOrder()")
	public void dataUpdateOrderAfterAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " data accessing has stopped...");
	}

	@AfterThrowing(pointcut = "dataUpdateOrder()", throwing = "e")
	public void dataUpdateOrderAfterThrowing(JoinPoint joinPoint, OrderException e) {
		System.out.println(joinPoint.getSignature().getName() + " data access layer exception...");
		System.out.println("An exception is thrown at " + joinPoint.getSignature().getName() + "at data access layer");
		System.out.println("OrderException : " + e);
	}

	@Pointcut("execution(* com.mtit.dataaccess.DataAccess.deleteOrder(..))")
	private void dataDeleteOrder() {
	}

	@Before("dataDeleteOrder()")
	public void dataDeleteOrderBeforeAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " data accessing has started...");
	}

	@After("dataDeleteOrder()")
	public void dataDeleteOrderAfterAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " data accessing has stopped...");
	}

	@AfterThrowing(pointcut = "dataDeleteOrder()", throwing = "e")
	public void dataDeleteOrderAfterThrowing(JoinPoint joinPoint, OrderException e) {
		System.out.println(joinPoint.getSignature().getName() + " data access layer exception...");
		System.out.println("An exception is thrown at " + joinPoint.getSignature().getName() + "at data access layer");
		System.out.println("OrderException : " + e);
	}

	@Pointcut("execution(* com.mtit.dataaccess.DataAccess.getOrderById(..))")
	private void dataGetOrderById() {
	}

	@Before("dataGetOrderById()")
	public void dataGetOrderByIdBeforeAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " data accessing has started...");
	}

	@After("dataGetOrderById()")
	public void dataGetOrderByIdrAfterAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " data accessing has stopped...");
	}

	@AfterThrowing(pointcut = "dataGetOrderById()", throwing = "e")
	public void dataGetOrderByIdAfterThrowing(JoinPoint joinPoint, OrderException e) {
		System.out.println(joinPoint.getSignature().getName() + " data access layer exception...");
		System.out.println("An exception is thrown at " + joinPoint.getSignature().getName() + "at data access layer");
		System.out.println("OrderException : " + e);
	}

}
