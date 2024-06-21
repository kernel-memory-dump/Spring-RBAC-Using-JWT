package co.decem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.decem.dao.RoleDao;
import co.decem.model.Role;
import co.decem.service.RoleService;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role findByName(String name) {
        // Find role by name using the roleDao
        Role role = roleDao.findRoleByName(name);
        return role;
    }
}
