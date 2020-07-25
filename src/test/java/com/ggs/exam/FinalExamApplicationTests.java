//package com.ggs.exam;
//
//import com.ggs.exam.mapper.BookMapper;
//import com.ggs.exam.mapper.UserMapper;
//import com.ggs.exam.pojo.Book;
//import com.ggs.exam.pojo.BookExample;
//import com.ggs.exam.pojo.User;
//import com.ggs.exam.tools.ExamUtils;
//import org.apache.ibatis.annotations.Param;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
////@SpringBootTest
//class FinalExamApplicationTests {
//
////    @Autowired
////    private UserMapper userMapper;
////
////    @Autowired
////    private BookMapper bookMapper;
////
////    @Autowired
////    private PasswordEncoder passwordEncoder;
////
////    @Test
////    public void test3(){
////        System.out.println(passwordEncoder.encode("123456"));
////    }
//
////
////    @Test
////    void contextLoads() {
////        User user1=new User(ExamUtils.getUUID(),new Date(),"11321324@qq.com","starbug","123456",1,new Date(),"lucy");
////        User user2=new User(ExamUtils.getUUID(),new Date(),"1234@qq.com","starbug","12343256",2,new Date(),"lucy");
////        User user3=new User(ExamUtils.getUUID(),new Date(),"123@qq.com","starbug","12323456",3,new Date(),"lucy");
////        User user4=new User(ExamUtils.getUUID(),new Date(),"123@qq.com","starbug","123123456",4,new Date(),"lucy");
////
////        int count=userMapper.batchInsert(Arrays.asList(user1,user2,user3,user4));
////        System.out.println(count);
////    }
////
////    @Test
////    public void test1(){
////        List<Book> books = bookMapper.selectByExample(new BookExample());
////        BookExample bookExample = new BookExample();
////        books.forEach(book -> {
////            bookExample.createCriteria().andIdEqualTo(book.getId());
////            book.setId(ExamUtils.getUUID());
////            bookMapper.updateByExampleSelective(book,bookExample);
////            bookExample.clear();
////        });
////    }
//
//
//
//}
