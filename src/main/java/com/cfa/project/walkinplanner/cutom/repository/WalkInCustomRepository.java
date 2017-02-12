package com.cfa.project.walkinplanner.cutom.repository;

import java.util.List;

import com.cfa.project.walkinplanner.models.WalkInDetailsModel;


public interface WalkInCustomRepository {

	public List<WalkInDetailsModel> findByWalkingDate();
}
