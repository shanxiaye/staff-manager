package com.staff.service;

import java.sql.Date;


import com.staff.entity.Attendance;

public interface AttendanceService extends BaseService<Attendance>{
	Integer updateCheckInTime(java.sql.Timestamp checkInTime, Integer id);

	Integer updateDate(java.sql.Timestamp date, Integer id);
	Integer selectIdAndDate(Integer id,Date dateTime);
	Integer idAndReturn(Integer id, Date dateTime);
	Integer idAndCheckIn(Integer id, Date dateTime);
}
