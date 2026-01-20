package gg.noscam.api.repositories;

import gg.noscam.api.models.itemCustody.ItemCustody;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCustodyReposity extends JpaRepository<ItemCustody, Long> {
}
