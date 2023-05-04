package com.letsconnecot.serviceimpl;

import com.letsconnecot.config.JwtUserDetailsService;
import com.letsconnecot.config.JwtUtil;
import com.letsconnecot.dto.LoginDto;
import com.letsconnecot.dto.LoginResponseDto;
import com.letsconnecot.model.Employee;
import com.letsconnecot.repository.EmployeeRepository;
import com.letsconnecot.service.LoginService;
import com.letsconnecot.utils.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class LoginServiceImpl<T> implements LoginService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JwtUserDetailsService detailsService;

    @Autowired
    private JwtUtil jwtutils;

    private final static Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Override
    public T login(LoginDto loginDto) {




            log.info("LoginServiceImpl::loginUser()::findByEmailOrMobileNumber()");
          LoginResponseDto loginResponseDto= new LoginResponseDto();
            Optional<Employee> empFromDb = this.employeeRepository.findByEmail(loginDto.getUsername());
            if (empFromDb.isPresent()) {

                if (loginDto.getPassword().equals(empFromDb.get().getPassword())) {

                    log.info("LoginServiceImpl::loginUser()::loadUserByUsername()");
                    UserDetails userDetails = this.detailsService.loadUserByUsername(loginDto.getUsername());
                    log.info("LoginServiceImpl::loginUser()::generateToken()");
                    Map<String, Object> claims = new HashMap<String, Object>();
                    String token = jwtutils.generateToken(userDetails, claims);
                    HashMap<String , String > res = new HashMap<>();
                    res.put("jwtToken", token);
                    log.info("LoginServiceImpl::loginUser()=== END");
                    loginResponseDto.setData(res);
                    loginResponseDto.setMessage("Login Successful");
                    return (T) loginResponseDto;

                } else {
                    log.error("LoginServiceImpl::loginUser::ERROR= {}", Message.INVALID_PASSWORD);
                    loginResponseDto.setMessage(" User is Exist but Incorrect password");

                }

            } else {
                log.error("LoginServiceImpl::loginUser::ERROR= {}", Message.USER_NOT_EXIST);
               loginResponseDto.setMessage("User not exist");

            }
           return (T) loginResponseDto;

    }
}
