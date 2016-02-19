package training.snapchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import training.snapchat.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
