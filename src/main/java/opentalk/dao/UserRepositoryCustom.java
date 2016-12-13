/**
 * Created by ivanchan on 4/11/2016.
 */

package opentalk.dao;

import opentalk.domainmodel.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepositoryCustom {
    @Query("SELECT r FROM User r where r.userID = :userID")
    User findOne(@Param("userID")String userID);
}

