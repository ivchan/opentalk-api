/**
 * Created by ivanchan on 4/11/2016.
 */

package opentalk.dao;

import opentalk.domainmodel.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID>, UserRepositoryCustom {
}
