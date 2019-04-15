package user.repo;

import common.solutions.repo.BaseRepo;
import user.domain.User;
import user.search.UserSearchCondition;

import java.util.List;

public interface UserRepo extends BaseRepo<Long, User> {
    List<? extends User> search(UserSearchCondition searchCondition);
}
