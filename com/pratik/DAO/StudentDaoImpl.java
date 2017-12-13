package com.pratik.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pratik.factory.ConnectionFactory;
import com.pratik.DTO.StudentDTO;

public class StudentDaoImpl implements StudentDao {
	String status = "";
		@Override
			public String add(String sid, String sname, String sresult) {
				try {
						Connection con = ConnectionFactory.getConnection();
							PreparedStatement pst = con.prepareStatement("select * from student where sid=?");
								pst.setString(1, sid);
									ResultSet rs = pst.executeQuery();
										boolean b = rs.next();
											if(b == true) {
												status = "existed";
											}else {
												pst = con.prepareStatement("insert into student values(?,?,?)");
												pst.setString(1, sid);
												pst.setString(2, sname);
												pst.setString(3, sresult);
												pst.executeUpdate();
												status = "success";
											}
					} catch (Exception e) {
							status = "failure";
								e.printStackTrace();
						}
				return status;
			}
	public StudentDTO getStudent(String sid) {
		StudentDTO sto = null;
			try {
				Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement("select * from student where sid = ?");
						pst.setString(1, sid);
							ResultSet rs = pst.executeQuery();
								boolean b = rs.next();
									if(b == true) {
										sto = new StudentDTO();
											sto.setSid(rs.getString("SID"));
												sto.setSname(rs.getString("SNAME"));
													sto.setSresult(rs.getString("SRESULT"));
									}else {
											sto = null;
										}
				} catch (Exception e) {
					e.printStackTrace();
			}
			return sto;
	}
		@Override
			public StudentDTO search(String sid) {
				StudentDTO sto = getStudent(sid);
					return sto;
			}

@Override
	public String update(String sid, String sname, String sresult) {
		try {
				Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement("update student set sname = ? , sresult = ? where sid = ?");
							pst.setString(1, sname);
							pst.setString(2, sresult);
							pst.setString(3, sid);
							pst.executeUpdate();
					status = "success";
		} catch (Exception e) {
				status = "failure";
				e.printStackTrace();
		}
		return status;
	}

@Override
	public String delete(String sid) {
		try {
				StudentDTO sto = getStudent(sid);
				if(sto == null) {
						status = "notexisted";
				}else {
					Connection con = ConnectionFactory.getConnection();
						PreparedStatement pst = con.prepareStatement("delete from student where sid = ?");
							pst.setString(1, sid);
								pst.executeUpdate();
									status = "success";
					}

		} catch (Exception e) {
				status = "failure";
					e.printStackTrace();
					}
			return status;
		}

	}
