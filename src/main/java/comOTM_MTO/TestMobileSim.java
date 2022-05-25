package comOTM_MTO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestMobileSim {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Hema");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Mobile mob=new Mobile();
		mob.setName("samsung");
		mob.setCost(30000.00);

		
		Sim sim1=new Sim();
		sim1.setProvider("Reliance");
		sim1.setType("3g");
		
		Sim sim2=new Sim();
		sim2.setProvider("jio");
		sim2.setType("5g");
		
		Sim sim3=new Sim();
		sim3.setProvider("vdf");
		sim3.setType("4g");
		
		List<Sim> sims=new ArrayList<Sim>();
		sims.add(sim1);
		sims.add(sim2);
		sims.add(sim3);
		
		mob.setSims(sims);
		sim1.setMobile(mob);
		sim2.setMobile(mob);
		sim3.setMobile(mob);
		
		et.begin();
		em.persist(mob);
		em.persist(sim1);
		em.persist(sim2);
		em.persist(sim3);
		et.commit();
	}
}
