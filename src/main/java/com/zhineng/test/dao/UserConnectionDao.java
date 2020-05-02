package com.zhineng.test.dao;

import com.zhineng.test.domain.po.UserConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserConnectionDao extends JpaRepository<UserConnection, Integer> {

    List<UserConnection> findUserConnectionsByRootId(Integer rootId);

    List<UserConnection> findUserConnectionsByLeaveId(Integer leaveId);

    List<UserConnection> findUserConnectionsByRootIdAndRelationType(Integer rootId, Integer relationType);

    List<UserConnection> findUserConnectionsByLeaveIdAndRelationType(Integer leaveId, Integer relationType);

    List<UserConnection> findAllByConnectionId(Integer connectionId);

    List<UserConnection> findAllByLeaveId(Integer leaveId);

    void deleteUserConnectionsByRootId(Integer rootId);

    void deleteUserConnectionsByLeaveId(Integer leaveId);

    @Modifying
    @Query(value = "update UserConnection set root_id = :newRootId where root_id = :oldRootId and leave_id = :leaveId and relation_type = :relationType", nativeQuery = true)
    void updateUserRootOnRelation(@Param("newRootId") Integer newRootId, @Param("oldRootId") Integer oldRootId, @Param("leaveId") Integer leaveId, @Param("relationType") Integer relationType);
}
