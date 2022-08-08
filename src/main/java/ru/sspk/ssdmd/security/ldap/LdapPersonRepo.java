package ru.sspk.ssdmd.security.ldap;

import java.util.List;

interface LdapPersonRepo {

    List<LdapPerson> getAllUsers();

    List<LdapPerson> getAllDepartamentUsers(LdapPerson chief);

    LdapPerson getPersonByUsername(String username);

}
