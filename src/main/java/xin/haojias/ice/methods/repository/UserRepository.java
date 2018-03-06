package xin.haojias.ice.methods.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xin.haojias.ice.methods.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByName(String name);

    @Query("select u from User u where u.name=:name")
    User findUser(@Param("name") String name);

}
