package flower_delivery_server.repository;

import flower_delivery_server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select b from User b where b.email = :email")
    User findByEmail(@Param("email") String email);
}
