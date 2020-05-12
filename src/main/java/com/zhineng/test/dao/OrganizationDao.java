package com.zhineng.test.dao;

import com.zhineng.test.domain.po.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationDao extends JpaRepository<Organization, Integer> {
    Organization findOrganizationByOrganizationId(Integer organizationId);
}
