package api.client.api_client.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.client.api_client.domain.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
    
}
