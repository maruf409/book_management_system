package book.store.securityconfig;

public enum userPermission {

    AUTHOR_READ("author:read"),
    AUTHOR_WRITE("author:write"),
    BOOK_READ("book:read"),
    BOOK_WRITE("book:write");

    private final String permission;

    userPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
