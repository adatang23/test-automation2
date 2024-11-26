package database.db_sixth_topic.design_patterns.decorator_pattern;

import database.db_fifth_topic.bank.mybatis.mappers.CustomerMapper;
import database.db_fifth_topic.bank.mybatis.model.Customer;
import database.db_fifth_topic.bank.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class RegistrationInformationDisplay extends InformationDisplayDecorator {
    public RegistrationInformationDisplay(InformationDisplay informationDisplay) {
        super(informationDisplay);
    }

    @Override
    public void display(Integer id) {
        super.display(id);
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory(1).openSession(true)) {
            CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
            Customer customer = customerMapper.findById(id);
            if (customer != null) {
                System.out.println("Customer's registration date: " + customer.getRegistration_date());
            } else {
                System.out.println("The customer is not in the table.");
            }
        }
    }
}