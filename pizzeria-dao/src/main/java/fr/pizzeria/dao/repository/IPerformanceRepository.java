/**
 * 
 */
package fr.pizzeria.dao.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Performance;


/**
 * @author ETY
 *
 */
public interface IPerformanceRepository extends JpaRepository<Performance, Integer> {
	
}
