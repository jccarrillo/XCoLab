package org.xcolab.client.members;

import org.xcolab.client.members.legacy.enums.MemberRole;
import org.xcolab.client.members.pojo.Role_;
import org.xcolab.util.http.client.RestResource;
import org.xcolab.util.http.client.RestService;
import org.xcolab.util.http.client.types.TypeProvider;

import java.util.List;

public final class PermissionsClient {

    private static final RestService membersService = new RestService("members-service");
    private static final RestResource<Object> roleGroupResource = new RestResource<>(membersService,
            "roleGroups", new TypeProvider<>(null, null));

    private PermissionsClient() {
    }

    public static boolean canAdminAll(Long memberId) {
        return memberHasRole(memberId, MemberRole.ADMINISTRATOR.getRoleId());
    }

    public static boolean canJudge(Long memberId, Long contestId) {
        return memberHasRoleInContest(memberId, contestId, MemberRole.JUDGE);
    }

    public static boolean canFellow(Long memberId, Long contestId) {
        return memberHasRoleInContest(memberId, contestId, MemberRole.FELLOW);
    }

    public static boolean canIAF(Long memberId) {
        return memberHasRole(memberId, MemberRole.IMPACT_ASSESSMENT_FELLOW.getRoleId());
    }

    public static boolean canStaff(Long memberId) {
        return memberHasRole(memberId, MemberRole.STAFF.getRoleId());
    }

    public static boolean hasRoleGroup(long memberId, long roleGroupId) {
        final List<Role_> roles = roleGroupResource
                        .getSubResource(roleGroupId, "roles", Role_.TYPES)
                .list()
                .cacheIdentifier("memberId_" + memberId + "_roleGroupId_" + roleGroupId)
                .execute();
        for (Role_ role : roles) {
            if (memberHasRole(memberId, role.getRoleId())) {
                return true;
            }
        }
        return canAdminAll(memberId);
    }

    private static boolean memberHasRole(Long memberId, long roleIdToTest) {
        List<Role_> roles = MembersClient.getMemberRoles(memberId);
        if (roles != null && !roles.isEmpty()) {
            for (Role_ role : roles) {
                if (role.getRoleId() == roleIdToTest) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean memberHasRoleInContest(Long memberId, Long contestId, MemberRole roleToTest) {
        List<Role_> roles = MembersClient.getMemberRolesInContest(memberId, contestId);
        if (roles != null && !roles.isEmpty()) {
            for (Role_ role : roles) {
                if (role.getRoleId() == roleToTest.getRoleId()) {
                    return true;
                }
            }
        }
        return false;
    }
}
