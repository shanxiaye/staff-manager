package com.staff.dao;

import java.sql.Date;

import org.apache.ibatis.annotations.Param;

import com.staff.entity.Attendance;

public interface AttendanceDAO extends BaseDAO<Attendance> {
	Integer updateCheckInTime(Attendance at);
	Integer updateDate(Attendance at);
	Integer selectIdAndDate(Attendance at);
	Integer idAndReturn(Attendance at);
	Integer idAndCheckIn(Attendance at);
}
