package org.xcolab.domain.role;

import org.xcolab.model.tables.pojos.Role_;

import java.util.List;

public interface RoleDao {
    List<Role_> getMemberRoles(Long memberId);
}
