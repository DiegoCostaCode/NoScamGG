package gg.noscam.api.repositories;

import gg.noscam.api.models.inventory.ItemDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemDetailsRepository extends MongoRepository<ItemDetails, String> {
}
