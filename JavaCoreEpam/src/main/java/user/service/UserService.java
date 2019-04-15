package user.service;

import common.solutions.service.BaseService;
import user.domain.User;
import user.search.UserSearchCondition;

import java.util.List;

public interface UserService extends BaseService<Long, User> {
    List<? extends User> search(UserSearchCondition searchCondition);
}
