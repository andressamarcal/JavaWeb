package softsale.model.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericService {
	static EntityManagerFactory entityManagerFactory  = Persistence.createEntityManagerFactory("SoftSale");
}
