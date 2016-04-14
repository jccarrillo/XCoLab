package org.xcolab.domain.messaging;

import org.xcolab.exceptions.NotFoundException;
import org.xcolab.model.tables.pojos.Message;
import org.xcolab.model.tables.pojos.User_;

import java.util.List;

public interface MessageDao {

    Message getMessage(long messageId) throws NotFoundException;

    int countByGiven(Long senderId, Long recipientId, Boolean isArchived, Boolean isOpened);
    int countBySendingUser(long userId);
    int countByReceivingUserArchived(long userId, boolean isArchived);
    int countByReceivingUserOpened(long userId, boolean isOpened);

    List<Message> findByGiven(int startRecord, int limitRecord,
            Long senderId, Long recipientId, Boolean isArchived, Boolean isOpened);
    List<Message> findByReceivingUserArchived(int startRecord, int limitRecord, long userId, boolean isArchived);
    List<Message> findByReceivingUser(int startRecord, int limitRecord, long userId);
    List<Message> findBySendingUser(int startRecord, int limitRecord, long userId);

    List<User_> getRecipients(long messageId);

    void setArchived(long messageId, long memberId, boolean isArchived);
    void setOpened(long messageId, long memberId, boolean isOpened);

    void createMessage(long messageId, long senderId, long repliesToId, String subject, String content);
    void createMessageRecipient(long messageRecipientStatusId, long messageId, long recipientId);
}
