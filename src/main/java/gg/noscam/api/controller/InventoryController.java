package gg.noscam.api.controller;


import gg.noscam.api.services.InventorySnapshotService;
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
    private final InventorySnapshotService inventorySnapshotService;

    @GetMapping("snapshot/")
    public ResponseEntity<Void> getInventory(){

        inventorySnapshotService.snapshot("76561198452893832","https://steamcommunity.com/tradeoffer/new/?partner=492628104&token=KAj45f-6");

        return new  ResponseEntity<>(HttpStatus.OK);
    }

}
