package br.com.contato;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class ContatoRepository {
		
	
	
		@PersistenceContext
		private EntityManager em;

		@Transactional
		public void remove(Contato contato) {
			em.remove(contato);
		}
		
		@Transactional
		public void merge(Contato contato) {
			// TODO Auto-generated method stub
			em.merge(contato);
			
		}
		
		
		
//		public void merge(Contato contato) {
//			ApplicationContext applicationContext = new SpringApplicationBuilder(Contato.class)
//					.web(WebApplicationType.NONE).run();
//			em.getTransaction().begin();
//			em.merge(contato);
//			em.getTransaction().commit();
//			em.close();
//		}
//		
//		
//		public void remove(Contato contato) {
//			ApplicationContext applicationContext = new SpringApplicationBuilder(Contato.class)
//					.web(WebApplicationType.NONE).run();
//			em.getTransaction().begin();
//			em.remove(contato);
//			em.getTransaction().commit();
//			em.close();
//		}
		

	}


