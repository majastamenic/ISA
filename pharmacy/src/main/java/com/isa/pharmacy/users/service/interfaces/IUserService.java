package com.isa.pharmacy.users.service.interfaces;

import com.isa.pharmacy.users.controller.dto.PasswordChangeDto;
import com.isa.pharmacy.users.domain.User;

import java.util.List;

public interface IUserService {

     User create(User user);

     User updateUser(User user);

     User updateUserPassword(User user);

     User login(User user);

     User updatePassword(PasswordChangeDto passwordDto);

     User getById(Long id);

     User getByEmail(String email);

     List<User> getAll();

     User save(User user);
}
