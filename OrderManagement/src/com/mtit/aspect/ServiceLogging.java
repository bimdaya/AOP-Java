package com.mtit.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.mtit.common.OrderException;

/**
 * Logging details of service layer
 */
@Aspect
public class ServiceLogging {
	@Pointcut("execution(* com.mtit.service.Service.createOrder(..))")
	private void serviceCreateOrder() {
	}

	@Before("serviceCreateOrder()")
	public void serviceCreateOrderBeforeAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " service has started...");
	}

	@After("serviceCreateOrder()")
	public void serviceCreateOrderAfterAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " service has stopped...");
	}

	@AfterThrowing(pointcut = "serviceCreateOrder()", throwing = "e")
	public void serviceCreateOrderAfterThrowing(JoinPoint joinPoint, OrderException e) {
		System.out.println(joinPoint.getSignature().getName() + " service layer exception...");
		System.out.println("An exception is thrown at " + joinPoint.getSignature().getName() + "at service layer");
	}

	@Pointcut("execution(* com.mtit.service.Service.updateOrder(..))")
	private void serviceUpdateOrder() {
	}

	@Before("serviceUpdateOrder()")
	public void serviceUpdateOrderBeforeAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " service has started...");
	}

	@After("serviceUpdateOrder()")
	public void serviceUpdateOrderAfterAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " service has stopped...");
	}

	@AfterThrowing(pointcut = "serviceUpdateOrder()", throwing = "e")
	public void serviceUpdateOrderAfterThrowing(JoinPoint joinPoint, OrderException e) {
		System.out.println(joinPoint.getSignature().getName() + " service layer exception...");
		System.out.println("An exception is thrown at " + joinPoint.getSignature().getName() + "at service layer");
		System.out.println("OrderException : " + e);
	}

	@Pointcut("execution(* com.mtit.service.Service.deleteOrder(..))")
	private void serviceDeleteOrder() {
	}

	@Before("serviceDeleteOrder()")
	public void serviceDeleteOrderBeforeAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " service has started...");
	}

	@After("serviceDeleteOrder()")
	public void serviceDeleteOrderAfterAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " service has stopped...");
	}

	@AfterThrowing(pointcut = "serviceDeleteOrder()", throwing = "e")
	public void serviceDeleteOrderAfterThrowing(JoinPoint joinPoint, OrderException e) {
		System.out.println(joinPoint.getSignature().getName() + " service layer exception...");
		System.out.println("An exception is thrown at " + joinPoint.getSignature().getName() + "at service layer");
		System.out.println("OrderException : " + e);
	}

	@Pointcut("execution(* com.mtit.service.Service.getOrderById(..))")
	private void serviceGetOrderById() {
	}

	@Before("serviceGetOrderById()")
	public void serviceGetOrderByIdBeforeAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " service has started...");
	}

	@After("serviceGetOrderById()")
	public void serviceGetOrderByIdrAfterAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + " service has stopped...");
	}

	@AfterThrowing(pointcut = "serviceGetOrderById()", throwing = "e")
	public void serviceGetOrderByIdAfterThrowing(JoinPoint joinPoint, OrderException e) {
		System.out.println(joinPoint.getSignature().getName() + " service layer exception...");
		System.out.println("An exception is thrown at " + joinPoint.getSignature().getName() + "at service layer");
		System.out.println("OrderException : " + e);
	}

}
