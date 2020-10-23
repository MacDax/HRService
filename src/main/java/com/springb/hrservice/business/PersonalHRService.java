package com.springb.hrservice.business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import com.spring.boot.personsdb.transactions.GetPersonalDataDelegate;
import com.spring.boot.personsdb.transactions.PersonalDTO;
import com.springb.hrservice.to.domain.Person;

import ch.qos.logback.classic.net.SyslogAppender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean("PersonalHRService-v1")
public class PersonalHRService {

	private static final Logger logger = LoggerFactory.getLogger(PersonalHRService.class);
	@Inject
	private  GetPersonalDataDelegate getPersonalDataDelegate;
	
	public List<PersonalDTO> getPersonDataList() throws Exception {
		List<PersonalDTO> dataList = getPersonalDataDelegate.getPersonsDataList();
		logger.info("data list fetched from db : " + dataList.size());
		dataList.stream().forEach(pfname -> System.out.println(pfname.getFname()));
		return dataList;
	}
	
	public boolean savePersonsData(List<Person> personsList) {
		List<PersonalDTO> dataList = new ArrayList<>();
		logger.info("Input personslist : " + personsList.size());
		personsList.stream().forEach(person -> {
			PersonalDTO personDTO = new PersonalDTO();
			personDTO.setFname(person.getFname());
			personDTO.setLname(person.getLname());
			dataList.add(personDTO);
		});
		try {
			boolean result = getPersonalDataDelegate.savePersonsData(dataList);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
