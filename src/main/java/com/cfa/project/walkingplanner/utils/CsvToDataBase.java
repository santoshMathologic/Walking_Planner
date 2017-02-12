package com.cfa.project.walkingplanner.utils;

import org.springframework.stereotype.Service;

@Service
public interface CsvToDataBase {

	  boolean processRecord(String[] columns);

}
