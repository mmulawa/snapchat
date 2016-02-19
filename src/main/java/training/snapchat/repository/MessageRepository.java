package training.snapchat.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import training.snapchat.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

	@Query("select m from Message m where m.date > :lastMessageDate")
	List<Message> getNewMessages(@Param("lastMessageDate") Date date);

}
