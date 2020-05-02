package com.zhineng.test.biz.impl.impl;

import com.zhineng.test.biz.impl.MessageService;
import com.zhineng.test.dao.MessageDao;
import com.zhineng.test.domain.po.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;

    @Override
    public Message sendMessageToUser(Integer user_id, String content) {
        Message message = new Message();
        message.setMessageContent(content);
        message.setUserId(user_id);
        message.setMessageStatus(0);
        return messageDao.save(message);
    }

    @Override
    public List<Message> sendMessagesToUsers(List<Integer> user_ids, String content) {
        List<Message> messageList = new ArrayList<Message>();
        for (Integer user_id: user_ids) {
            Message message = new Message();
            message.setMessageContent(content);
            message.setUserId(user_id);
            message.setMessageStatus(0);
            messageList.add(messageDao.save(message));
        }
        return messageList;
    }

    @Override
    public Message readMessageStatus(Integer messageId) {
        Message message = messageDao.findMessageByMessageId(messageId);
        message.setMessageStatus(1);
        return messageDao.save(message);
    }
}
