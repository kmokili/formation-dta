package fr.pizzeria.dao.aspects;

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.repository.IPerformanceRepository;
import fr.pizzeria.model.Performance;

@Aspect
@Component
public class PizzaPerformance {
	@Autowired private IPerformanceRepository perfRepository;
	
	private static final Logger LOG = Logger.getLogger(PizzaPerformance.class.toString());
	
	
	@Around("execution(* fr.pizzeria.dao.IPizzaDao.*(..))")
	public Object profilerCreate(ProceedingJoinPoint pjp) throws Throwable {
		LOG.log(Level.INFO, "Entrée dans l'aspect PizzaPerformance");
		long start = System.currentTimeMillis();
		
		// noter le temps de départ
		
		Object obj = pjp.proceed();
		long end = System.currentTimeMillis();
		
		
		Performance perf = new Performance();
		perf.setService(pjp.getSignature().toShortString());
		perf.setTempsExecution(end-start);
		perf.setDate(Calendar.getInstance().getTime());
		
		perfRepository.save(perf);
		return obj;
	}
	
}
