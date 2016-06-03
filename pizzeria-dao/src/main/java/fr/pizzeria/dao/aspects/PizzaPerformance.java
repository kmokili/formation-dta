package fr.pizzeria.dao.aspects;

import java.time.Duration;
import java.time.LocalDateTime;
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
	
//	@Around("execution(* fr.pizzeria.dao.IPizzaDao.*(..))")
//	public void profilerCreate(ProceedingJoinPoint pjp) throws Throwable {
//		LOG.log(Level.INFO, "Entrée dans l'aspect PizzaPerformance");
//		
//		
//		// noter le temps de départ
//		LocalDateTime debut = LocalDateTime.now();
//		Object valeurRetournee = pjp.proceed();
//		String service = pjp.getSignature().toString();
//		
//		LOG.log(Level.INFO, "Hell Yeah ! service = " + service);
//		/**
//		 *  @TODO récupérer le nom du service (méthode)
//		 */
//		
//		// noter le temps de fin et calculer le temps d’exécution
//		LocalDateTime fin = LocalDateTime.now();
//		Long duree = Duration.between(debut, fin).toMillis() ;
////		Performance perf = new Performance(service, debut, duree);
//	}
	
	@Around("execution(* fr.pizzeria.dao.IPizzaDao.*(..))")
	public void profilerCreate(ProceedingJoinPoint pjp) throws Throwable {
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
		
	}
	
}
