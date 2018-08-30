package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.cd.model.CdInfo;
import com.qa.util.JSONUtil;

@ApplicationScoped
@Alternative
public class CdMapRepository implements CdInterfaceRepository{
	private final Long INITIAL_COUNT = 1L;
	private Map<Long, CdInfo> cdMap;
	private Long ID;

	@Inject
	private JSONUtil util;

	public CdMapRepository() {
		this.cdMap = new HashMap<Long, CdInfo>();
		ID = INITIAL_COUNT;
		initCdInfoMap();
	}
	@Override
	public String getAllCd() {
		return util.getJSONForObject(cdMap.values());
	}

	@Override
	public String addCd(String cd) {
		ID++;
		CdInfo newCd = util.getObjectForJSON(cd, CdInfo.class);
		cdMap.put(ID, newCd);
		return cd ;
	}

	@Override
	public String updateCd(Long id, String cdToUpdate) {
		CdInfo newAccount = util.getObjectForJSON(cdToUpdate, CdInfo.class);
		cdMap.put(id, newAccount);
		return cdToUpdate;
	}

	@Override
	public String deleteCd(Long id) {
		cdMap.remove(id);
		return "{\"message\": \"cd sucessfully removed\"}";
	}

	private void initCdInfoMap() {
		CdInfo cd = new CdInfo();
		cdMap.put(1L, cd);
	}

}
