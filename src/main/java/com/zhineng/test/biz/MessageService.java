package com.zhineng.test.biz;

import com.zhineng.test.dao.MessageDao;
import com.zhineng.test.domain.po.Message;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface MessageService {

    Message sendMessageToUser(Integer user_id, String content);

    List<Message> sendMessagesToUsers(List<Integer> user_ids, String content);

    Message readMessageStatus(Integer messageId);
}
