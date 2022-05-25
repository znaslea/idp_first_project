package br.inatel.quotationmanagement.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.inatel.quotationmanagement.model.StockQuotation;

public interface StockQuotationRepository extends JpaRepository<StockQuotation, UUID>{

	Optional<StockQuotation> findByStockId(String stockId);
}
