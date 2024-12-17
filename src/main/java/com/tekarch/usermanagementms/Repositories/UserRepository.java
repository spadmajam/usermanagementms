package com.tekarch.usermanagementms.Repositories;

import com.tekarch.usermanagementms.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
