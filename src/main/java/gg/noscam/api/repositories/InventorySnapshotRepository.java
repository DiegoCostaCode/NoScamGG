package gg.noscam.api.repositories;

import gg.noscam.api.models.inventory.InventorySnapshot;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventorySnapshotRepository extends MongoRepository<InventorySnapshot, String> {
}
