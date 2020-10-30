package com.springb.hrservice.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.boot.personsdb.transactions.PersonalDTO;
import com.springb.hrservice.business.ErrorMessages;
import com.springb.hrservice.business.PersonalHRResponse;
import com.springb.hrservice.business.PersonalHRService;
import com.springb.hrservice.to.domain.Person;

@ManagedBean
public class PersonalResourceDelegate {

	private static final Logger logger = LoggerFactory.getLogger(PersonalResourceDelegate.class);
	@Inject
	private PersonalHRService personalHRService;
	
	public Response savePersonsList(List<Person> personsList) {
		boolean result = personalHRService.savePersonsData(personsList);
		if(result) {
			logger.info("data saved");
			PersonalHRResponse personalHRResponse = new PersonalHRResponse();
			personalHRResponse.setStatus("Success");
			Response rs = Response.ok().entity(personalHRResponse).build();
			return rs;
		}
		PersonalHRResponse personalHRResponse = populateErrorMessage();
		Response rs = Response.ok().entity(personalHRResponse).build();
		return rs;
	}
	
	public Response getPersonsList() throws Exception {
		logger.info("get data list through delegate");
		List<PersonalDTO> dataList = personalHRService.getPersonDataList();
		logger.info("dataList size : " + dataList.size());		
		
		PersonalHRResponse personalHRResponse = populatePersonsData(dataList);
		Response rs = Response.ok().entity(personalHRResponse).build();
		return rs;
	}

	private PersonalHRResponse populatePersonsData(List<PersonalDTO> dataList) {
		if(null == dataList) {
			PersonalHRResponse personalHRResponse = populateErrorMessage();
			return personalHRResponse;
		}
		List<Person> hrPersonsList = new ArrayList<>();
		dataList.stream().forEach(persondt -> {
			Person person = new Person();
			person.setFname(persondt.getFname());
			person.setLname(persondt.getLname());
			person.setId(persondt.getId());
			hrPersonsList.add(person);
		});
		PersonalHRResponse personalHRResponse = new PersonalHRResponse();
		personalHRResponse.setPersons(hrPersonsList);
		return personalHRResponse;
	}

	private PersonalHRResponse populateErrorMessage() {
		PersonalHRResponse personalHRResponse = new PersonalHRResponse();
		personalHRResponse.setStatus("FAILURE");
		ErrorMessages errorMessage = new ErrorMessages();
		errorMessage.setCode("NODATA-101");
		errorMessage.setMessage("No data returned");
		personalHRResponse = new PersonalHRResponse();
		return personalHRResponse;
	}
}
