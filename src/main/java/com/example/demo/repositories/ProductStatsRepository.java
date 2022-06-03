package com.example.demo.repositories;

import com.example.demo.entities.ProductStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductStatsRepository extends JpaRepository<ProductStats, String> {

    @Query(nativeQuery = true,
            value = " select category, sum, prc*100 prc from " +
                    "( select distinct t.category, sum(p.price * p.in_stock) " +
                    "over " +
                    "(partition by t.category order by  t.category) sum," +
                    " sum(p.price * p.in_stock) over (partition by t.category order by  t.category) / sum(p.price * p.in_stock)" +
                    " over () prc from products p" +
                    " join types t on t.id = p.type_id " +
                    "where" +
                    " p.in_stock > 0) subquery ")
    List<ProductStats> getStatistics();

}
