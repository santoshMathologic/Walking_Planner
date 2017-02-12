package com.cfa.project.walkinplanner.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cfa.project.walkinplanner.cutom.repository.WalkInCustomRepositoryImpl;
import com.cfa.project.walkinplanner.models.WalkInDetailsModel;

@Controller
@RequestMapping("/api/v1/walkin")
public class WalkInController {
	
	
	@Autowired
	WalkInCustomRepositoryImpl walkInCustomRepository;
	
	//-----------Get Walking Information-------------> URL: api/v1/walking/getInfo
	@RequestMapping(value = "/getInfo", method = RequestMethod.GET)
	public @ResponseBody List<WalkInDetailsModel> getInfo(){
	
		List<WalkInDetailsModel> walkInDetailsList = (List<WalkInDetailsModel>) walkInCustomRepository.findByWalkingDate();
		
	return walkInDetailsList;
	}

	public WalkInCustomRepositoryImpl getWalkInCustomRepository() {
		return walkInCustomRepository;
	}

	public void setWalkInCustomRepository(WalkInCustomRepositoryImpl walkInCustomRepository) {
		this.walkInCustomRepository = walkInCustomRepository;
	}

}
