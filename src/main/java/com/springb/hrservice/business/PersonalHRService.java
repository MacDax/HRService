package com.springb.hrservice.business;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import com.spring.boot.personsdb.transactions.GetPersonalDataDelegate;
import com.spring.boot.personsdb.transactions.PersonalDTO;

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
}
