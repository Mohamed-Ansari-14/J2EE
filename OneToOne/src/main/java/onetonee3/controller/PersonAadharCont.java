package onetonee3.controller;

import onetonee3.dao.AadharCardDao;
import onetonee3.dao.PersonDao;
import onetonee3.dto.AadharCard;
import onetonee3.dto.Person;

public class PersonAadharCont {
public static void main(String[] args) {
//	Person person=new Person();
//	person.setId(1);
//	person.setName("Mohamed");
//	person.setAddress("Chennai");
//	
//	PersonDao personDao=new PersonDao();
//	personDao.savePerson(person);	
//	
//	AadharCard aadharCard=new AadharCard();
//	aadharCard.setId(100);
//	aadharCard.setAge(21);
//	aadharCard.setName("Ansari");
//	
//	AadharCardDao aadharCardDao=new AadharCardDao();
//	aadharCardDao.saveAadharCard(1, aadharCard);
	
//	FIND
	
//	PersonDao personDao=new PersonDao();
//	personDao.findPerson(1);
//	AadharCardDao aadharCardDao=new AadharCardDao();
//	aadharCardDao.findAadharCard(100);
	
//	UPDATE
	
	Person person=new Person();
	person.setName("Ansari");
	person.setAddress("Tenkasi");
	PersonDao personDao = new PersonDao();
	personDao.updatePerson(1, person);
	
//	Delete
	
//	AadharCardDao aadharCardDao=new AadharCardDao();
//	aadharCardDao.deleteAadhar(200);
//	PersonDao  personDao=new PersonDao();
//	personDao.deletePerson(1);
	
}
}
