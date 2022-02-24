package br.com.ialmeida.workshopmongodb.repositories;

import br.com.ialmeida.workshopmongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
