package training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import training.snapchat.entity.Message;

public interface MessageRepository extends JpaRepository<Message,Long> {

}
