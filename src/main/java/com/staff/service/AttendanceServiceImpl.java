package com.staff.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staff.dao.AttendanceDAO;
import com.staff.entity.Attendance;
@Service
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	private AttendanceDAO attendanceDAO;

	public List<Attendance> selectAll() {
		return attendanceDAO.selectAll();
	}

	public Integer insert(Attendance t) {
		return attendanceDAO.insert(t);
	}

	public Integer update(Attendance t) {
		return attendanceDAO.update(t);
	}

	public Integer delete(Integer id) {
		return attendanceDAO.delete(id);
	}

	public Integer updateCheckInTime(Timestamp checkInTime, Integer id) {
		Attendance at = new Attendance(null, id, null, null, checkInTime, null, null);
		return attendanceDAO.updateCheckInTime(at);
	}

	public Integer updateDate(Timestamp date, Integer id) {
		Attendance at = new Attendance(null, id, null, null, null, date, null);
		return attendanceDAO.updateDate(at);
	}

	public Integer selectIdAndDate(Integer id, Date dateTime) {
		Attendance at = new Attendance(null, id, null, dateTime, null, null, null);
		return attendanceDAO.selectIdAndDate(at);
	}

	public Integer idAndReturn(Integer id, Date dateTime) {
		Attendance at = new Attendance(null, id, null, dateTime, null, null, null);
		return attendanceDAO.idAndReturn(at);
	}

	public Integer idAndCheckIn(Integer id, Date dateTime) {
		Attendance at = new Attendance(null, id, null, dateTime, null, null, null);
		return attendanceDAO.idAndCheckIn(at);
	}

}
