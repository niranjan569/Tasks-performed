package com.aspectjAnnotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
public class TrackOperation {
	// Point cut for all methods in operation class
	@Pointcut("execution(* Operation.*(..))")
	public void allMethods() {
	}

	// Before advice for pointcut allMethods
	@Before("allMethods()")
	public void beforeAdvice(JoinPoint jp) {
		System.out.println("\nbefore method");
		System.out.println("Method signature:" + jp.getSignature());
	}

	// Point cut for all methods that start with m in operation class
	@Pointcut("execution(* Operation.m*(..))")
	public void methodsStartWithM() {
	}

	// After advice for pointcut methodsStartWithM
	@After("methodsStartWithM()")
	public void afterAdvice() {
		System.out.println("This method starts with m");
	}

	// AfterReturn advice with pointcut for all methods in operation class
	@AfterReturning(pointcut = "execution(* Operation.*(..))", returning = "result")
	public void afterReturn(JoinPoint jp, Object result) {
		System.out.println("Result in advice: " + result);
	}

	// Point cut for display method in operation class
	@Pointcut("execution(* Operation.display())")
	public void displayAround() {
	}

	// Around advice for pointcut displayAround
	@Around("displayAround()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Before display()");
		Object obj = pjp.proceed();
		System.out.println("After display()");
		return obj;
	}

	// AfterThrowing advice with pointcut for all methods in operation class
	@AfterThrowing(pointcut = "execution(* Operation.*(..)))", throwing = "error")
	public void myadvice(JoinPoint jp, Throwable error) {
		System.out.println("after throwing advice");
		System.out.println("Exception is: " + error);
		System.out.println("end of after throwing advice...");
	}
}
