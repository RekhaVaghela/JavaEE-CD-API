package com.qa.persistence.repository;

public interface CdInterfaceRepository {
	String getAllCd();

	String addCd(String cd);

	String updateCd(Long id, String cdToUpdate);

	String deleteCd(Long id);

}
