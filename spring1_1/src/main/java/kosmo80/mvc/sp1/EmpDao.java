package kosmo80.mvc.sp1;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.vo.EmpVO;

public class EmpDao {
	Logger logger = Logger.getLogger(EmpDao.class);
	
	// sqlSessionFactory는 Spring에서 연결해주므로,

	// sqlSessionTemplate만 이용해서 dao에서 myBatis를 누릴 수 있도록 하자.
	// cf) @Autowired << 요즘(최신) 방식임 훨씬 편하다 하지만 수동으로 연습해보기 위해서 아래처럼~~
	private SqlSessionTemplate sqlSessionTemplate = null;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public List<Map<String, Object>> getEmpList() {
		logger.info("getEmpList 호출 성공");
		List<Map<String, Object>> empList = null;
//		empList = sqlSessionTemplate.selectList("getEmpList", 7521);
		EmpVO eVO = new EmpVO();
		empList = sqlSessionTemplate.selectList("getEmpList", eVO);
		return empList;
	}
}
