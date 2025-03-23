package com.secor.ecommerceinventoryservice;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "inventories")
@Getter @Setter
public class Inventory {

    @Id
    private String inventoryid;
    private String productid;
    private String stock_qauntity;
    private String last_updated_at;

}
