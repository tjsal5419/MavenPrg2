package com.newlecture.web.dao.spring;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;

public class SpringMemberDao extends SimpleJdbcDaoSupport implements MemberDao{

	//private PlatformTransactionManager transactionManager;
/*	@Autowired
	private TransactionTemplate transactionTemplate;
   */
   /*private DataSource dataSource;
   
   private JdbcTemplate jdbcTemplate;

   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplate =new JdbcTemplate(dataSource);
   }*/

	

	@Override
	public Member get(String id) {
      // TODO Auto-generated method stub
      return null;
   }



	@Override
   public List<Member> getList(String id) {
      // TODO Auto-generated method stub
      return getList(id,"","");
   }
   
   @Override
   public List<Member> getList(String id, String pwd, String name) {
      // TODO Auto-generated method stub
	   String sql="SELECT MID id, PWD pwd FROM MEMBER WHERE MID LIKE ?";
	   String sql1="INSERT INTO NOTICE(CODE, TITLE, WRITER, HIT) VALUES('999', 'hi','sm',0)";
       String sql2="UPDATE MEMBER SET POINT=POINT+1 WHERE MID='newlec'";
	   	
       
/*       transactionTemplate.execute(new TransactionCallbackWithoutResult() {
		
		@Override
		protected void doInTransactionWithoutResult(TransactionStatus arg0) {
			// 트랜잭션이 필요한 부분을 넣어준다.
			getJdbcTemplate().update(sql1);
			getJdbcTemplate().update(sql2);			
		}
		
       	});
*/
         //TransactionDefinition def = new DefaultTransactionDefinition();
         //TransactionStatus status = transactionManager.getTransaction(def);


         //transactionManager.commit(status);
         
         
        return getJdbcTemplate().query(sql,
               new BeanPropertyRowMapper(Member.class),
               String.format("%%%s%%", id));

   
      /*
       * return jdbcTemplate.query(sql, new RowMapper<Member>(){ public Member
       * mapRow(ResultSet rs, int rowNum) throws SQLException{
       * 
       * Member m = new Member();
       * 
       * m.setId(rs.getString("mid")); m.setPwd(rs.getString("pwd"));
       * 
       * return null; } });
       */

   }

   /*@Override
   public List<Member> getList(String id, String pwd, String name) {
      
      String sql ="SELECT MID id,PWD pwd FROM MEMBER WHERE MID LIKE ?";
      
      
      
      return getJdbcTemplate().query(sql, 
            new BeanPropertyRowMapper(Member.class),
            String.format("%%%s%%", id));
      
      String sql ="SELECT MID,PWD FROM MEMBER";
      
      return getJdbcTemplate().query(sql, new RowMapper<Member>(){
            public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
               
              Member m = new Member();
              
              m.setId(rs.getString("mid"));
              m.setPwd(rs.getString("pwd"));
               
               return m;
            }
         });
      
   }*/

   @Override
   public List<Member> getList() {
      // TODO Auto-generated method stub
      return getList("","","");
   }

   @Override
   public int add(Member member) {
      // TODO Auto-generated method stub
      return 0;
   }

}