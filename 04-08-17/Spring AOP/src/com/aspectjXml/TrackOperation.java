package com.aspectjXml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class TrackOperation {

	// Method which executes for before advice
	public void beforeAdvice(JoinPoint jp) {
		System.out.println("\nbefore method");
		System.out.println("Method signature:" + jp.getSignature());
	}

	// Method which executes for after advice
	public void afterAdvice() {
		System.out.println("This method starts with m");
	}

	// Method which executes for after return advice
	public void afterReturn(JoinPoint jp, Object result) {
		System.out.println("Result in advice: " + result);
	}

	// Method which executes for around advice
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Before display()");
		Object obj = pjp.proceed();
		System.out.println("After display()");
		return obj;
	}

	// Method which executes for after throwing advice
	public void myadvice(JoinPoint jp, Throwable error) {
		System.out.println("after throwing advice");
		System.out.println("Exception is: " + error);
		System.out.println("end of after throwing advice...");
	}
}
