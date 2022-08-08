package ru.sspk.ssdmd.security.ldap;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Service
public class LdapPersonImpl implements LdapPersonRepo {

    @Autowired
    private LdapTemplate ldapTemplate;

    @Bean
    public LdapTemplate getLdapTemplate() {
        return new LdapTemplate();
    }

    @Override
    public List<LdapPerson> getAllUsers() {
        return ldapTemplate.search(query().where("objectclass").is("person"), new PersonAttributesMapper());
    }

    @Override
    public List<LdapPerson> getAllDepartamentUsers(LdapPerson chief) {
        new UnsupportedOperationException();
        return null;
    }

    @Override
    public LdapPerson getPersonByUsername(String username) {
        return ldapTemplate.search(query().where("uid").is(username), new PersonAttributesMapper()).get(0);
    }

    private static class PersonAttributesMapper implements AttributesMapper<LdapPerson> {

        public @NotNull LdapPerson mapFromAttributes(Attributes attrs) throws NamingException {
            LdapPerson person = new LdapPerson();
            person.setUserName((String) attrs.get("uid").get());
            person.setDisplayName((String) attrs.get("cn").get());
            person.setGetEmail((String) attrs.get("mail").get());
            return person;
        }
    }
}
