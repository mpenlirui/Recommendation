package com.personal.recommendation.dao;

import com.personal.recommendation.model.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Users表DAO
 */
@Service
public interface UsersDAO {

    String TABLE = "users";

    @Select("select * from " + TABLE + " where id = #{userId}")
    Users getUserById(@Param("userId") long userId);

    @Select({
            "<script>",
            "select * from " + TABLE + " where id in",
            "<foreach collection='userIds' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    List<Users> getUserByIds(@Param("userIds") List<Long> userIds);

    @Update("update " + TABLE + " set latest_log_time=#{timestamp} where id > 0")
    void updateTimeStamp(@Param("timestamp") Date timestamp);

    @Select("select id from " + TABLE)
    List<Long> getAllUserIds();

    @Select("select * from " + TABLE)
    List<Users> getAllUsers();

    @Update("update " + TABLE + " set pref_list = #{newPrefStr} where id = #{userId}")
    void updatePrefListById(@Param("userId") long userId, @Param("newPrefStr") String newPrefStr);

    @Update("update " + TABLE + " set pref_list = #{newPrefStr},user_profile = #{userProfile} where id = #{userId}")
    void updatePrefAndProfileById(@Param("userId") long userId, @Param("newPrefStr") String newPrefStr,
                            @Param("userProfile") String userProfile);

}
