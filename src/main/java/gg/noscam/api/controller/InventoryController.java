package gg.noscam.api.controller;


import gg.noscam.api.dto.items.custody.ItemCustodyRequestDTO;
import gg.noscam.api.dto.steamWebApi.InventoryAssetInfo;
import gg.noscam.api.models.inventory.InventorySnapshot;
import gg.noscam.api.services.InventorySnapshotService;
import gg.noscam.api.services.ItemCustodyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory/")
@RequiredArgsConstructor
public class InventoryController {

    @Autowired
    private final ItemCustodyService itemCustodyService;

    @Autowired
    private final InventorySnapshotService inventorySnapshotService;

    @GetMapping("snapshot/")
    public ResponseEntity<Void> getInventory(){

        /*
        To do:
            Implement @AuthenticationPrincipal in order to safely obtain steamId from the user , never from request parameters or payloads
        */

        InventorySnapshot inventorySnapshot = inventorySnapshotService.takeSnapshot("","");

        for (InventoryAssetInfo assetInfo : inventorySnapshot.getAssetIds()) {

            ItemCustodyRequestDTO itemDto = new ItemCustodyRequestDTO(
                    assetInfo.assetid(),
                    assetInfo.inspectlink(),
                    "",
                    assetInfo.istradelocked()
            );

            itemCustodyService.registerItemCustody(itemDto);
        }

        return new  ResponseEntity<>(HttpStatus.OK);
    }

}
