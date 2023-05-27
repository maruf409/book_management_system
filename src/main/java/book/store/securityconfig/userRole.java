package book.store.securityconfig;

import com.google.common.collect.Sets;

import java.util.Set;

public enum userRole {

    USERS(Sets.newHashSet(userPermission.AUTHOR_READ, userPermission.BOOK_READ,userPermission.AUTHOR_WRITE)),
    ADMIN(Sets.newHashSet(userPermission.AUTHOR_READ, userPermission.AUTHOR_WRITE, userPermission.BOOK_READ, userPermission.BOOK_WRITE));

    private final Set<userPermission> permissionSet;

    userRole(Set<userPermission> permissionSet) {
        this.permissionSet = permissionSet;
    }

    public Set<userPermission> getPermissionSet() {
        return permissionSet;
    }
}
