package com.bedu.repository;
import org.springframework.data.repository.CrudRepository;

import com.bedu.model.Users;
public interface UsersRepository extends CrudRepository<Users, Integer>
{
}
