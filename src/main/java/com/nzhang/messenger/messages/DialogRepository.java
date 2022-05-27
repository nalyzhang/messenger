package com.nzhang.messenger.messages;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DialogRepository extends JpaRepository<Dialog, Long> {

    List<Dialog> findByUID(Long UID);

}