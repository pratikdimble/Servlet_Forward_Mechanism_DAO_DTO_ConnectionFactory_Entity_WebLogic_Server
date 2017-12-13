package com.pratik.DAO;

import com.pratik.DTO.StudentDTO;

public interface StudentDao {
public String add(String sid, String sname, String sresult);
	
		public StudentDTO search(String sid);
			public StudentDTO getStudent(String sid);
				public String update(String sid, String sname,String sresult);
					public String delete(String sid);
}