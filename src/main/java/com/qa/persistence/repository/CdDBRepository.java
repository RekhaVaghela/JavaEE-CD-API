package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


import com.qa.cd.model.CdInfo;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class CdDBRepository implements CdInterfaceRepository{
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllCd() {
		Query query = manager.createQuery("Select cd FROM CdInfo cd");
		Collection<CdInfo> CdInfo= (Collection<CdInfo>) query.getResultList();
		return util.getJSONForObject(CdInfo);
	}

	@Override
	@Transactional(REQUIRED)
	public String addCd(String cd) {
		CdInfo newCd = util.getObjectForJSON(cd, CdInfo.class);
		manager.persist(newCd);
		return "{\"message\": \"cd has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateCd(Long id, String cdToUpdate) {
		CdInfo updatedCd = util.getObjectForJSON(cdToUpdate, CdInfo.class);
		CdInfo cdFromDB = findCdInfo(id);
		if (cdToUpdate != null) {
			cdFromDB = updatedCd;
			manager.merge(cdFromDB);
		}
		return "{\"message\": \"cd sucessfully updated\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteCd(Long id) {
		CdInfo cdInDB = findCdInfo(id);
		if (cdInDB != null) {
			manager.remove(cdInDB);
		}
		return "{\"message\": \"cd sucessfully deleted\"}";
	}

	private CdInfo findCdInfo(Long id) {
		return manager.find(CdInfo.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
