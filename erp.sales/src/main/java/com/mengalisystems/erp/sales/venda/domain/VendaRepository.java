package com.mengalisystems.erp.sales.venda.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {


}
