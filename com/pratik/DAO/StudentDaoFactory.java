package com.pratik.DAO;

import com.pratik.DAO.StudentDao;

import com.pratik.DAO.StudentDaoImpl;

public class StudentDaoFactory {
/*private static StudentDao getStudentDao()
{
	return new StudentDaoImpl();
}*/
		private static StudentDao dao = null;
			static {
					dao = (StudentDao) new StudentDaoImpl();
				}
		public static StudentDao getStudentDao() {
				return dao;
			}
	}