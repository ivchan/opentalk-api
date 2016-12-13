/**
 * Created by ivanchan on 4/11/2016.
 */

package opentalk.dao;

import opentalk.domainmodel.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, UUID>, UserRepositoryCustom {
}
