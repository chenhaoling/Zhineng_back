package com.zhineng.test.dao;

import com.zhineng.test.domain.po.ExtraUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtraUserInfoDao extends JpaRepository<ExtraUserInfo, Integer> {

    List<ExtraUserInfo> findExtraUserInfosByUserId(Integer userId);

    ExtraUserInfo findExtraUserInfoByUserIdAndExtraInfoTitle(Integer userId, String infoTitle);

    void deleteExtraUserInfosByUserId(Integer userId);

    @Modifying
    @Query(value = "update ExtraUserInfo set extra_info_title = :newInfoTitle where extra_info_title = :oldInfoTitle", nativeQuery = true)
    void updateInfoTitle(@Param("newInfoTitle") String newInfoTitle, @Param("oldInfoTitle") String oldInfoTitle);

    @Modifying
    @Query(value = "update ExtraUserInfo set extra_info_content = :newInfoContent where extra_info_title = :infoTitle and user_id = :userId", nativeQuery = true)
    void updateUserInfo(@Param("newInfoContent") String newInfoContent, @Param("infoTitle") String infoTitle, @Param("userId") Integer userId);

}
