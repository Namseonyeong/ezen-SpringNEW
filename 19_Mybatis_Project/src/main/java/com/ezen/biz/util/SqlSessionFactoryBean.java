package com.ezen.biz.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 *  DB를 접속하고 실행하고자 하는 SQL 제출할때 사용
 */
public class SqlSessionFactoryBean {
	private static SqlSessionFactory sessionFactory = null;

	static {
		if (sessionFactory == null) {
			try {
				// 설정파일을 읽기 위한 스트림 생성
				Reader reader = Resources.getResourceAsReader("sql-map-config.xml");
				sessionFactory = (SqlSessionFactory) new SqlSessionFactoryBuilder().build(reader);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 위에서 생선된 DB 연결세션을 다른 메소드에 제공
	 */
	public static SqlSession getSqlSessionInstance() {
		return sessionFactory.openSession();
	}
}
