package com.nzhang.messenger.messages.dialog;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByDialog(Dialog dialog);
}
