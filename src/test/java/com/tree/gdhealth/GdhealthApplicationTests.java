package com.tree.gdhealth;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.*;

import java.sql.*;
import static org.assertj.core.api.Assertions.*;

/**
 * @author  정인호 <br>
 * 데이터베이스 연결 확인용 테스트
 */

@Slf4j
@SpringBootTest
class GdhealthApplicationTests {

	@Autowired
	DataSource dataSource;

	@Test
	void 데이터베이스연결을확인하고_데이터를가져온다() throws SQLException {
		//given
		Connection conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select testContent from test");
		String assertStr = null;

		//when
		ResultSet rs = ps.executeQuery();

		//then
		if(rs.next()){
			assertStr = rs.getString(1);
		}
		rs.close();
		ps.close();
		conn.close();

		log.info("assertStr = {}", assertStr);
		assertThat(assertStr).isNotNull();
	}

}
