package com.yogi.api.aop;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private static final Logger LOGGER = Logger.getLogger(LoggingAspect.class);

	/**
	 * 
	 * @author Krishan Shukla
	 * Created by Krishan Shukla on 20/10/2017.
	 * @param joinPoint
	 */
	@Before("execution(* com.yogi.api.service.VehicleFileScannerService.*(..))")
	public void beforeSampleCreation(JoinPoint joinpoint) {
		 LOGGER.info("executing "+joinpoint.getSignature()+" with arguments "+Arrays.toString(joinpoint.getArgs())+"]");
	}


	/**
	 *
	 * @param joinPoint
	 */
	@AfterReturning("execution(* com.yogi.api.service.VehicleFileScannerService.*(..))")
	public void logServiceAccess(JoinPoint joinpoint) {
		 LOGGER.info("executed "+joinpoint.getSignature()+" with arguments "+Arrays.toString(joinpoint.getArgs())+"]");
	}

}
