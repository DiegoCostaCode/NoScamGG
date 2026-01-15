package gg.noscam.api.repositories;

import gg.noscam.api.models.inventory.ItemCustody;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCustodyReposity extends JpaRepository<ItemCustody, Long> {
}
