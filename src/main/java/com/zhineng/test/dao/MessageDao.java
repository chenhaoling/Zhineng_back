package com.zhineng.test.dao;

import com.zhineng.test.domain.po.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao extends JpaRepository<Message, Integer> {

    List<Message> findMessagesByUserId(Integer userId);

    List<Message> findMessagesByUserIdAndMessageStatus(Integer userId, Integer status);

    void deleteMessagesByUserId(Integer userId);

    @Modifying
    @Query(value = "update Message set message_status = :status where user_id = :userId", nativeQuery = true)
    void updateMessageStatus(@Param("status") Integer status, @Param("userId") Integer userId);
}
