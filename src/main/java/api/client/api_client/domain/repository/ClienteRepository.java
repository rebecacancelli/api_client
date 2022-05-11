package api.client.api_client.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.client.api_client.domain.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    
}
