package org.xcolab.domain.contact;

import org.xcolab.model.tables.pojos.Contact_;

public interface ContactDao {

    Contact_ getContact(Long memberId);
}
