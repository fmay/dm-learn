package repositories.user;

import models.User;

public class SimpleAddUserRepository implements ISimpleAddUserRepository {

    @Override
    public User execute(User user) {

        return user;
    }

}
