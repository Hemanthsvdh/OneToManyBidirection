package comOTM_MTO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class TestHospitalBranch {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hema");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Branch branch1=new Branch();
		 branch1.setName("Hsptl rajajinagar");
		 branch1.setState("Karnataka");
		 branch1.setCountry("India");
		 branch1.setPhone(87654321);
		 
		 Branch branch2=new Branch();
		 branch2.setName("Hsptl RRnagar");
		 branch2.setState("Karnataka");
		 branch2.setCountry("India");
		 branch2.setPhone(87654322);
		 
		 Branch branch3=new Branch();
		 branch3.setName("Hsptl Basavangudi");
		 branch3.setState("Karnataka");
		 branch3.setCountry("India");
		 branch3.setPhone(87654323);
		 
		 List<Branch> b=new ArrayList<Branch>();
		 b.add(branch1);
		 b.add(branch2);
		 b.add(branch3);
		 
		 Hospital hsptl= new Hospital();
		 hsptl.setName("Global Hsptl");
		 hsptl.setWeb("global@123");
		 hsptl.setBranch(b);
		 branch1.setHospital(hsptl);
		 branch2.setHospital(hsptl);
		 branch3.setHospital(hsptl);
		 
		 et.begin();
		 em.persist(hsptl);
		 em.persist(branch1);
		 em.persist(branch2);
		 em.persist(branch3);
		 et.commit();
		 
	}

}
